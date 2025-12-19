package com.example.phalanx;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class ListFragment extends Fragment {

    public static Integer userId;
    public Users user;
    public ArrayList<ListInfo> listInfo;
    public ArrayList<ListColumn> columns;
    public static ArrayList<String> priorite;
    public ArrayAdapter<String> adapter;
    public TextView titre;
    public EditText titreModif;
    public ViewPager2 viewpager;
    public SharedPreferences sharedpreferences;
    public TasksRepository tasksRepository = TasksRepository.getInstance();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_list, null);
        viewpager = v.findViewById(R.id.SlideList);

        sharedpreferences = getActivity().getSharedPreferences("shared_pref", getActivity().MODE_PRIVATE);
        try {
            UsersRepository.getInstance().getUser(1, sharedpreferences);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        user = gson.fromJson(sharedpreferences.getString("user", ""), Users.class);

        listInfo = user.getListgroup();
        columns = listInfo.get(0).getListColumns();

        ListSlideAdapter listSlideAdapter = new ListSlideAdapter(columns);
        viewpager.setAdapter(listSlideAdapter);

        priorite = new ArrayList<String>();
        priorite.add("Low");
        priorite.add("Normal");
        priorite.add("Important");
        priorite.add("Urgent");


        TextView nomPrenom = v.findViewById(R.id.NomPrenom);
        nomPrenom.setText(String.format("%s %s", user.getLastname(), user.getFirstname()));

        titre = v.findViewById(R.id.TitreList);
        titre.setText(listInfo.get(0).getTitle());
        titreModif = v.findViewById(R.id.TitreListModif);

        Button btn = v.findViewById(R.id.btn_modifierlist);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                titre.setVisibility(View.INVISIBLE);
                titreModif.setVisibility(View.VISIBLE);
            }
        });

        titreModif.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) ||
                        (actionId == EditorInfo.IME_ACTION_DONE) || (actionId == EditorInfo.IME_ACTION_GO)) {
                    titre.setText(titreModif.getText().toString());
                    titreModif.setVisibility(View.INVISIBLE);
                    titre.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });

        ImageButton btnAdd = v.findViewById(R.id.buttonAddTasks);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ajouterTask();
            }
        });
        return v;
    }

    public static void setId(Integer id){
        userId = id;
    }

    private void ajouterTask(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.ajouter_task);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.task);

        adapter = new ArrayAdapter<>(getContext(), R.layout.item_priorite, priorite);
        AutoCompleteTextView prio = dialog.findViewById(R.id.PrioriteOptions);
        prio.setAdapter(adapter);

        Button btnAnnuller = dialog.findViewById(R.id.buttonAnnuler);
        btnAnnuller.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                dialog.dismiss();
            }
        });

        Button btnValider = dialog.findViewById(R.id.buttonValider);
        btnValider.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText titreModif = dialog.findViewById(R.id.NomDialogModif);
                EditText descriptionModif = dialog.findViewById(R.id.DescriptionDialogModif);
                ArrayList<Task> tasks = columns.get(viewpager.getCurrentItem()).tasks;
                if(tasks==null){
                    columns.get(viewpager.getCurrentItem()).tasks = new ArrayList<>();
                }
                columns.get(viewpager.getCurrentItem()).tasks.add(new Task(titreModif.getText().toString(), descriptionModif.getText().toString(),
                        null, new Date(), "En Cours", prio.getText().toString()));
                ListSlideAdapter listSlideAdapter = new ListSlideAdapter(columns);
                viewpager.setAdapter(listSlideAdapter);
                tasksRepository.postTask(titreModif.getText().toString(), descriptionModif.getText().toString(), null,
                        new Date(),"En Cours",prio.getText().toString(),
                        columns.get(viewpager.getCurrentItem()).getId_column(), 1, success -> {
                    requireActivity().runOnUiThread(() -> {
                        if (success) {
                        } else {
                            Toast.makeText(getContext(), "Erreur", Toast.LENGTH_SHORT).show();
                        }
                    });
                });
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
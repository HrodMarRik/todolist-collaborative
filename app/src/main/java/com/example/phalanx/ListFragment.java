package com.example.phalanx;

import android.app.Dialog;
import android.os.Bundle;
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
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Date;

public class ListFragment extends Fragment {

    public ArrayList<Task> tasks;
    public ArrayList<Users> user;
    public static ArrayList<String> priorite;
    public ArrayAdapter<String> adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_list, null);

        tasks = new ArrayList<Task>();
        tasks.add(new Task("Manger", "Ne pas oublier de manger son repas!", null, new Date(), "En Cours", "Important"));
        tasks.add(new Task("Dormir", "Ne pas oublier de manger dormir au moins pendant 8h!", null, new Date(), "En Cours", "Important"));

        priorite = new ArrayList<String>();
        priorite.add("Low");
        priorite.add("Normal");
        priorite.add("Important");
        priorite.add("Urgent");

        ListView listTasks = v.findViewById(R.id.ListTasks);
        TaskAdapter adapterTask = new TaskAdapter(getContext(), tasks);
        listTasks.setAdapter(adapterTask);

        user= new ArrayList<Users>();
        user.add(new Users("Kitty", "Hello","h.kitty@gmail.com","test", null,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFAGCYo7D-fxye-My-HsVK6jX5q9FwMtot7g&s"));

        TextView nomPrenom = v.findViewById(R.id.NomPrenom);
        nomPrenom.setText(String.format("%s %s", user.get(0).getNom(), user.get(0).getPrenom()));

        Button btn = v.findViewById(R.id.btn_modifierlist);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView titre = v.findViewById(R.id.TitreList);
                titre.setVisibility(View.INVISIBLE);

                EditText titreModif = v.findViewById(R.id.TitreListModif);
                titreModif.setVisibility(View.VISIBLE);
            }
        });

        EditText titreModif = v.findViewById(R.id.TitreListModif);
        titreModif.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) ||
                        (actionId == EditorInfo.IME_ACTION_DONE) || (actionId == EditorInfo.IME_ACTION_GO)) {
                    EditText titreModif = v.findViewById(R.id.TitreListModif);
                    TextView titre = v.findViewById(R.id.TitreList);

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

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
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
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Date;

public class ListFragment extends Fragment {

    public ArrayList<Task> tasks;
    public ArrayList<Task> tasks02;
    public ArrayList<Column> columns;
    public ArrayList<Users> user;
    public static ArrayList<String> priorite;
    public ArrayAdapter<String> adapter;
    public TextView titre;
    public EditText titreModif;
    public ListView listTasks;
    public ViewPager2 viewpager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_list, null);
        viewpager = v.findViewById(R.id.SlideList);

        tasks = new ArrayList<Task>();
        tasks.add(new Task("Manger", "Ne pas oublier de manger son repas!", null, new Date(), "En Cours", "Important"));
        tasks.add(new Task("Dormir", "Ne pas oublier de manger dormir au moins pendant 8h!", null, new Date(), "En Cours", "Important"));

        tasks02 = new ArrayList<Task>();
        tasks02.add(new Task("Boire", "Ne pas oublier de boire pendant la journée!", null, new Date(), "En Cours", "Important"));

        columns = new ArrayList<>();
        columns.add(new Column("Colonne 01", tasks));
        columns.add(new Column("Colonne 02", tasks02));

        ListSlideAdapter listSlideAdapter = new ListSlideAdapter(columns);
        viewpager.setAdapter(listSlideAdapter);

        priorite = new ArrayList<String>();
        priorite.add("Low");
        priorite.add("Normal");
        priorite.add("Important");
        priorite.add("Urgent");

        user= new ArrayList<Users>();
        user.add(new Users("Kitty", "Hello","h.kitty@gmail.com","test", null,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFAGCYo7D-fxye-My-HsVK6jX5q9FwMtot7g&s"));

        TextView nomPrenom = v.findViewById(R.id.NomPrenom);
        nomPrenom.setText(String.format("%s %s", user.get(0).getNom(), user.get(0).getPrenom()));

        titre = v.findViewById(R.id.TitreList);
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
                columns.get(viewpager.getCurrentItem()).tasks.add(new Task(titreModif.getText().toString(), descriptionModif.getText().toString(),
                        null, new Date(), "En Cours", prio.getText().toString()));
                ListSlideAdapter listSlideAdapter = new ListSlideAdapter(columns);
                viewpager.setAdapter(listSlideAdapter);

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
package com.example.phalanx;

import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Date;

public class ListActivity extends AppCompatActivity {

    public ArrayList<Task> tasks;
    public ArrayList<Users> user;
    public static ArrayList<String> priorite;
    public ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist);

        tasks = new ArrayList<Task>();
        tasks.add(new Task("Manger", "Ne pas oublier de manger son repas!", null, new Date(), "En Cours", "Important"));
        tasks.add(new Task("Dormir", "Ne pas oublier de manger dormir au moins pendant 8h!", null, new Date(), "En Cours", "Important"));

        priorite = new ArrayList<String>();
        priorite.add("Low");
        priorite.add("Normal");
        priorite.add("Important");
        priorite.add("Urgent");

        ListView listTasks = findViewById(R.id.ListTasks);
        TaskAdapter adapterTask = new TaskAdapter(this, tasks);
        listTasks.setAdapter(adapterTask);

        user= new ArrayList<Users>();
        user.add(new Users("Kitty", "Hello","h.kitty@gmail.com","test", null,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFAGCYo7D-fxye-My-HsVK6jX5q9FwMtot7g&s"));

        TextView nomPrenom = findViewById(R.id.NomPrenom);
        nomPrenom.setText(String.format("%s %s", user.get(0).getNom(), user.get(0).getPrenom()));

        Button btn = findViewById(R.id.btn_modifierlist);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView titre = findViewById(R.id.TitreList);
                titre.setVisibility(View.INVISIBLE);

                EditText titreModif = findViewById(R.id.TitreListModif);
                titreModif.setVisibility(View.VISIBLE);
            }
        });

        EditText titreModif = findViewById(R.id.TitreListModif);
        titreModif.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) ||
                        (actionId == EditorInfo.IME_ACTION_DONE) || (actionId == EditorInfo.IME_ACTION_GO)) {
                    EditText titreModif = findViewById(R.id.TitreListModif);
                    TextView titre = findViewById(R.id.TitreList);

                    titre.setText(titreModif.getText().toString());

                    titreModif.setVisibility(View.INVISIBLE);
                    titre.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });

        ImageButton btnAdd = findViewById(R.id.buttonAddTasks);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ajouterTask();

            }
        });
    }

    private void ajouterTask(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.ajouter_task);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.task);

        adapter = new ArrayAdapter<>(this, R.layout.item_priorite, priorite);
        AutoCompleteTextView prio = dialog.findViewById(R.id.PrioriteOptions);
        prio.setAdapter(adapter);

        Button btnAnnuller = dialog.findViewById(R.id.buttonAnnuler);
        btnAnnuller.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
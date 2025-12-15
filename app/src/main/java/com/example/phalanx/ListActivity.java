package com.example.phalanx;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;
import java.util.Date;

public class ListActivity extends AppCompatActivity {

    public ArrayList<Task> tasks;
    public ArrayList<Users> user;
    public ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist);

        tasks = new ArrayList<Task>();
        tasks.add(new Task("Manger", "Ne pas oublier de manger son repas!", null, new Date(), "En Cours", "Important"));
        tasks.add(new Task("Dormir", "Ne pas oublier de manger dormir au moins pendant 8h!", null, new Date(), "En Cours", "Important"));

        ListView listTasks = findViewById(R.id.ListTasks);
        TaskAdapter adapter = new TaskAdapter(this, tasks);
        listTasks.setAdapter(adapter);

        user= new ArrayList<Users>();
        user.add(new Users("Kitty", "Hello","h.kitty@gmail.com","test", null,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFAGCYo7D-fxye-My-HsVK6jX5q9FwMtot7g&s"));

        TextView nomPrenom = findViewById(R.id.NomPrenom);
        nomPrenom.setText(user.get(0).getNom()+ " " + user.get(0).getPrenom());

    }

}
package com.example.phalanx;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class ListActivity extends AppCompatActivity {

    public ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist);

        tasks = new ArrayList<Task>();
        tasks.add(new Task("Manger", "Ne pas oublier de manger son repas!", null, new Date(), "En Cours", "Important"));

        ListView listTasks = findViewById(R.id.ListTasks);
        TaskAdapter adapter = new TaskAdapter(this, tasks);
        listTasks.setAdapter(adapter);
    }

}
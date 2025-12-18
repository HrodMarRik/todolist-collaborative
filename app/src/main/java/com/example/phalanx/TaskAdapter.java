package com.example.phalanx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Task> tasks;

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        if (tasks!=null){
            return tasks.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position+1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.items_tasks, parent, false);
        }
        TextView nomTache = convertView.findViewById(R.id.NomDialog);
        nomTache.setText(tasks.get(position).getNom());

        TextView priorite = convertView.findViewById(R.id.Priorite);
        priorite.setText(tasks.get(position).getPriorite());

        TextView description = convertView.findViewById(R.id.Description);
        description.setText(tasks.get(position).getDescription());

        return convertView;
    }
}

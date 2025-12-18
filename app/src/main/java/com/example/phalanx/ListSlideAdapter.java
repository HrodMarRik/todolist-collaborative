package com.example.phalanx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListSlideAdapter extends RecyclerView.Adapter<ListSlideAdapter.ViewHolder>{

    public ArrayList<ListColumn> ColumnList;

    public ListSlideAdapter(ArrayList<ListColumn> column) {
        ColumnList = column;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpage_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListColumn column = ColumnList.get(position);

        ArrayList<Task> tasks = new ArrayList<>();
        if(column.tasks !=null){
            tasks = column.tasks;
        } else {
            tasks = null;
        }
        TaskAdapter adapterTask = new TaskAdapter(holder.itemView.getContext(), tasks);
        holder.listTasks.setAdapter(adapterTask);
        holder.columnName.setText(column.title);

    }

    @Override
    public int getItemCount() {
        if (ColumnList!=null){
            return ColumnList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ListView listTasks;
        TextView columnName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            columnName = itemView.findViewById(R.id.ColumnName);
            listTasks = itemView.findViewById(R.id.ListTasks);
        }
    }
}

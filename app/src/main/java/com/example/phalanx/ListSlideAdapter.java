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

    public ArrayList<Column> ColumnList;

    public ListSlideAdapter(ArrayList<Column> column) {
        ColumnList = column;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpage_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Column column = ColumnList.get(position);

        TaskAdapter adapterTask = new TaskAdapter(holder.itemView.getContext(), column.tasks);
        holder.listTasks.setAdapter(adapterTask);
        holder.columnName.setText(column.titre);

    }

    @Override
    public int getItemCount() {
        return ColumnList.size();
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

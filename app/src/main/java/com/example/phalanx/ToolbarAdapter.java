package com.example.phalanx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ToolbarAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ListInfo> listInfo;
    private ArrayList<Users> user;

    public ToolbarAdapter(Context context, ArrayList<ListInfo> listInfo, ArrayList<Users> user) {
        this.context = context;
        this.listInfo = listInfo;
        this.user = user;
    }

    @Override
    public int getCount() {
        return listInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return listInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position+1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.toolbar, parent, false);
        }
        TextView titreList = convertView.findViewById(R.id.TitreList);
        titreList.setText(listInfo.get(position).getTitre());

        TextView nomPrenom = convertView.findViewById(R.id.NomPrenom);
        nomPrenom.setText(user.get(position).getNom()+ " " + user.get(position).getPrenom());

        return convertView;
    }
}

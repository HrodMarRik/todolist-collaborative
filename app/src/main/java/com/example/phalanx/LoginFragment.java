package com.example.phalanx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    private IOnLogin listener;

    public void setListener(IOnLogin listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_login, null);

        Button loginBtn = v.findViewById(R.id.buttonLogin);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                listener.onLogin(null);
            }
        });
        return v;
    }

    public void refresh() {
    }
}

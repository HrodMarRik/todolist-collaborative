package com.example.phalanx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    private AuthRepository repo;
    private IOnLogin listener;

    public void setListener(IOnLogin listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        EditText emailEt = v.findViewById(R.id.editTextTextEmailAddress);
        EditText passwordEt = v.findViewById(R.id.editTextTextPassword);

        repo = new AuthRepository();

        Button loginBtn = v.findViewById(R.id.buttonLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = emailEt.getText().toString();
                String password = passwordEt.getText().toString();

                repo.login(email, password, success -> {
                    requireActivity().runOnUiThread(() -> {
                        if (success) {
                            Toast.makeText(getContext(), "Connexion réussie", Toast.LENGTH_SHORT).show();
                            listener.onLogin(1);

                        } else {
                            Toast.makeText(getContext(), "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                        }
                    });
                });
            }
        });

        TextView registerText = v.findViewById(R.id.textView2);
        registerText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listener.showRegister();
            }
        });

        return v;
    }
}
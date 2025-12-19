package com.example.phalanx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {

    private AuthRepository repo;
    private IOnLogin listener;

    public void setListener(IOnLogin listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_register, container, false);

        EditText emailEt = v.findViewById(R.id.editTextEmail);
        EditText passwordEt = v.findViewById(R.id.editTextPassword);
        EditText firstNameEt = v.findViewById(R.id.editTextFirstName);
        EditText lastNameEt = v.findViewById(R.id.editTextLastName);

        repo = new AuthRepository();

        Button registerBtn = v.findViewById(R.id.buttonRegister);
        registerBtn.setOnClickListener(view -> {

            String email = emailEt.getText().toString();
            String password = passwordEt.getText().toString();
            String firstName = firstNameEt.getText().toString();
            String lastName = lastNameEt.getText().toString();

            repo.register(firstName, lastName, email, password,  success -> {
                requireActivity().runOnUiThread(() -> {
                    if (success) {
                        Toast.makeText(getContext(), "Inscription réussie", Toast.LENGTH_SHORT).show();
                        listener.returnLogin();

                    } else {
                        Toast.makeText(getContext(), "Erreur inscription", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        });

        return v;
    }
}

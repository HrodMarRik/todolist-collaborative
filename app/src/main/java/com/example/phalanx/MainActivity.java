package com.example.phalanx;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements  IOnLogin{

    private LoginFragment loginFragment;
    private ListFragment listFragment;
    private RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = new LoginFragment();
        loginFragment.setListener(this);
        listFragment= new ListFragment();
        registerFragment = new RegisterFragment();
        registerFragment.setListener(this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.FrameLayout, loginFragment)
                .add(R.id.FrameLayout, listFragment)
                .add(R.id.FrameLayout, registerFragment)
                .hide(listFragment)
                .hide(registerFragment)
                .commit();
    }

    @Override
    public void onLogin(Integer id) {
        getSupportFragmentManager().beginTransaction()
                .hide(loginFragment)
                .show(listFragment)
                .commit();
        ListFragment.setId(id);
    }
    public void showRegister() {
        getSupportFragmentManager().beginTransaction()
                .hide(loginFragment)
                .show(registerFragment)
                .commit();
    }

    public void returnLogin() {
        getSupportFragmentManager().beginTransaction()
                .hide(registerFragment)
                .show(loginFragment)
                .commit();
    }


}
package com.example.phalanx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private LoginFragment loginFragment;
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginFragment = new LoginFragment();
        listFragment= new ListFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.FrameLayout, loginFragment)
                .add(R.id.FrameLayout, listFragment)
                .hide(listFragment)
                .commit();
    }
}
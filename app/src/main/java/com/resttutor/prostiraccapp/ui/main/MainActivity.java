package com.resttutor.prostiraccapp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.resttutor.prostiraccapp.R;
import com.resttutor.prostiraccapp.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frame_container, new HomeFragment()).commit();
        }

    }
}

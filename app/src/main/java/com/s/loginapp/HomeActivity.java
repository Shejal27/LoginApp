package com.s.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtData = findViewById(R.id.txtData);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        if(username == null) username = "";
        if(password == null) password = "";

        // Mask password
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<password.length(); i++) sb.append('\u2022');

        txtData.setText("Username: " + username + "\nPassword: " + sb.toString());
    }
}
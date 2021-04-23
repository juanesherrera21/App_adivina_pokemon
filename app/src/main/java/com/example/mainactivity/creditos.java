package com.example.mainactivity;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class creditos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
        Button volver = findViewById(R.id.button);
        volver.setOnClickListener(v -> onBackPressed());
    }
}

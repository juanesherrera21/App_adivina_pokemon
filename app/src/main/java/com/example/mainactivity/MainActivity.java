package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Button jugar = findViewById(R.id.btnjugar);
        Button creditos = findViewById(R.id.button2);
        jugar.setOnClickListener(v -> {

            Intent nuevoform = new Intent(MainActivity.this, jugar.class);
            startActivity(nuevoform);
        });
        creditos.setOnClickListener(v -> {
            Intent nuevoform = new Intent(MainActivity.this, creditos.class);
            startActivity(nuevoform);
        });
    }
}
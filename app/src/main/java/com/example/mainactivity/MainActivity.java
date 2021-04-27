package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button jugar,creditos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        jugar = (Button) findViewById(R.id.btnjugar);
        creditos=(Button)findViewById(R.id.button2);
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nuevoform = new Intent(MainActivity.this, jugar.class);
                startActivity(nuevoform);
            }


        });
        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevoform = new Intent(MainActivity.this, creditos.class);
                startActivity(nuevoform);
            }
        });
    }
}
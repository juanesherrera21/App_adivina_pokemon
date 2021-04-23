package com.example.mainactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class jugar extends AppCompatActivity {
    private final String[] nombre_pokemon = {"abra", "dragonair", "gengar", "jumpluff", "larvitar", "machoke", "pidgeotto", "sceptile", "seedot", "swampert", "typhlosion", "zubat"};
    private int intentos = 3;
    private TextView mensaje_intentos;
    private EditText usuario_pokemon;
    private int numero_generado = 0;
    private ImageView mi_imagen;
    private Toast countdown_toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jugar);
        Button aceptar = findViewById(R.id.btnaceptar);
        Button volver = findViewById(R.id.button3);
        mensaje_intentos = findViewById(R.id.txtintentos);
        usuario_pokemon = findViewById(R.id.txtpokemon);
        mi_imagen = findViewById(R.id.imageView);
        numero_generado = generaraleatorio();
        establecer_sombre(numero_generado);
        mensaje_intentos.setText(String.format(getString(R.string.toast_attempt_left), intentos));
        volver.setOnClickListener(v -> onBackPressed());
        aceptar.setOnClickListener(v -> {
            String nombre = usuario_pokemon.getText().toString().toLowerCase();
            if (nombre.equals(nombre_pokemon[numero_generado]) ) {
                establecer_pokemon(numero_generado);
                esperar();
            } else {

                Toast.makeText(getApplicationContext(), getString(R.string.is_not_pokemon), Toast.LENGTH_SHORT).show();
                intentos = intentos - 1;
                mensaje_intentos.setText(getString(R.string.toast_attempt_left));

            }
            if (intentos == 0) {

                finish();


            }
        });


    }

    public void esperar() {
        new CountDownTimer(5000, 1000) {
            @SuppressLint("ShowToast")
            @Override
            public void onTick(long millisUntilFinished) {
                if(countdown_toast == null)
                {
                    countdown_toast = Toast.makeText(getApplicationContext(),String.format(getString(R.string.generating_message), millisUntilFinished / 1000),Toast.LENGTH_SHORT);

                }
                countdown_toast.cancel();
                countdown_toast = Toast.makeText(getApplicationContext(),String.format(getString(R.string.generating_message), millisUntilFinished / 1000),Toast.LENGTH_SHORT);
                countdown_toast.show();
            }

            @Override
            public void onFinish() {
                numero_generado = generaraleatorio();
                establecer_sombre(numero_generado);
                usuario_pokemon.setText("");
                if(countdown_toast != null)
                {
                    countdown_toast.cancel();
                }
            }
        }.start();
    }

    private void establecer_pokemon(int numero) {
        int resId =  getResources().getIdentifier(nombre_pokemon[numero], "drawable", getPackageName());
        mi_imagen.setImageResource(resId);

    }

    private void establecer_sombre(int numero) {
        int resId = getResources().getIdentifier("s_"+nombre_pokemon[numero], "drawable", getPackageName());
        mi_imagen.setImageResource(resId);

    }

    private int generaraleatorio() {

        return (int) (Math.random() * nombre_pokemon.length);
    }
}

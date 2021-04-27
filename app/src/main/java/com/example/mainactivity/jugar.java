package com.example.mainactivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class jugar extends AppCompatActivity {
    private String[] nombre_pokemon = {"abra", "dragonair", "gengar", "jumlpuff", "larvitar", "machoke", "pidgeotto", "sceptyle", "seedot", "swampert", "typhlosion", "zubat"};
    private String[] sombre_pokemon = {"s_abra", "s_dragonair", "s_gengar", "s_jumlpuff", "s_larvitar", "s_machoke", "s_pidgeotto", "s_sceptyle", "s_seedot", "s_swampert", "s_typhlosion", "s_zubat"};
    private int intentos = 3;
    private Button aceptar;
    private TextView mensaje_intentos,mensaje_cuenta;
    private EditText usuario_pokemon;
    private int numero_generado=0;
    private ImageView mi_imagen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jugar);
        aceptar=(Button)findViewById(R.id.btnaceptar);
        mensaje_intentos=(TextView)findViewById(R.id.txtintentos);
        mensaje_cuenta=(TextView)findViewById(R.id.lblcuenta);
        usuario_pokemon=(EditText)findViewById(R.id.txtpokemon);
        mi_imagen=(ImageView)findViewById(R.id.imageView);
        numero_generado=generaraleatorio();
        establecer_sombre(numero_generado);
        mensaje_intentos.setText("Tiene "+ intentos + "intentos");
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    String nombre=usuario_pokemon.getText().toString().toLowerCase();
    if(nombre.equals(nombre_pokemon[numero_generado])){

        establecer_pokemon(numero_generado);
        esperar();
    }else{

            Toast.makeText(getApplicationContext(), "No es el pokemon", Toast.LENGTH_SHORT).show();
            intentos = intentos - 1;
            mensaje_intentos.setText("Tiene " + intentos + "intentos");

    }
    if(intentos==0){

        finish();


    }
            }
        });
        

    }

    public void esperar(){
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mensaje_cuenta.setText("Generando en "+ (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                numero_generado=generaraleatorio();
                establecer_sombre(numero_generado);
                mensaje_cuenta.setText("");
                usuario_pokemon.setText("");
            }
        }.start();
    }

    private void establecer_pokemon(int numero){
        int resId=getResources().getIdentifier(nombre_pokemon[numero],"drawable", getPackageName());
        mi_imagen.setImageResource(resId);

    }

    private void establecer_sombre(int numero){
        int resId=getResources().getIdentifier(sombre_pokemon[numero],"drawable", getPackageName());
        mi_imagen.setImageResource(resId);

    }
    private int generaraleatorio(){

    return (int)(Math.random()*nombre_pokemon.length);
    }
}

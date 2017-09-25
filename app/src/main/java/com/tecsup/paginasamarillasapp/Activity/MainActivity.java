package com.tecsup.paginasamarillasapp.Activity;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.provider.Settings;
import android.speech.RecognizerIntent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tecsup.paginasamarillasapp.Information.Information;
import com.tecsup.paginasamarillasapp.R;
import com.tecsup.paginasamarillasapp.Resultados.Resultados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoComplete;
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String [] texts = {"Restaurants","Restaurantes","Restaurant","Boticas","Grifos","Colegios","Rentas","Remates","Mercados","Autos","Universidades"};

        autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,texts);
        autoComplete.setAdapter(adapter);

        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, Resultados.class);
                intent.putExtra("data", autoComplete.getText().toString());
                startActivity(intent);

            }
        });

    }





    ///////////////////////////////////////////////////////////////////////////////////////

    public void buscar(View view){
        Intent ii = new Intent(this,Resultados.class);
        ii.putExtra("data", autoComplete.getText().toString());
        startActivity(ii);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:

                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> speech = data
                            .getStringArrayListExtra(RecognizerIntent.
                                    EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);

                    autoComplete.setText(strSpeech2Text);

                    Intent ii = new Intent(this,Resultados.class);
                    ii.putExtra("data", strSpeech2Text);
                    startActivity(ii);

                }

                break;
            default:

                break;
        }
    }

    public void voz(View v) {

        Intent intentActionRecognizeSpeech = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intentActionRecognizeSpeech.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-ES");
        try {
            startActivityForResult(intentActionRecognizeSpeech,
                    RECOGNIZE_SPEECH_ACTIVITY);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Tú dispositivo no soporta el reconocimiento por voz",
                    Toast.LENGTH_SHORT).show();
        }

    }


    public void information(View view){

        Intent i = new Intent(this, Information.class);
        startActivity(i);

    }

}

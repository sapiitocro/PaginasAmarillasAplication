package com.tecsup.paginasamarillasapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.tecsup.paginasamarillasapp.R;
import com.tecsup.paginasamarillasapp.Resultados.Resultados;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] texts = {"Restaurants","Boticas","Grifos","Colegios","Rentas","Remates","Mercados","Autos","Universidades"};

        autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,texts);
        autoComplete.setAdapter(adapter);

        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, Resultados.class);
                startActivity(intent);

            }
        });

    }
}

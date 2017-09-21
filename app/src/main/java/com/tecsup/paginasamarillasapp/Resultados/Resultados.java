package com.tecsup.paginasamarillasapp.Resultados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tecsup.paginasamarillasapp.Detalles.Detalles;
import com.tecsup.paginasamarillasapp.R;

public class Resultados extends AppCompatActivity {

    ListView list;

    String [] restaurants = {"PICCOLO" , "ROKY'S" , "KFC" , "NORKY'S" , "PIZZA HUT" , "PEPER'S" , "BEMBOS" , "EL TABLÓN" , "CEVICHERIA" , "CHIFA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        list = (ListView) findViewById(R.id.list);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,restaurants);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(Resultados.this, Detalles.class);
                startActivity(intent);

            }
        });

    }
}

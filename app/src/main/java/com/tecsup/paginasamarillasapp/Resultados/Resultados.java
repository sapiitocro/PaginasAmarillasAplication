package com.tecsup.paginasamarillasapp.Resultados;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tecsup.paginasamarillasapp.Adaptador.Adaptador;
import com.tecsup.paginasamarillasapp.Datos.Datos;
import com.tecsup.paginasamarillasapp.Detalles.Detalles;
import com.tecsup.paginasamarillasapp.R;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {

    private ListView listaPersonalizada = null;
    private ArrayList<Datos> arrayItem = null;
    private Adaptador adapter = null;
    private TextView barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        listaPersonalizada = (ListView) findViewById(R.id.list);
        arrayItem = new ArrayList<>();

        Bundle b = getIntent().getExtras();
        String dato=b.getString("data");
        barra = (TextView) findViewById(R.id.barraText);

        if(dato.equalsIgnoreCase("Restaurants") || dato.equalsIgnoreCase("Restaurantes") ||
                dato.equalsIgnoreCase("Restaurant") || dato.equalsIgnoreCase("Restaurante")){

            barra.setText("Estos son los resultados de "+dato);
            cargarLista();

        }else {

            barra.setText("0 resultados de "+dato);
        }
    }

    public void cargarLista(){

        arrayItem.add(new Datos("POLLERIA ROKY´S","av. Lima # 123","7630057",R.mipmap.logo_pollo));
        arrayItem.add(new Datos("HAMBURGUESAS","av. Pirata # 6074","7502598",R.mipmap.logo_hamburguesa));
        arrayItem.add(new Datos("PIZZA´S","av. Peru # 505","7201030",R.mipmap.logo_pizza1));
        arrayItem.add(new Datos("KFC","av. La Revolución # 1069","7205093",R.mipmap.logo_kfc1));
        arrayItem.add(new Datos("CHIFA","av. La marina # 8080","7500187",R.mipmap.logo_chifa1));
        arrayItem.add(new Datos("TURRONES SAN JOSE","av. La Cruz # 23","7566501",R.mipmap.logo_turrones1));
        arrayItem.add(new Datos("CAFE EL DICHO","av. Ugarte # 101","7100098",R.mipmap.logo_cafe1));
        arrayItem.add(new Datos("MC DONALDS","av. Argentina # 3489","7025378",R.mipmap.logo_mc));
        arrayItem.add(new Datos("PARDOS","av. Benavides # 3902","7198356",R.mipmap.logo_pardos1));
        arrayItem.add(new Datos("CAFE 338","av. Colectora # 7514","75000522",R.mipmap.logo_cafe11));


        adapter = new Adaptador(this, arrayItem);
        listaPersonalizada.setAdapter(adapter);

        listaPersonalizada.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String posicion = String.valueOf(i);

                Intent iii = new Intent(Resultados.this, Detalles.class);
                iii.putExtra("cartilla",posicion );
                startActivity(iii);

            }
        });

    }



}

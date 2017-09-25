package com.tecsup.paginasamarillasapp.Resultados;

import android.content.Intent;
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


        adapter = new Adaptador(this, arrayItem);
        listaPersonalizada.setAdapter(adapter);

    }

}

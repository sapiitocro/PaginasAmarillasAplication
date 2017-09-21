package com.tecsup.paginasamarillasapp.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecsup.paginasamarillasapp.Datos.Datos;
import com.tecsup.paginasamarillasapp.R;
import com.tecsup.paginasamarillasapp.Resultados.Resultados;


import java.util.ArrayList;
import java.util.List;

public class Adaptador extends BaseAdapter{

    private ArrayList<Datos> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public Adaptador(Context context,ArrayList<Datos> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vistaDatos = layoutInflater.inflate(R.layout.estilo_list, viewGroup , false);
        ImageView img = vistaDatos.findViewById(R.id.img1);
        TextView txtTitulo = (TextView) vistaDatos.findViewById(R.id.t1);
        TextView txtDetalle = (TextView) vistaDatos.findViewById(R.id.t2);
        TextView txtTelefono = (TextView) vistaDatos.findViewById(R.id.t3);

        img.setImageResource(arrayList.get(i).getImagen());
        txtTitulo.setText(arrayList.get(i).getTitulo());
        txtDetalle.setText(arrayList.get(i).getDetalle());
        txtTelefono.setText(arrayList.get(i).getTelefono());

        return vistaDatos;
    }
}

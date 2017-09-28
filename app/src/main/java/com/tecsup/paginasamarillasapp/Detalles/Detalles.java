package com.tecsup.paginasamarillasapp.Detalles;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tecsup.paginasamarillasapp.Adaptador.Adaptador;
import com.tecsup.paginasamarillasapp.Datos.Datos;
import com.tecsup.paginasamarillasapp.R;

import java.util.ArrayList;

public class Detalles extends AppCompatActivity {

    private TextView j1,j2,j3,jj1;
    private ImageView j4;

    private TextView p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        j1 = (TextView) findViewById(R.id.j1);
        jj1 = (TextView) findViewById(R.id.jj1);
        j2 = (TextView) findViewById(R.id.j2);
        j3 = (TextView) findViewById(R.id.j3);
        j4 = (ImageView) findViewById(R.id.j4);

        Bundle bb = getIntent().getExtras();
        String posicion = bb.getString("cartilla");

        if(posicion.equals("0")){
            j1.setText("POLLERIA ROKY´S");
            j2.setText("av. Lima # 123");
            j3.setText("7630057");
            j4.setImageResource(R.mipmap.logo_pollo);
            jj1.setText("LOS MEJORES POLLOS A LA BRASA DEL PERÚ");
        }else if (posicion.equals("1")){
            j1.setText("HAMBURGUESAS");
            j2.setText("av. Pirata # 6074");
            j3.setText("7502598");
            j4.setImageResource(R.mipmap.logo_hamburguesa);
            jj1.setText("SI DESEAS COMER LAS MEJORES HAMBURGUESAS DEL PERÚ, BEMBOS ES LA BUENA ELECCIÓN");
        }else if(posicion.equals("2")){
            j1.setText("PIZZA´S");
            j2.setText("av. Peru # 505");
            j3.setText("7201030");
            j4.setImageResource(R.mipmap.logo_pizza1);
            jj1.setText("LAS PIZZAS CON MAS SABOR, EN PIZZA´S DEBES COMER");
        }else if(posicion.equals("3")){
            j1.setText("KFC");
            j2.setText("av. La Revolución # 1069");
            j3.setText("7205093");
            j4.setImageResource(R.mipmap.logo_kfc1);
            jj1.setText("KFC , EL MEJOR LUGAR PARA LA FAMILIA PERUANA");
        }else if(posicion.equals("4")){
            j1.setText("CHIFA");
            j2.setText("av. La marina # 8080");
            j3.setText("7500187");
            j4.setImageResource(R.mipmap.logo_chifa1);
            jj1.setText("LOS PLATILLOS MAS DELICIOSOS DEL ORIENTE, LO TIENES EN UN SOLO LUGAR");
        }else if(posicion.equals("5")){
            j1.setText("TURRONES SAN JOSE");
            j2.setText("av. La Cruz # 23");
            j3.setText("7566501");
            j4.setImageResource(R.mipmap.logo_turrones1);
            jj1.setText("TURRONES SAN JOSE, SUAVECIIIIIITOOSSS.....");
        }else if(posicion.equals("6")){
            j1.setText("CAFE EL DICHO");
            j2.setText("av. Ugarte # 101");
            j3.setText("7100098");
            j4.setImageResource(R.mipmap.logo_cafe1);
            jj1.setText("TODO CAFE CARGADO, BIENE CON UN DICHO RECARGADO");
        }else if(posicion.equals("7")){
            j1.setText("MC DONALDS");
            j2.setText("av. Argentina # 3489");
            j3.setText("7025378");
            j4.setImageResource(R.mipmap.logo_mc);
            jj1.setText("MC DONALDS EL MEJOR LUGAR PARA DISFRUTAR EN FAMILIA");
        }else if(posicion.equals("8")){
            j1.setText("PARDOS");
            j2.setText("av. Benavides # 3902");
            j3.setText("7198356");
            j4.setImageResource(R.mipmap.logo_pardos1);
            jj1.setText("POLLERIA PARDOS CUENTA CON LOS MEJORES POLLOS PARA SU MESA");
        }else if(posicion.equals("9")){
            j1.setText("CAFE 338");
            j2.setText("av. Colectora # 7514");
            j3.setText("75000522");
            j4.setImageResource(R.mipmap.logo_cafe11);
            jj1.setText("CAFE , ANIS , LECHE ; ...  TODO EN UN SOLO LUGAR... TE ESPERAMOS ....");
        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navegation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.action_navegar:

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://www.google.com"));
                        startActivity(intent);
                        break;

                    case R.id.action_enviarCorreo:

                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("message/rfc822");
                        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
                        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                        i.putExtra(Intent.EXTRA_TEXT, "body of email");
                        try {
                            startActivity(Intent.createChooser(i, "Send mail..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.action_enviarMensaje:

                        Uri uri = Uri.parse("smsto:"+997138919);
                        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                        it.putExtra("sms_body", "hola");
                        startActivity(it);
                        break;
                    case R.id.action_compartir:

                        Intent intenta = new Intent(Intent.ACTION_SEND);
                        intenta.setType("text/plain");
                        intenta.putExtra(Intent.EXTRA_SUBJECT, "subject");
                        intenta.putExtra(Intent.EXTRA_TEXT, "text");
                        intenta.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent.createChooser(intenta,  "Compartir en" ));
                        break;
                    case R.id.action_llamar:
                        int permissionCheck = ContextCompat.checkSelfPermission(Detalles.this, Manifest.permission.CALL_PHONE);

                        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(
                                    Detalles.this,
                                    new String[]{Manifest.permission.CALL_PHONE},
                                    Integer.parseInt("123"));
                        } else {
                            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+ 997138910)));
                        }
                        break;
                }
                return true;
            }
        });
    }
}

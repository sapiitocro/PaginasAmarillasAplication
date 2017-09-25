package com.tecsup.paginasamarillasapp.Detalles;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.tecsup.paginasamarillasapp.R;

public class Detalles extends AppCompatActivity {

    private TextView p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        Bundle bb = getIntent().getExtras();
        String posicion=bb.getString("cartilla");

        p1 = (TextView) findViewById(R.id.p1);
        p1.setText(posicion);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Toast.makeText(Detalles.this, "Go home section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_camera:
                        Toast.makeText(Detalles.this, "Go camera section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_search:
                        Toast.makeText(Detalles.this, "Go share section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_notification:
                        Toast.makeText(Detalles.this, "Go notification section...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_more:
                        Toast.makeText(Detalles.this, "Go more sections...", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }

}

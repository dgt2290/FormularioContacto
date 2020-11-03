package com.example.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.formulariocontacto.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmacion);

        Bundle parametros = getIntent().getExtras();

        String datos[] = {  parametros.getString("pnombre"),
                            "Fecha de Nacimiento: " + parametros.getString("pfecha"),
                            "Tel. " + parametros.getString("ptel"),
                            "E-mail: " + parametros.getString("pemail"),
                            "Descripción: " + parametros.getString("pdes")
                         };

        /* ArrayList<String> datos = new ArrayList<>(); // Solución con ArrayList

        datos.add(parametros.getString("pnombre"));
        datos.add("Tel. " + parametros.getString("ptel"));
        datos.add("E-mail: " + parametros.getString("pemail"));
        datos.add("Descripción: " + parametros.getString("pdes")); */

        ListView miLista = (ListView) findViewById(R.id.lstView);
        miLista.setAdapter(new ArrayAdapter(this, R.layout.list_view, datos));

        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent i = new Intent(SecActivity.this, MainActivity.class);

                //Agregamos los datos al Intent
                i.putExtra("pnombre", parametros.getString("pnombre"));
                i.putExtra("pfecha", parametros.getString("pfecha"));
                i.putExtra("ptel", parametros.getString("ptel"));
                i.putExtra("pemail", parametros.getString("pemail"));
                i.putExtra("pdes", parametros.getString("pdes"));

                //Iniciamos la actividad
                startActivity(i);
            }
        });

    }
}

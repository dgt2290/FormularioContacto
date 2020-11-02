package com.example.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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

        ArrayList<String> datos = new ArrayList<>();

        datos.add(parametros.getString("pnombre"));
        datos.add(parametros.getString("ptel"));
        datos.add(parametros.getString("pemail"));
        datos.add(parametros.getString("pdes"));

        /* ListView lstView = (ListView) findViewById(R.id.lstView);
        lstView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos)); */

    }
}

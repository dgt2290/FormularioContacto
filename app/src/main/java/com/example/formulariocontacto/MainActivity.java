package com.example.formulariocontacto;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String fecha = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);

        TextInputEditText formTxtImputNombre = (TextInputEditText) findViewById(R.id.formTxtImputNombre);
        TextView fechaNac = (TextView) findViewById(R.id.fechaNac);
        TextInputEditText formTxtImputTel = (TextInputEditText) findViewById(R.id.formTxtImputTel);
        TextInputEditText formTxtImputEmail = (TextInputEditText) findViewById(R.id.formTxtImputEmail);
        TextInputEditText formTxtImputDes = (TextInputEditText) findViewById(R.id.formTxtImputDes);

        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent i = new Intent(MainActivity.this, SecActivity.class);

                //Agregamos los datos al Intent
                i.putExtra("pnombre", formTxtImputNombre.getText().toString());
                i.putExtra("pfecha", fecha);
                i.putExtra("ptel", formTxtImputTel.getText().toString());
                i.putExtra("pemail", formTxtImputEmail.getText().toString());
                i.putExtra("pdes", formTxtImputDes.getText().toString());

                //Iniciamos la actividad
                startActivity(i);
            }
        });

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        Button btnSeleccionar = (Button) findViewById(R.id.btnSeleccionar);
        btnSeleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mes + 1 porque Enero es 0
                fecha = String.valueOf(datePicker.getDayOfMonth()) + "/" +
                        String.valueOf(datePicker.getMonth() + 1) + "/" +
                        String.valueOf(datePicker.getYear());
                fechaNac.setText(fecha);
                fechaNac.setTextColor(getResources().getColor(R.color.black));
            }
        });

        if (getIntent().getExtras() != null) {
            Bundle parametros = getIntent().getExtras();
            formTxtImputNombre.setText(parametros.getString("pnombre"));
            fechaNac.setText(parametros.getString("pfecha"));
            formTxtImputTel.setText(parametros.getString("ptel"));
            formTxtImputEmail.setText(parametros.getString("pemail"));
            formTxtImputDes.setText(parametros.getString("pdes"));
        }

    }

}
package com.example.formulariocontacto;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String fecha = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);

        TextInputEditText formTxtImputNombre = (TextInputEditText) findViewById(R.id.formTxtImputNombre);
        TextInputEditText formTxtImputTel = (TextInputEditText) findViewById(R.id.formTxtImputTel);
        TextInputEditText formTxtImputEmail = (TextInputEditText) findViewById(R.id.formTxtImputEmail);
        TextInputEditText formTxtImputDes = (TextInputEditText) findViewById(R.id.formTxtImputDes);

        CalendarView calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fecha = String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear) + "/" + String.valueOf(year);
            }
        });

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

    }

}
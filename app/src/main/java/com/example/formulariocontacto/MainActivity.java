package com.example.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);

        TextInputEditText formTxtImputNombre = (TextInputEditText) findViewById(R.id.formTxtImputNombre);
        TextInputEditText formTxtImputTel = (TextInputEditText) findViewById(R.id.formTxtImputTel);
        TextInputEditText formTxtImputEmail = (TextInputEditText) findViewById(R.id.formTxtImputEmail);
        TextInputEditText formTxtImputDes = (TextInputEditText) findViewById(R.id.formTxtImputDes);
        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                formTxtImputNombre.getText();
                formTxtImputTel.getText();
                formTxtImputEmail.getText();
                formTxtImputDes.getText();

                Intent i = new Intent(this, formulario.class);

            }
        });

    }

}
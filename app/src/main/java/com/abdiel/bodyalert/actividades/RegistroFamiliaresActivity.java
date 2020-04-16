package com.abdiel.bodyalert.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abdiel.bodyalert.DataBase.DatabaseHelper;
import com.abdiel.bodyalert.R;

public class RegistroFamiliaresActivity extends AppCompatActivity {

    DatabaseHelper db;

    EditText nombreF;
    EditText apellidoF;
    EditText telefonoF;

    EditText DireccionF;
    EditText parentescoF;
    Button regisF;
    Button canF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_familiares);

        db = new DatabaseHelper(this);

        nombreF = (EditText)findViewById(R.id.nombrefam);
        apellidoF = (EditText)findViewById(R.id.apellidofam);
        telefonoF = (EditText)findViewById(R.id.telefonofam);

        DireccionF = (EditText)findViewById(R.id.direccionfam);
        parentescoF = (EditText)findViewById(R.id.parentescofam);

        regisF = (Button)findViewById(R.id.RegistrarFam);
        canF = (Button)findViewById(R.id.CancelarFam);

        //botones Onlistener

        regisF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre1 = nombreF.getText().toString().trim();
                String apellido1 = apellidoF.getText().toString().trim();
                String telefono1 = telefonoF.getText().toString().trim();

                String direccion1 = DireccionF.getText().toString().trim();
                String parentesco1 = parentescoF.getText().toString().trim();

                if (nombre1.length() != 0 && apellido1.length() != 0 && telefono1.length() != 0 && direccion1.length() != 0 && parentesco1.length() != 0) {
                    long val = db.agregarFamiliar(nombre1, apellido1, telefono1, direccion1, parentesco1);
                    if (val > 0) {
                        Toast.makeText(RegistroFamiliaresActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        Intent moveToHome = new Intent(RegistroFamiliaresActivity.this, HomeActivity.class);
                        startActivity(moveToHome);
                    } else {
                        Toast.makeText(RegistroFamiliaresActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegistroFamiliaresActivity.this, "Deben llenarse todos lo campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        canF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backRegFam = new Intent(RegistroFamiliaresActivity.this, HomeActivity.class);
                startActivity(backRegFam);
            }
        });

    }
}

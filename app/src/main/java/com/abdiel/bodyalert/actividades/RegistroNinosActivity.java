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

public class RegistroNinosActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText nombreN;
    EditText apellidoN;
    EditText edadN;
    EditText discapacidadN;
    Button registrarN;
    Button CancelarN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ninos);

        db = new DatabaseHelper(this);

        //enlazamos cada componente
        nombreN = (EditText)findViewById(R.id.nombrenino);
        apellidoN = (EditText)findViewById(R.id.apellidonino);
        edadN = (EditText)findViewById(R.id.edadnino);
        discapacidadN = (EditText)findViewById(R.id.enfermedadnino);
        registrarN = (Button)findViewById(R.id.regisNinos);
        CancelarN = (Button)findViewById(R.id.cancelarNinos);

        //boton cancelar

        CancelarN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backRegisninos = new Intent(RegistroNinosActivity.this, HomeActivity.class);
                startActivity(backRegisninos);
            }
        });

        registrarN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    String nombre1 = nombreN.getText().toString().trim();
                    String apellido1 = apellidoN.getText().toString().trim();
                    //String edad2 = edadN.getText().toString().trim();
                    String edad1 = edadN.getText().toString().trim();
                    String discapacidad1 = discapacidadN.getText().toString().trim();

                    //aqui hago la validacion
                if(nombre1.length() != 0 && edad1.length()!=0 && apellido1.length() != 0 && discapacidad1.length() != 0){

                        long val = db.agregarHijo(nombre1, apellido1, edad1, discapacidad1);
                        if (val > 0) {
                            Toast.makeText(RegistroNinosActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                            Intent moveToHome = new Intent(RegistroNinosActivity.this, HomeActivity.class);
                            startActivity(moveToHome);
                        } else {
                            Toast.makeText(RegistroNinosActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                        }


            }else{
                    Toast.makeText(RegistroNinosActivity.this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

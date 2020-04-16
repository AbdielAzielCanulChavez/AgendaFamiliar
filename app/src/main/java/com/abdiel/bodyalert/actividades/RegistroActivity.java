package com.abdiel.bodyalert.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abdiel.bodyalert.DataBase.DatabaseHelper;
import com.abdiel.bodyalert.MainActivity;
import com.abdiel.bodyalert.R;

public class RegistroActivity extends AppCompatActivity {

    //creamos las variables para los datos que tenemoe en el xml
    DatabaseHelper db;
    EditText nombre;
    EditText apellido;
    EditText edad;
    EditText correo;
    EditText password;
    EditText confirmarpass;
    Button regis;
    Button cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = new DatabaseHelper(this);

        //enlazamos por medio del findViewById los datos del xml con las variables que instancias anteriormente
        nombre = (EditText)findViewById(R.id.nombre);
        apellido = (EditText)findViewById(R.id.apellido);
        edad = (EditText)findViewById(R.id.edad);
        correo = (EditText)findViewById(R.id.correo);
        password = (EditText)findViewById(R.id.password);
        confirmarpass = (EditText)findViewById(R.id.passwordConfirm);
        regis = (Button)findViewById(R.id.registrarseBTN);
        cancelar = (Button)findViewById(R.id.cancelarBTN);



        //boton cancelar
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(registerIntent);
            }
        });//boton cancelar

        //boton registrarse
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre1 = nombre.getText().toString().trim();
                String apellido1 = apellido.getText().toString().trim();
                String edad1 = edad.getText().toString().trim();
                String correo1 = correo.getText().toString().trim();
                String password1 = password.getText().toString().trim();
                String confirmacionpassword = confirmarpass.getText().toString().trim();

                if(nombre1.length() != 0 && apellido1.length() !=0 && edad1.length() != 0 && correo1.length() != 0 && password1.length() != 0 && confirmacionpassword.length() != 0){

                if(password1.equals(confirmacionpassword)){

                    long val = db.agregarTutor(nombre1,apellido1,edad1,correo1,password1);
                    if (val > 0) {

                        Toast.makeText(RegistroActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegistroActivity.this, MainActivity.class);
                        startActivity(moveToLogin);
                    }else{
                        Toast.makeText(RegistroActivity.this, "Error al registrarse", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegistroActivity.this, "Las contrasenias no coinciden", Toast.LENGTH_SHORT).show();
                }
            }else{
                    Toast.makeText(RegistroActivity.this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });//boton registrarse


    }
}

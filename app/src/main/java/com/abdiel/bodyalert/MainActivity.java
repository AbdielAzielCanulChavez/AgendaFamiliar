package com.abdiel.bodyalert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abdiel.bodyalert.DataBase.DatabaseHelper;
import com.abdiel.bodyalert.actividades.HomeActivity;
import com.abdiel.bodyalert.actividades.RegistroActivity;

public class MainActivity extends AppCompatActivity {

    //declaramos los datos que tenemos almacenados en el xml

    EditText usuario;
    EditText contrasenia;
    Button ingresar;
    Button registrarse;

    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        //por medio de findById vamos a buscar cada cosa que agregamos al xml
        //y lo enlazamos a las varaibles que instanciamos previamente
        usuario = (EditText)findViewById(R.id.user);
        contrasenia = (EditText)findViewById(R.id.pass);
        ingresar = (Button)findViewById(R.id.ingresarLogin);
        registrarse = (Button)findViewById(R.id.registroLogin);



        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //el intent nos ayuda a movernos de activity en activity
                Intent registerIntent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(registerIntent);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // el metodo .trim() es usado para elminar espacios al principio y final de las cadenas
                String user = usuario.getText().toString().trim();
                String password = contrasenia.getText().toString().trim();

                Boolean res = db.checkUser(user,password);

                if(res == true){
                    //aqui ya entro a la app por sesion
                    Intent moveToLogin = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(moveToLogin);
                    Toast.makeText(MainActivity.this, "Sesion iniciada ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Correo o contrasenia incorrectas ", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}

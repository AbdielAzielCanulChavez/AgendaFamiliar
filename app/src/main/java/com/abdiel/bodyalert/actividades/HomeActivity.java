package com.abdiel.bodyalert.actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.abdiel.bodyalert.Fragmentos.FamiliaresFragment;
import com.abdiel.bodyalert.Fragmentos.HijosFragment;
import com.abdiel.bodyalert.Fragmentos.InformacionFragment;
import com.abdiel.bodyalert.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements FamiliaresFragment.OnFragmentInteractionListener, HijosFragment.OnFragmentInteractionListener, InformacionFragment.OnFragmentInteractionListener{

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //traemos los fragments
        final FamiliaresFragment familiaresFragment;
        final HijosFragment hijosFragment;
        InformacionFragment informacionFragment;

        //creamos los objetos de cada fragmentos para poder cargarlos
        familiaresFragment = new FamiliaresFragment();
        hijosFragment = new HijosFragment();
        informacionFragment = new InformacionFragment();


        getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, familiaresFragment).commit();

        //traemos el contenedor de los item osea los botones de la navegacion
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);



        //traemos loa botones
        final FloatingActionButton padresFloating = (FloatingActionButton) findViewById(R.id.tutor);
        final FloatingActionButton ninosFloating = (FloatingActionButton) findViewById(R.id.ninos);

        padresFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui nos mandara al activity

                Intent moveToLogin = new Intent(HomeActivity.this, RegistroFamiliaresActivity.class);
                startActivity(moveToLogin);
                Toast.makeText(HomeActivity.this, "fragmet de padres",Toast.LENGTH_SHORT).show();
            }
        });//boton padres

        ninosFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui nos mandara aun activity
                Intent moveToLogin = new Intent(HomeActivity.this, RegistroNinosActivity.class);
                startActivity(moveToLogin);
                Toast.makeText(HomeActivity.this, "Activity de hijos",Toast.LENGTH_SHORT).show();
            }
        }); //boton ninos


    }
    //navegacion de los fragments correspondientes
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_familiares:
                    selectedFragment = new FamiliaresFragment();
                    break;
                case R.id.nav_hijos:
                    selectedFragment = new HijosFragment();
                    break;
                case R.id.nav_information:
                    selectedFragment = new InformacionFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, selectedFragment).commit();

            return true;
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

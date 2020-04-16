package com.abdiel.bodyalert.DataBase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdiel.bodyalert.R;
import com.abdiel.bodyalert.entidades.familiar;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorFamiliar extends RecyclerView.Adapter<AdaptadorFamiliar.FamiliarViewHolder> {


    //creamos un array list de la entidad a traer
    ArrayList<familiar> listaFamiliar;
    DatabaseHelper db;
    familiar f;






    @NonNull
    @Override
    public AdaptadorFamiliar.FamiliarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflamos el item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_familiares, null, false);


        return new FamiliarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorFamiliar.FamiliarViewHolder holder, int position) {
        //incrustamos los datos


    }

    @Override
    public int getItemCount() {
        return listaFamiliar.size();
    }

    public class FamiliarViewHolder extends RecyclerView.ViewHolder{

        //aqui traemos los componentes que tenemos en el item_list_familiar
        TextView nombreFamiliar;
        TextView apellidoFamiliar;
        TextView parentescoFamiliar;
        ImageView telefonoFamiliar;


        public FamiliarViewHolder(View itemView){
            super(itemView);

            //relacionamos cada componenete con los del item......xml
            telefonoFamiliar = (ImageView)itemView.findViewById(R.id.telefonofamiliar);
            nombreFamiliar = (TextView)itemView.findViewById(R.id.nombrefamiliar);
            apellidoFamiliar = (TextView)itemView.findViewById(R.id.apellidofamiliar);
            parentescoFamiliar = (TextView)itemView.findViewById(R.id.parentescofamiliar);




        }
    }
}


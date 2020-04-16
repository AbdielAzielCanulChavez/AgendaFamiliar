package com.abdiel.bodyalert.DataBase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.fragment.app.Fragment;

import com.abdiel.bodyalert.entidades.familiar;

import java.util.ArrayList;

public class AdaptadorFamiliar2 extends BaseAdapter {

    ArrayList<familiar> lista;
    DatabaseHelper db;
    familiar f;
    Fragment fa;
    int id = 0;

    public AdaptadorFamiliar2(ArrayList<familiar> lista, DatabaseHelper db){
        this.lista = lista;
        this.db=db;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public familiar getItem(int i) {
        f=lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {

        f=lista.get(i);
        return f.getId();
    }

    //aqui visualizamos los datos
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View v = view;
        if(v== null){
            //LayoutInflater li = (LayoutInflater) fa.
        }

        return null;
    }
}

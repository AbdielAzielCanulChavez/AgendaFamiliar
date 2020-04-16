package com.abdiel.bodyalert.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.abdiel.bodyalert.entidades.familiar;
import com.abdiel.bodyalert.entidades.infante;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    ArrayList<infante> listainfantes = new ArrayList<infante>();
    ArrayList<familiar> lista = new ArrayList<familiar>();
    familiar f;
    SQLiteDatabase db;


    public static final String DATABASE_NAME = "BodyAlert.db";  //le damos nombre de la base de datos

    public static final String TABLE_NAME = "padres"; //le damos nombre a la tabla
    public static final String COL_1 = "id";
    public static final String COL_2 = "nombre"; //damos nombre a las columnas
    public static final String COL_3 = "apellido";//columna
    public static final String COL_4 = "edad"; //columna
    public static final String COL_5 = "correo"; //columna
    public static final String COL_6 = "password"; //columna



    public static final String TABLE_NAME_HIJOS = "hijos";
    public static final String COL_1H = "idhijos";
    public static final String COL_2H = "nombreH"; //damos nombre a las columnas
    public static final String COL_3H = "apellidoH";//columna
    public static final String COL_4H = "edadH"; //columna
    public static final String COL_5H = "enfermedadH";

    public static final String TABLE_NAME_FAMILIAR = "familiar";
    public static final String COL_1F = "idfamiliar";
    public static final String COL_2F = "nombreF"; //damos nombre a las columnas
    public static final String COL_3F = "apellidoF";//columna
    public static final String COL_4F = "telefonoF"; //columna
    public static final String COL_5F = "direccionF";
    public static final String COL_6F = "parentescoF";



    public DatabaseHelper( Context context) {
        //AQUI CREAMOS LA BASE DE DATOS CON EL CONTEXT, NOMBRE DE LA BASE DE DATOS QUE DECLARAMOS ANTERIORMENTE
        //EL FACTORY NULL, CON LA VERSION 1 DE LA BASE DE DATOS
        super(context, DATABASE_NAME, null, 3);


    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //aqui creamos la tabla de la base de datos

        db.execSQL("CREATE TABLE "+TABLE_NAME+" (id integer primary key autoincrement, nombre TEXT, apellido TEXT, edad NUMBER, correo TEXT, password TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_NAME_HIJOS+ " (idhijos integer primary key autoincrement, nombreH TEXT, apellidoH TEXT, edad TEXT, enfermedadH TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_NAME_FAMILIAR+ " (idfamiliar integer primary key autoincrement, nombreF TEXT, apellidoF TEXT, telefonoF TEXT, direccionF TEXT, parentescoF TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Eliminamos la tabla si es que existe
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_HIJOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FAMILIAR);
        onCreate(db);

    }

    //ADD TUTOR
    public long agregarTutor(String nombre, String apellido, String edad, String correo, String password){
        //hacemos que la base de datos tenga prvilegios de escritura y lectura
        SQLiteDatabase db = this.getWritableDatabase();
        //creamos un objeto de tipo ContentValues para hacer las respectivas inserciones
        ContentValues contentValues = new ContentValues();
        //realiamos las inserciones con put
        contentValues.put("nombre", nombre);
        contentValues.put("apellido", apellido);
        contentValues.put("edad", edad);
        contentValues.put("correo", correo);
        contentValues.put("password",password);
        //realizamos la insersion de los datos en la base de datos
        long res = db.insert("padres", null, contentValues);
        //cerramos la sesion de la base de datos
        db.close();
        //retornamos los datos que almacenamos en res
        return res;

    }//ADD TUTOR



    //realiamos una clase que verifique si e usuario no se repite

    public boolean checkUser(String correo, String password){

        String[] columns =new String[] {COL_1};
        SQLiteDatabase db = getWritableDatabase();
        String selection = COL_5 + "=?" + " and " + COL_6 + "=?";

        String[] selectionArgs = {correo, password};
        Cursor cursor = db.query(TABLE_NAME,columns, selection, selectionArgs, null, null, null);


        int count = cursor.getCount();
        cursor.close();

        if(count>0){
            return true;
        }else {return false;}


    }//verificacion de usuario

    //ADD HIJOS
    public long agregarHijo(String nombreH, String apellidoH, String edad, String enfermedadH){
        //hacemos que la base de datos sea de lectura y escritura
        SQLiteDatabase db = this.getWritableDatabase();
        //creamos un objeto de tipo ContentValues
        ContentValues contentValues = new ContentValues();
        //realizamos la insersion con put
        contentValues.put("nombreH", nombreH);
        contentValues.put("apellidoH", apellidoH);
        contentValues.put("edad", edad);
        contentValues.put("enfermedadH", enfermedadH);
        //realizamos la insercion a la base de datos
        long res = db.insert("hijos", null, contentValues);
        //cerramos la sesion de la base de datos
        db.close();
        //retornamos el valor de res
        return res;
    }//ADD HIJO


    //ADD FAMILIAR

    public long agregarFamiliar(String nombreF, String apellidoF, String telefonoF, String direccionF, String parentescoF){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("nombreF", nombreF);
        contentValues.put("apellidoF", apellidoF);
        contentValues.put("telefonoF", telefonoF);
        contentValues.put("direccionF", direccionF);
        contentValues.put("parentescoF", parentescoF);

        long res = db.insert(TABLE_NAME_FAMILIAR, null, contentValues);
        db.close();
        return res;

    }//ADD FAMILIAR

    //listar todos los familiares
    public ArrayList<familiar> verTodosFamiliar(){
        //limpiamos la lista para mostrarla
        lista.clear();
        //aqui llamamos el curso
        Cursor cursor = db.rawQuery("SELECT * FROM " +TABLE_NAME_FAMILIAR, null);
        //aqui validamos si la consulta encuentra algo
        if(cursor != null && cursor.getCount()>0){
            cursor.moveToNext();
            do{
                //aqui enlistamos los datos
                lista.add(new familiar(
                   cursor.getInt(0),
                   cursor.getString(1),
                   cursor.getString(2),
                   cursor.getString(3),
                   cursor.getString(4),
                   cursor.getString(5),
                        cursor.getString(6)));
            }while (cursor.moveToNext());
        }

        return lista;
    }//listar todos los familiares


    //listar ninos
    public ArrayList<infante> verTodosNinos(){
        listainfantes.clear();
        Cursor cursor = db.rawQuery("SELECT * FROM " +TABLE_NAME_HIJOS, null);

        if(cursor != null && cursor.getCount() > 0 ){
            cursor.moveToNext();
            do{
                listainfantes.add(new infante(
                   cursor.getInt(0),
                   cursor.getString(1),
                   cursor.getString(2),
                   cursor.getInt(3), //posible error
                   cursor.getString(4)
                ));
            }while (cursor.moveToNext());
        }
        return listainfantes;
    }//listar ninos


    //eliminar nino
    public boolean eliminarNinos(int idhijos){
        return (db.delete(TABLE_NAME_HIJOS, "id="+idhijos, null))>0;
    }

    //eliminar un familiar
    public boolean eliminarFamiliar(int idfamiliar){
        return (db.delete(TABLE_NAME_FAMILIAR, "id="+idfamiliar, null))>0;
    }//eliminar un familiar


}

package com.abdiel.bodyalert.entidades;

public class familiar {
    int id;
    String nombre;
    String apellido;
    String telefono;
    String curp;
    String direccion;
    String parentesco;


    public familiar() {
    }

    public familiar(int id, String nombre, String apellido, String telefono, String curp, String direccion, String parentesco) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.curp = curp;
        this.direccion = direccion;
        this.parentesco = parentesco;
    }

    public familiar(String nombre, String apellido, String telefono, String curp, String direccion, String parentesco) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.curp = curp;
        this.direccion = direccion;
        this.parentesco = parentesco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}

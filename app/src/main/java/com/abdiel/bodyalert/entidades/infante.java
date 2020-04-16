package com.abdiel.bodyalert.entidades;

public class infante {
    int idinfante;
    String nombre;
    String apellido;
    int edad;
    String enfermedad;

    public infante() {
    }

    public infante(int idinfante, String nombre, String apellido, int edad, String enfermedad) {
        this.idinfante = idinfante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.enfermedad = enfermedad;
    }

    public infante(String nombre, String apellido, int edad, String enfermedad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.enfermedad = enfermedad;
    }

    public int getIdinfante() {
        return idinfante;
    }

    public void setIdinfante(int idinfante) {
        this.idinfante = idinfante;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
}

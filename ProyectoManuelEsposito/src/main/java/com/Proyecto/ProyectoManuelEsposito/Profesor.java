package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profesor {
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("edad")
    private int edad;
    @JsonProperty("edad")
    private int legajo;

    public Profesor(String nombre, String apellido, int edad, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.legajo = legajo;
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

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", legajo=" + legajo +
                '}';
    }
}

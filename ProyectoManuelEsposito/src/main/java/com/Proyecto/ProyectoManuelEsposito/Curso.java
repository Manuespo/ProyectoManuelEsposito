package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Curso {
    @JsonProperty("nombre")
    String nombre;
    @JsonProperty("materias")
    private ArrayList<Materia> materias;
    @JsonProperty ("infoCurso")
    private String infoCurso;

    public Curso(String nombre, ArrayList<Materia> materias, String infoCurso) {
        this.nombre = nombre;
        this.materias = materias;
        this.infoCurso = infoCurso;
    }

    public Curso() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    public String getInfoCurso() {
        return infoCurso;
    }

    public void setInfoCurso(String infoCurso) {
        this.infoCurso = infoCurso;
    }
    public void agregarProfesorAArchivo(String nombreArchivo){
        File file=new File(nombreArchivo)
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", materias=" + materias +
                ", infoCurso='" + infoCurso + '\'' +
                '}';
    }
}

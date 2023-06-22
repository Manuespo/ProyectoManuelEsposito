package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nota {
    @JsonProperty("alumno")
    private Alumno alumno;
    @JsonProperty("nota")
    private int nota;

    public Nota() {
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "alumno=" + alumno +
                ", nota=" + nota +
                '}';
    }
}

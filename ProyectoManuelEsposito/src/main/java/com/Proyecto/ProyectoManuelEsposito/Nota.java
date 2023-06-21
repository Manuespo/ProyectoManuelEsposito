package com.Proyecto.ProyectoManuelEsposito;

public class Nota {
    private Alumno alumno;
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

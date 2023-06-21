package com.Proyecto.ProyectoManuelEsposito;

import java.util.ArrayList;

public class Academia {
    private ArrayList<Materia> materias;
    private ArrayList<Curso>cursos;
    private ArrayList<Profesor>profesores;
    private ArrayList<Alumno>alumnos;

    public Academia(ArrayList<Materia> materias, ArrayList<Curso> cursos, ArrayList<Profesor> profesores, ArrayList<Alumno> alumnos) {
        this.materias = materias;
        this.cursos = cursos;
        this.profesores = profesores;
        this.alumnos = alumnos;
    }

    public Academia() {
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Academia{" +
                "materias=" + materias +
                ", cursos=" + cursos +
                ", profesores=" + profesores +
                ", alumnos=" + alumnos +
                '}';
    }
}

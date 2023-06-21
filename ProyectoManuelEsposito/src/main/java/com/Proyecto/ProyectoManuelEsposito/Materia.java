package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Materia {
    private String nombre;
    private ArrayList<Nota> alumnos;
    private String infoMateria;
    private Profesor profesor;

    public Materia(String nombre, ArrayList<Nota> alumnos, String infoMateria, Profesor profesor) {
        this.nombre = nombre;
        this.alumnos = alumnos;
        this.infoMateria = infoMateria;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Nota> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Nota> alumnos) {
        this.alumnos = alumnos;
    }

    public String getInfoMateria() {
        return infoMateria;
    }

    public void setInfoMateria(String infoMateria) {
        this.infoMateria = infoMateria;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public void agregarAlumnoAMateria(){

    }
    public void agregarMateriaAArchivo(String nombreArchivo,Materia nuevaMateria){
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String datosJson = objectMapper.writeValueAsString(nuevaMateria);
            FileWriter fileWriter=new FileWriter(nombreArchivo,true);
            fileWriter.write(datosJson);
            fileWriter.close();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Materia[] leerArchivo(){
        String nombreArchivo="Materias.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File archivo = new File(nombreArchivo);
            Materia[] materias = objectMapper.readValue(archivo, Materia[].class);

            return materias;
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo JSON: " + e.getMessage());
        }
        return null;
    }
    public static String notasAlumno(Alumno alumno){
        String nombreArchivo="Materias.json";
        String notas="";
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            File archivo= new File(nombreArchivo);
            Materia[] materias = objectMapper.readValue(archivo, Materia[].class);
            for (int i=0;i< materias.length;i++)
            {
                Materia materia=materias[i];
                for (int j=0;j<materia.getAlumnos().size();j++){
                    if (materia.getAlumnos().get(j).getAlumno().equals(alumno)){
                        notas+=materia.nombre+": "+materia.getAlumnos().get(j).getNota()+'\'';
                    }
                }
            }
            return notas;
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", infoMateria='" + infoMateria + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}

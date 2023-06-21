package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", infoMateria='" + infoMateria + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}

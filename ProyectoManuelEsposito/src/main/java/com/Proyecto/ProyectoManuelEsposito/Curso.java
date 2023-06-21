package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Curso {
    @JsonProperty("nombre")
    private String nombre;
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
    public void agregarCursoAArchivo(String nombreArchivo,Curso nuevoCurso){
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String datosJson = objectMapper.writeValueAsString(nuevoCurso);
            FileWriter fileWriter=new FileWriter(nombreArchivo,true);
            fileWriter.write(datosJson);
            fileWriter.close();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Curso[] leerArchivo(){
        String nombreArchivo="Cursos.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File archivo = new File(nombreArchivo);
            Curso[] cursos = objectMapper.readValue(archivo, Curso[].class);

            return cursos;
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo JSON: " + e.getMessage());
        }
        return null;
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

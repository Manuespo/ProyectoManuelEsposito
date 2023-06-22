package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Alumno {
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("edad")
    private int edad;
    @JsonProperty("legajo")
    private int legajo;

    public Alumno(String nombre, String apellido, int edad, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.legajo = legajo;
    }

    public Alumno() {
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

    public static void agregarAlumnoAArchivo(Alumno nuevoAlumno){
        String nombreArchivo="Alumnos.json";
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String datosJson = objectMapper.writeValueAsString(nuevoAlumno);
            FileWriter fileWriter=new FileWriter(nombreArchivo,true);
            fileWriter.write(datosJson);
            fileWriter.close();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Alumno buscarAlumno(String nombre){
        String nombreArchivo="Alumnos.json";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File archivo = new File(nombreArchivo);
            Alumno[] alumnos = objectMapper.readValue(archivo, Alumno[].class);
            for (int i=1;i<alumnos.length;i++)
            {
                if (alumnos[i].getNombre().equals(nombre))
                    return alumnos[i];
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo JSON: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", legajo=" + legajo +
                '}';
    }
}

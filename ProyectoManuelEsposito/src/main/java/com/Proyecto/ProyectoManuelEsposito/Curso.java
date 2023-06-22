package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
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
    @JsonProperty("alumnos")
    private ArrayList<Alumno> alumnos;

    public Curso(String nombre, ArrayList<Materia> materias, String infoCurso) {
        this.nombre = nombre;
        this.materias = materias;
        this.infoCurso = infoCurso;
    }

    public Curso(String nombre, String infoCurso) {
        this.nombre = nombre;
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

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public static void agregarAlumnoAlCurso(Alumno alumno, String curso){
        String nombreArchivo="Cursos.json";
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            File archivo = new File(nombreArchivo);
            Curso[] cursos = objectMapper.readValue(archivo, Curso[].class);
            for (int i=0;i<cursos.length;i++)
            {
                if (cursos[i].getNombre().equals(curso))
                    cursos[i].getAlumnos().add(alumno);
            }
            String datosJson= objectMapper.writeValueAsString(cursos);
            FileWriter fileWriter=new FileWriter("Cursos.json");
            fileWriter.write(datosJson);
            fileWriter.close();


        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void agregarCursoAArchivo(Curso nuevoCurso){
        String nombreArchivo="Cursos.json";
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
    public static void agregarMateriaAlCurso(String curso, String materia){
        String nombreArchivo="Cursos.json";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File archivo = new File(nombreArchivo);
            File archivo2= new File("Materias.json");
            Curso[] cursos = objectMapper.readValue(archivo, Curso[].class);
            Materia[] materias=objectMapper.readValue(archivo2, Materia[].class);
            for (int i=0;i< cursos.length;i++)
            {
                if (cursos[i].getNombre().equals(curso))
                {
                    for (int j=0;j< materias.length;j++)
                    {
                        if (materias[j].getNombre().equals(materia)) {
                            cursos[i].getMaterias().add(materias[j]);
                            break;
                        }
                    }
                }
            }
            String datosJson= objectMapper.writeValueAsString(cursos);
            FileWriter fileWriter=new FileWriter("Cursos.json");
            fileWriter.write(datosJson);
            fileWriter.close();
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

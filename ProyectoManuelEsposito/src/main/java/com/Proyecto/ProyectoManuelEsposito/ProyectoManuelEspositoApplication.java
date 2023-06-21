package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class ProyectoManuelEspositoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoManuelEspositoApplication.class, args);
		Academia academia=new Academia();
		menu();


	}

	private static void menu() {
		boolean parar=false;
		Scanner scanner=new Scanner(System.in);
		System.out.println("------------------------------");
		System.out.println("Bienvenido a Udemy premium");
		while (!parar){
			System.out.println("Ingrese una opcion");
			System.out.println("1. Cursos");
			System.out.println("2. Ingresar como alumno");
			System.out.println("3. Ingresar como profesor");
			System.out.println("4.Salir");
			int opcion=scanner.nextInt();
			switch (opcion)
			{
				case  1: menu1();
					break;
				case 2: menu2();
					break;
				case 3:
					break;
				case 4: parar=true;
				break;
			}
		}
	}
	private static void menu1(){
		Curso [] cursos=Curso.leerArchivo();

			for (int i=0;i<cursos.length;i++){
				System.out.println(i+". "+cursos[i]);
			}
		System.out.println("Presiona Enter para continuar...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	private static void menu2(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Ingrese nombre del alumno");
		String nombre=scanner.nextLine();
		Alumno alumno= Alumno.buscarAlumno(nombre);
		boolean parar=false;
		if (alumno==null)
		{
			String apellido;
			int edad;
			int legajo;
			System.out.println("Su nombre no se encuentra en el sistema. Procederemos a ingresarlo en el sistema");
			System.out.println("Ingrese su apellido");
			apellido=scanner.nextLine();
			System.out.println("Ingrese su edad");
			edad=scanner.nextInt();
			System.out.println("Ingrese su numero de legajo");
			legajo=scanner.nextInt();
			alumno=new Alumno(nombre,apellido,edad,legajo);
			Alumno.agregarAlumnoAArchivo(alumno);
		}

		while (!parar){
		}
		if (alumno==null) {
			System.out.println("1. Ver datos del alumno");
			System.out.println("2. Ver notas del alumno");
			System.out.println("3. Inscribirse a un curso");
		}
		else
		System.out.println(alumno);
		System.out.println(Materia.notasAlumno(alumno));
	}

}


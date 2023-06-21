package com.Proyecto.ProyectoManuelEsposito;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ProyectoManuelEspositoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoManuelEspositoApplication.class, args);
		//Escribir Json en archivo
		//File file=new File("miArchivo.json");
		//ObjectMapper mapper=new ObjectMapper();
		//mapper.writeValue(file,Objeto);
		//Leer Json de archivo
		//File file = new File(“mi_archivo.json”);
		//
		// ObjectMapper mapper = new ObjectMapper();
		// Persona p = mapper.readValue(file, Persona.class);


	}

}

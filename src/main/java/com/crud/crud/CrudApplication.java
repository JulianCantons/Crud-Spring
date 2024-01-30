package com.crud.crud;

import com.crud.crud.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);



	}

	@Autowired
	private EstudianteRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		/*
		Estudiante est1 = new Estudiante("Julian", "Cantons","cantonsjulian@gmail.com", "37930619");
		repositorio.save(est1);

		Estudiante est2 = new Estudiante("Juan Roman", "Riquelme","riquelme10@gmail.com", "27862120");
		repositorio.save(est2);

	*/

	}

}

package com.app.web;

import com.app.web.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class VulcaLarApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VulcaLarApplication.class, args);
	}

	@Autowired
	EmpleadoRepositorio empleadoRepositorio;

	@Override
	public void run(String... args) throws Exception {

	}
}

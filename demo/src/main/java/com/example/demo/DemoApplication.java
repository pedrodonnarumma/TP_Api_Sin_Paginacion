package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {
	@Autowired
	AutorRepository autorRepository;

	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	LibroRepository libroRepository;
	@Autowired
	LocalidadRepository localidadRepository;
	@Autowired
	PersonaRepository personaRepository;


	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AutorRepository autorRepository,
						   DomicilioRepository domicilioRepository, LibroRepository libroRepository,
						   LocalidadRepository localidadRepository, PersonaRepository personaRepository) {
		return args -> {
			Autor autor = Autor.builder()
					.nombre("Stephen")
					.apellido("King")
					.biografia("Escritor estadounidense de novelas de terror," +
							" ficción sobrenatural, misterio, ciencia ficción y " +
							"literatura fantástica. ")
					.build();
			autorRepository.save(autor);

			Localidad localidad = Localidad.builder()
					.denominacion("Lujan de cuyo")
					.build();
			localidadRepository.save(localidad);

			Localidad localidad1 = Localidad.builder()
					.denominacion("Mendoza")
					.build();
			localidadRepository.save(localidad1);

		Domicilio domicilio = Domicilio.builder()
				.calle("Viamonte")
				.numero(1231)
				.localidad(localidad)
				.build();
		domicilioRepository.save(domicilio);

		Domicilio domicilio1 = Domicilio.builder()
				.calle("Rodriguez")
				.numero(432)
				.localidad(localidad1)
				.build();
		domicilioRepository.save(domicilio1);

		};
	}
}

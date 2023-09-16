package com.jsca.jsca.prueba;

import com.jsca.jsca.prueba.service.BeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.env.Environment;


@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Application {

	@Autowired
	private Environment env;
	@Autowired
	private BeneficioService beneficioService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		BeneficioService beneficioService = context.getBean(BeneficioService.class);

		String rutaArchivoJSON = "C:\\Users\\Sebas\\Desktop\\Prueba de BackEnd\\ClientesBack\\jsca.prueba\\src\\main\\resources\\sk_formato.json";


		beneficioService.cargarBeneficiosDesdeJSON(rutaArchivoJSON);
		// Obtenemos la ruta del archivo XML desde el archivo de propiedades
		String rutaArchivoXML = context.getEnvironment().getProperty("rutaArchivoXML");

		// Cargamos los beneficios desde el archivo XML
		beneficioService.cargarBeneficiosDesdeXML(rutaArchivoXML);
	}
	}




package com.nagarro.pmp.PMPBackend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nagarro.pmp.PMPBackend")
public class PmpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmpBackendApplication.class, args);
	}
}

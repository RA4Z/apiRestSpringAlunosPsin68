package br.com.senai;

import br.com.senai.api.controller.PessoaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LogisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaApplication.class, args);
		System.out.println("macarrão");
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}

}

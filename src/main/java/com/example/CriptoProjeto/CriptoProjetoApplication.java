package com.example.CriptoProjeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * DataSourceAutoConfiguration é para excluir a configuração de DB por enquanto.
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CriptoProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriptoProjetoApplication.class, args);
	}

}

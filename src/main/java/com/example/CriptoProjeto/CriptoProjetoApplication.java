package com.example.CriptoProjeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * DataSourceAutoConfiguration é para excluir a configuração de DB por enquanto.
 * exclude = {DataSourceAutoConfiguration.class }
 */

@SpringBootApplication()
public class CriptoProjetoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CriptoProjetoApplication.class, args);
	}

}

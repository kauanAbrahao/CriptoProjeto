package com.cripto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

/**
 * DataSourceAutoConfiguration é para excluir a configuração de DB por enquanto.
 * exclude = {DataSourceAutoConfiguration.class }
 */

@SpringBootApplication()
@EnableScheduling
public class CriptoProjetoApplication extends SpringBootServletInitializer {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(CriptoProjetoApplication.class, args);
	}


}

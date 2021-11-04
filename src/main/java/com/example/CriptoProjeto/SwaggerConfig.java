package com.example.CriptoProjeto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String CRIPTO_VALOR = "Cripto Valor";
    public static final String CRIPTOMOEDAS = "Criptomoedas";
    public static final String PING = "Ping";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.CriptoProjeto.business.endpoint"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(PING, "Verifica o status do servidor da API", 0))
                .tags(new Tag(CRIPTOMOEDAS, "Buscar lista de criptomoedas suportadas", 1))
                .tags(new Tag(CRIPTO_VALOR, "Buscar current price, market cap etc", 2))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ModoCripto - Portal de Criptomoeda")
                .description("Dados atuais e históricos do mercado de criptomoedas internacional")
                .version("1.0.1")
                .license("by ModoCripto")
                .licenseUrl("https://www.modocripto.com.br")
                       .contact(new Contact ("Martins & Perseguini", null,
                                "modocripto@gmail.com"))
                        .build();
    }
}

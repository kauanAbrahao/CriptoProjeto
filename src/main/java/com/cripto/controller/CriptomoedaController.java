package com.cripto.controller;

import com.cripto.controller.resource.CriptomoedaResource;
import com.cripto.entity.dto.CriptomoedaDTO;
import com.cripto.service.CriptomoedaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("${spring.url}")
public class CriptomoedaController implements CriptomoedaResource {

    @Autowired
    CriptomoedaService criptomoedaService;

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CriptomoedaDTO>> buscaTodasCriptomoedas(){
        try{
            return criptomoedaService.getAll();
        } catch (Exception e){
            log.error("==> Exception no GET /list. " + e.getMessage());
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Unexpected error. Try again later");
        }
    }
}

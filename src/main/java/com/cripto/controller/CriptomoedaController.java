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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${spring.url}")
public class CriptomoedaController implements CriptomoedaResource {

    @Autowired
    CriptomoedaService criptomoedaService;

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CriptomoedaDTO>> buscaTodasCriptomoedas(){
        return criptomoedaService.getAll();
    }

    @GetMapping(path = "/coin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscaCriptomoedaPorId(@PathVariable(name = "id") String id){
        return criptomoedaService.getPorId(id);
    }
}

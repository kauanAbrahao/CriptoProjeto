package com.cripto.controller;

import com.cripto.controller.resource.CriptoValorResource;
import com.cripto.entity.dto.CriptoValorDTO;
import com.cripto.service.CriptoValorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${spring.url}")
public class CriptoValorController implements CriptoValorResource {

    @Autowired
    CriptoValorService criptoValorService;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CriptoValorDTO>> getAll() {
        return criptoValorService.buscaTodasCriptoValor();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> getPorId(@PathVariable(name = "id") String idCriptoValor){
        return criptoValorService.getCriptoValorPorId(idCriptoValor);
    }

    @GetMapping(path = "/mktRank", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAcimaRank(@RequestParam(name = "mktCapRank") Integer mktCapRank) {
        return criptoValorService.getCriptoValorListPorRank(mktCapRank);
    }
}

package com.cripto.controller;

import com.cripto.entity.dto.CriptoValorDTO;
import com.cripto.service.CriptoValorService;
import com.cripto.entity.CriptoValor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("${spring.url}")
public class CriptoValorController {

    @Autowired
    CriptoValorService criptoValorService;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CriptoValorDTO>> getAll() {
        try {
            return criptoValorService.buscaTodasCriptoValor();
        } catch (Exception e) {
            log.error("==> Exception no GET /list. " + e.getMessage());
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Unexpected error. Try again later");
        }
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> getPorId(@PathVariable(name = "id") String idCriptoValor){
        try{
            return criptoValorService.getCriptoValorPorId(idCriptoValor);
        } catch (Exception e){
            log.error("==> Exception no GET /list. " + e.getMessage());
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Unexpected error. Try again later");
        }
    }

    @GetMapping(path = "/mktRank", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAcimaRank(@RequestParam(name = "mktCapRank") Integer mktCapRank) {
        return criptoValorService.getCriptoValorListPorRank(mktCapRank);
    }
}

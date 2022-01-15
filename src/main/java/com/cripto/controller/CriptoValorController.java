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
@Slf4j
@RequestMapping("${spring.url}")
public class CriptoValorController implements CriptoValorResource {

    @Autowired
    CriptoValorService criptoValorService;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CriptoValorDTO>> getAll() {
        try {
            return criptoValorService.buscaTodasCriptoValor();
        } catch (Exception e) {
            log.error("==> Exception no GET /all. " + e.getMessage(), e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> getPorId(@PathVariable(name = "id") String idCriptoValor){
        try{
            return criptoValorService.getCriptoValorPorId(idCriptoValor);
        } catch (Exception e){
            log.error("==> Exception no GET /{id}. " + e.getMessage(), e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = "/mktRank", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAcimaRank(@RequestParam(name = "mktCapRank") Integer mktCapRank) {

        try{
            return criptoValorService.getCriptoValorListPorRank(mktCapRank);
        } catch (Exception e){
            log.error("==> Exception no GET /mktRank. " + e.getMessage(), e.getCause());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

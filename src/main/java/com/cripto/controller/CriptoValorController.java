package com.cripto.controller;

import com.cripto.controller.resource.CriptoValorResource;
import com.cripto.entity.dto.CriptoValorDTO;
import com.cripto.service.CriptoValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("${spring.url}")
public class CriptoValorController implements CriptoValorResource {

    @Autowired
    CriptoValorService criptoValorService;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CriptoValorDTO>> getAll(String sortingValue) {
        var result = criptoValorService.buscaTodasCriptoValor();

        if(sortingValue.equalsIgnoreCase("current_price")){
            result.sort(Comparator.comparing(CriptoValorDTO::getCurrent_price).reversed());
        }
        else{
            result.sort(Comparator.comparing(CriptoValorDTO::getMarket_cap).reversed());
        }
            return ResponseEntity.ok(result);
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

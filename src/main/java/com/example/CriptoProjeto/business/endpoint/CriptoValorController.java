package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.SwaggerConfig;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import com.example.CriptoProjeto.service.CriptoValorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1/api-criptovalor")
public class CriptoValorController implements CriptoValorResource {

    final static String API_RESPONSE_BITCOIN = " {\"id\": \"bitcoin\", \"current_price\": 61089, \"market_cap\": 1151848890506, \"total_volume\": 34432896570} ";

    @Autowired
    CriptoValorService criptoValorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        return criptoValorService.getAllCriptoValor();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> getPorId(@PathVariable(name = "id")
                                      @ApiParam(name = "id", example = "bitcoin", type = "String", required = true,
                                              value = "id da criptomoeda \n *faz referência a /v1/api-criptomoedas") String idCriptoValor){
        return criptoValorService.getCriptoValorPorId(idCriptoValor);

    }

    @GetMapping(path = "/mktRank", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAcimaRank(
                      @RequestParam(name = "mkt_cap_rank")
                      @ApiParam(name = "mkt_cap_rank", example = "2", type = "Integer", required = true,
                            value = "market cap rank da criptomoeda \n *faz referência a /v1/api-criptomoedas")
                            Integer mkt_cap_rank) {
        return criptoValorService.getCriptoValorListPorRank(mkt_cap_rank);
    }
}

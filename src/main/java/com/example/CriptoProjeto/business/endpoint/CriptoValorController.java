package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.business.endpoint.resource.CriptoValorResource;
import com.example.CriptoProjeto.service.CriptoValorHistService;
import com.example.CriptoProjeto.service.CriptoValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${spring.url}")
public class CriptoValorController implements CriptoValorResource {

    final static String API_RESPONSE_BITCOIN = " {\"id\": \"bitcoin\", \"current_price\": 61089, \"market_cap\": 1151848890506, \"total_volume\": 34432896570} ";

    @Autowired
    CriptoValorService criptoValorService;

    @Autowired
    CriptoValorHistService criptoValorHistService;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        return criptoValorService.getAllCriptoValor();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> getPorId(@PathVariable(name = "id") String idCriptoValor){
        return criptoValorService.getCriptoValorPorId(idCriptoValor);
    }

    @GetMapping(path = "/mktRank", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAcimaRank(@RequestParam(name = "mkt_cap_rank") Integer mkt_cap_rank) {
        return criptoValorService.getCriptoValorListPorRank(mkt_cap_rank);
    }

}

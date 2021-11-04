package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.SwaggerConfig;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import com.example.CriptoProjeto.service.CriptoValorHistService;
import com.example.CriptoProjeto.service.CriptoValorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1/api-criptovalor")
public class CriptoValorController implements CriptoValorResource {

    final static String API_RESPONSE_BITCOIN = " {\"id\": \"bitcoin\", \"current_price\": 61089, \"market_cap\": 1151848890506, \"total_volume\": 34432896570} ";

    @Autowired
    CriptoValorService criptoValorService;

    @Autowired
    CriptoValorHistService criptoValorHistService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(path = "/refdate/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllDate(@PathVariable(name = "date") String dataRef) {
        return criptoValorHistService.getAllCriptoValorDate(dataRef);
    }

    @GetMapping(path = "/refdate/{id}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDateId(@PathVariable(name = "id") String idCripto, @PathVariable(name="date") String dataRef){
        return criptoValorHistService.getCriptoValorDatePorId(idCripto, dataRef);
    }

    @GetMapping(path ="/history", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRangeDate(@RequestParam(name = "from") String dtInicial,
                                          @RequestParam(name = "to") String dtFim) {
        return criptoValorHistService.getCriptoValorRangeDate(dtInicial, dtFim);
    }

    @GetMapping(path="/history/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRangeDateId(@PathVariable(name = "id") String idCripto,
                                            @RequestParam(name = "from") String dtInicial,
                                            @RequestParam(name = "to") String dtFim) {

        return criptoValorHistService.getCriptoValorRangeDateId(dtInicial, dtFim, idCripto);
    }
}

package com.cripto.controller;

import com.cripto.controller.resource.CriptoValorHistResource;
import com.cripto.service.CriptoValorHistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CriptoValorHistController implements CriptoValorHistResource {

    @Autowired
    CriptoValorHistService criptoValorHistService;

    @GetMapping(path = "/refdate/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllDate(@PathVariable(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataRef) {
        return criptoValorHistService.getAllCriptoValorDate(dataRef);
    }

    @GetMapping(path = "/refdate/{id}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDateId(@PathVariable(name = "id") String idCripto, @PathVariable(name="date")
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataRef){
        return criptoValorHistService.getCriptoValorDatePorId(idCripto, dataRef);
    }

    @GetMapping(path ="/history", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRangeDate(@RequestParam(name = "from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dtInicial ,
                                          @RequestParam(name = "to")   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dtFim) {
        return criptoValorHistService.getCriptoValorRangeDate(dtInicial, dtFim);
    }

    @GetMapping(path="/history/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRangeDateId(@PathVariable(name = "id") String idCripto,
                                            @RequestParam(name = "from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dtInicial,
                                            @RequestParam(name = "to")   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dtFim) {

        return criptoValorHistService.getCriptoValorRangeDateId(dtInicial, dtFim, idCripto);
    }
}

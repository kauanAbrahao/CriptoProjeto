package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.business.endpoint.resource.CriptoValorHistResource;
import com.example.CriptoProjeto.service.CriptoValorHistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${spring.url}")
public class CriptoValorHistController implements CriptoValorHistResource {

    @Autowired
    CriptoValorHistService criptoValorHistService;

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

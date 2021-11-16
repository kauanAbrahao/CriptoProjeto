package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.business.endpoint.resource.CriptomoedaResource;
import com.example.CriptoProjeto.service.CriptomoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${spring.url}")
public class CriptomoedaController implements CriptomoedaResource {


    @Autowired
    CriptomoedaService criptomoedaService;

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        return criptomoedaService.getAll();
    }


}

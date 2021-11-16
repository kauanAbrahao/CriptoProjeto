package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.business.endpoint.resource.CriptoExtremosResource;
import com.example.CriptoProjeto.service.CriptoExtremoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${spring.url}")
public class CriptoExtremosController implements CriptoExtremosResource {

    @Autowired
    CriptoExtremoService criptoExtremoService;

    @GetMapping(path ="/extr/{data}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(@PathVariable (name = "data") String dataRef) {
        return criptoExtremoService.getAll(dataRef);
    }
}

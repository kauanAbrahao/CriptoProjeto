package com.cripto.controller;

import com.cripto.controller.resource.CriptoExtremosResource;
import com.cripto.service.CriptoExtremoService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("${spring.url}")
public class CriptoExtremosController implements CriptoExtremosResource {

    @Autowired
    CriptoExtremoService criptoExtremoService;

    @GetMapping(path ="/highlow/{data}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(@PathVariable (name = "data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataRef) {
        return criptoExtremoService.getAll(dataRef);
    }

    @GetMapping(path = "/highlow/{data}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable(name = "data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataRef,
                                     @PathVariable(name = "id") String id){
        return criptoExtremoService.getById(dataRef, id);
    }
}

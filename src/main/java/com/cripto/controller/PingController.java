package com.cripto.controller;

import com.cripto.controller.resource.PingResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${spring.url}")
public class PingController implements PingResource {

    static final String body = "{\"modo_cripto\": \"lets goo!\"}";

    @GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok().body(body);
    }
}

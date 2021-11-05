package com.example.CriptoProjeto.business.endpoint;

import com.example.CriptoProjeto.SwaggerConfig;
import com.example.CriptoProjeto.entity.dto.CriptoValorDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${spring.url}")
@Api(tags = {SwaggerConfig.PING})
public class PingController {

    static final String RESPOSTA = "{\"modo_cripto\": \"lets goo!\"}";

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok().body(RESPOSTA);
    }
}

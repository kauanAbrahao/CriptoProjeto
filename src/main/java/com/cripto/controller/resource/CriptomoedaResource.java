package com.cripto.controller.resource;

import com.cripto.entity.Criptomoeda;
import com.cripto.entity.dto.CriptomoedaDTO;
import com.cripto.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Api(tags = {SwaggerConfig.CRIPTOMOEDAS})
public interface CriptomoedaResource {

    @ApiOperation(value = "Retorna lista de informações básicas de todas as criptomoedas suportadas na API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CriptomoedaDTO[].class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")
    })
    public ResponseEntity<List<CriptomoedaDTO>> buscaTodasCriptomoedas();

    @ApiOperation(value = "Retorna lista de informações básicas de uma criptomoeda específica suportada na API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Criptomoeda.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Timeout")
    })
    public ResponseEntity<Criptomoeda> buscaCriptomoedaPorId(String idCriptomoeda);
}

package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.MoedaDAOImpl;
import com.example.CriptoProjeto.entity.CriptoModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe responsável por devolver JSON de Criptomoedas
 */
@RestController
@RequestMapping("/")
public class DevolveMoedaBusiness {

    @Autowired
    MoedaDAOImpl moedaDAO;

    @GetMapping("/jsonCripto")
    public List<CriptoModelo> buscaCriptomoedas(){
        return moedaDAO.buscarMoedas();
    }

    @GetMapping("/jsonMoedaEspecifica/{idCripto}")
    public ResponseEntity<CriptoModelo> buscaCriptomoedaPorId(@PathVariable(value = "idCripto") String idCripto){
        CriptoModelo criptoModelo = moedaDAO.buscarCriptoPorId(idCripto);
        return ResponseEntity.ok().body(criptoModelo);
    }
}

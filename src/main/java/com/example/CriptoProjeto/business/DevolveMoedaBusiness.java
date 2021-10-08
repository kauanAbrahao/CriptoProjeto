package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.MoedaDAOImpl;
import com.example.CriptoProjeto.entity.Criptomoeda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Criptomoeda> buscaCriptomoedas(){
        return moedaDAO.buscarMoedas();
    }
}

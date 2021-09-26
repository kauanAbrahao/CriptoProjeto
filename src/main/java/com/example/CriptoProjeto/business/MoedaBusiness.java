package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.MoedaDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class MoedaBusiness {

    @Autowired
    MoedaDAOImpl moedaDAO;

    @RequestMapping("/")
    public String adicionarMoeda(){
        return moedaDAO.adicionaMoeda();
    }
}

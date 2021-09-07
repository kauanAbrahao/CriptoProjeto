package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.StringDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class StringBusiness {

    @Autowired
    StringDAOImpl stringDAO;

    @RequestMapping("/")
    public String imprimeHelloWorld(){
        System.out.println(stringDAO.buscaStringNaBase());
        return stringDAO.buscaStringNaBase();
    }
}

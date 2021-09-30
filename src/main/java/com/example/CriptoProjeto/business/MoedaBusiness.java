package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.MoedaDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoedaBusiness {

    @Autowired
    MoedaDAOImpl moedaDAO;

    @RequestMapping("/")
    public String adicionarMoeda(){
        try{
            return "index";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/formRemove")
    public String mostraFormParaRemover(){
        return "formRemover";
    }

    @RequestMapping("/formProcessa")
    public String processaForm(){
        return "olá, deu certo :)";
    }
}

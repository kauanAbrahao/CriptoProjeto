package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.MoedaDAOImpl;
import com.example.CriptoProjeto.entity.Criptomoeda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoedaBusiness {

    @Autowired
    MoedaDAOImpl moedaDAO;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("criptomoeda", new Criptomoeda());
        try{
            return "index";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/testaBanco")
    public String testaBancoInserindoMoeda(@ModelAttribute Criptomoeda criptomoeda){
        return moedaDAO.adicionaMoeda(criptomoeda);
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

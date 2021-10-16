package com.example.CriptoProjeto.business;

import com.example.CriptoProjeto.dao.CriptomoedaDAOImpl;
import com.example.CriptoProjeto.entity.Criptomoeda;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/addCripto")
public class InitializerCriptomoedaBusiness {

    @Autowired
    CriptomoedaDAOImpl criptomoedaDAO;

    @Autowired
    GsonReceiver gsonReceiver;

    @RequestMapping("/criptomoedas")
    public void adicionaCriptomoedas() throws IOException {

        String json = gsonReceiver.getCriptoJsonMarkets();

        List<Criptomoeda> criptomoedaList = GsonParser.jsonToCriptomoedaList(json);
        for(Criptomoeda criptomoeda : criptomoedaList){
            criptomoedaDAO.adicionaCriptomoedas(criptomoeda);
        }
    }
}

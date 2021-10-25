package com.example.CriptoProjeto.dao;

import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class CriptomoedaDAOImplTest extends AbstractDAOTest {

    @Autowired
    GsonReceiver gsonReceiver;

    @Autowired
    CriptomoedaDAOImpl criptomoedaDAO;


    @After
    public void limpaBase(){
        super.limpaTabValor();
    }

    @Test
    @Ignore
    public void contextLoads(){
        Assert.assertNotNull(criptomoedaDAO);
        Assert.assertNotNull(gsonReceiver);
    }



    @Test
    public void adicionarCriptoValorTest() throws IOException {
        //Dado que um JSON foi buscado e transformado em CriptoValor
        String json = gsonReceiver.getCriptoJsonMarkets();
        List<CriptoValor> criptoValorList = GsonParser.jsonToObjectList(json, CriptoValor[].class);
        try{
            criptomoedaDAO.adicionarCriptoValor(criptoValorList.get(0));
            CriptoValor criptoValor = super.buscaCriptoValorTestAux(criptoValorList.get(0));
            Assert.assertNotNull(criptoValor);
        } catch (Exception e){
            Assert.fail("Exception na chamada do DAO");
        }

    }
}

package com.example.CriptoProjeto.dao;

import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@DataJdbcTest
public class CriptomoedaDAOImplTest extends AbstractDAOTest {

    @Autowired
    GsonReceiver gsonReceiver;

    @Autowired
    CriptomoedaDAOImpl criptomoedaDAO;

    @Test
    public void contextLoads(){
        Assert.assertNotNull(criptomoedaDAO);
        Assert.assertNotNull(gsonReceiver);
    }

    @Test
    public void adicionarCriptoValorTest() throws IOException {

        //Dado que um JSON foi buscado e transformado em CriptoValor
        String json = gsonReceiver.getCriptoJsonMarkets();
        List<CriptoValor> criptoValorList = GsonParser.jsonToObjectList(json, true);
        try{
            for (CriptoValor criptoValor : criptoValorList){
                criptomoedaDAO.adicionarCriptoValor(criptoValor);
            }
        } catch (Exception e){
            Assert.fail("Exception no Insert");
        }

    }
}

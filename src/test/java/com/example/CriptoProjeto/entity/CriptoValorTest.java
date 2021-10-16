package com.example.CriptoProjeto.entity;

import com.example.CriptoProjeto.entity.CriptoValor;
import com.example.CriptoProjeto.entity.enums.EnumCripto;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;


public class CriptoValorTest {

    GsonReceiver gsonReceiver = new GsonReceiver();

    @Test
    public void criptoValor_preencheListaDeObjetosTeste() throws IOException {
        String jsonValor = gsonReceiver.getCriptoJsonMarkets();
        List<CriptoValor> criptoValorList = GsonParser.jsonToObjectList(jsonValor, true);
        System.out.println(criptoValorList.get(0).toString());
        Assert.assertTrue(criptoValorList.size() > 1);
        Assert.assertTrue(criptoValorList.get(0).getId().equals(EnumCripto.BITCOIN.getId()));
        Assert.assertTrue(criptoValorList.get(1).getId().equals(EnumCripto.ETHEREUM.getId()));
        Assert.assertNotNull(criptoValorList.get(0).getMktCap());

    }
}

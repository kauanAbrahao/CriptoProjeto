package com.example.CriptoProjeto.entity;

import com.example.CriptoProjeto.entity.enums.EnumCripto;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CriptomoedaTest {

    GsonReceiver gsonReceiver = new GsonReceiver();

    @Test
    public void criptoValor_preencheListaDeObjetosTeste() throws IOException {
        //Pegando uma criptomoeda em específico (bitcoin)
        String json = gsonReceiver.getCriptoJson();

        Criptomoeda criptomoeda = (Criptomoeda) GsonParser.jsonToObject(json, Criptomoeda.class);
        Assert.assertNotNull(criptomoeda);
        Assert.assertEquals(criptomoeda.getId().toLowerCase(), EnumCripto.BITCOIN.getId());

    }
}

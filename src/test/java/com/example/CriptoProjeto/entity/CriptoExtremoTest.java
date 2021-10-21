package com.example.CriptoProjeto.entity;

import com.example.CriptoProjeto.entity.enums.EnumCripto;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CriptoExtremoTest {

    GsonReceiver gsonReceiver = new GsonReceiver();

    @Test
    public void criptoExtremo_retornaJson_listaDeExtremosTeste() throws IOException {
        String jsonExtremos = gsonReceiver.getCriptoJsonMarkets();
        Assert.assertNotNull(jsonExtremos);

    }

    @Test
    public void criptoExtremo_preencheListaDeObjetosTeste() throws IOException {
        String jsonExtremos = gsonReceiver.getCriptoJsonMarkets();
        List<CriptoExtremo> criptoExtremoList = GsonParser.jsonToObjectList(jsonExtremos, CriptoExtremo[].class);
        System.out.println(criptoExtremoList.get(0).toString());
        Assert.assertTrue(criptoExtremoList.size() > 1);
        Assert.assertTrue(criptoExtremoList.get(0).getId().equals(EnumCripto.BITCOIN.getId()));
        Assert.assertTrue(criptoExtremoList.get(1).getId().equals(EnumCripto.ETHEREUM.getId()));

    }
}

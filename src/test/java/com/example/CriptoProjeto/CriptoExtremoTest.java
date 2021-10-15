package com.example.CriptoProjeto;

import com.example.CriptoProjeto.entity.*;
import com.example.CriptoProjeto.entity.enums.EnumCripto;
import com.example.CriptoProjeto.entrypoint.GsonParser;
import com.example.CriptoProjeto.entrypoint.GsonReceiver;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

import java.io.IOException;

public class CriptoExtremoTest {

    GsonReceiver gsonReceiver = new GsonReceiver();

    @Test
    public void criptoExtremo_retornaJson_listaDeExtremos() throws IOException {
        String jsonExtremos = gsonReceiver.getCriptoJsonMarkets();
        Assert.assertNotNull(jsonExtremos);

    }

    @Test
    public void criptoExtremo_preencheListaDeObjetos() throws IOException {
        String jsonExtremos = gsonReceiver.getCriptoJsonMarkets();
        List<CriptoExtremo> criptoExtremoList = GsonParser.jsonToObjectList(jsonExtremos);
        System.out.println(criptoExtremoList.get(0).toString());
        Assert.assertTrue(criptoExtremoList.size() > 1);
        Assert.assertTrue(criptoExtremoList.get(0).getId().equals(EnumCripto.BITCOIN.getId()));
        Assert.assertTrue(criptoExtremoList.get(1).getId().equals(EnumCripto.ETHEREUM.getId()));

    }

    @Test
    public void criptoValor_preencheListaDeObjetos() throws IOException {
        String jsonValor = gsonReceiver.getCriptoJsonMarkets();
        List<CriptoValor> criptoValorList = GsonParser.jsonToObjectList(jsonValor, true);
        System.out.println(criptoValorList.get(0).toString());
        Assert.assertTrue(criptoValorList.size() > 1);
        Assert.assertTrue(criptoValorList.get(0).getId().equals(EnumCripto.BITCOIN.getId()));
        Assert.assertTrue(criptoValorList.get(1).getId().equals(EnumCripto.ETHEREUM.getId()));
        Assert.assertNotNull(criptoValorList.get(0).getMarket_cap());

    }
}

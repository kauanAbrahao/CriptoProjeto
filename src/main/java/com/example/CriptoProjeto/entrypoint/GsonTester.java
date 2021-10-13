package com.example.CriptoProjeto.entrypoint;

import com.example.CriptoProjeto.entity.Criptomoeda;

import java.io.IOException;
import java.util.List;

public class GsonTester {

    public static void main(String[] args) throws IOException {
        System.out.println("==== JSON - BUSCANDO BITCOIN ====");
        GsonReceiver gsonReceiver = new GsonReceiver();
        System.out.println(gsonReceiver.getCriptoJson());

        String jsonFromGecko = gsonReceiver.getCriptoJson();
        Criptomoeda criptomoeda = GsonParser.jsonToObject(jsonFromGecko);
        System.out.println(criptomoeda.getId() + ", " +  criptomoeda.getName());

        System.out.println("\n" + "==== JSON - LISTA DE CRIPTO ====");
        String jsonListFromGecko = gsonReceiver.getListCriptoJson();
        List<Criptomoeda> criptomoedaList = GsonParser.jsonToObjectList(jsonListFromGecko);
        for (Criptomoeda criptomoeda1 : criptomoedaList){
            System.out.println(criptomoeda1.getName());
        }
    }
}

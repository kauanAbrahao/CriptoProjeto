package com.example.CriptoProjeto.entrypoint;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

@Component
public class GsonHistory {

    String VALOR_HISTORY = "https://api.coingecko.com/api/v3/coins/";

    public String getHistoryJson(String idCripto, String l) throws IOException {
        URL url = new URL(VALOR_HISTORY+idCripto+"/history?date="+l);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(RequestMethod.GET.toString());
        connection.setRequestProperty("Accept", "application/json");

        if(connection.getResponseCode() > 299){
            throw new IOException("Erro código HTTP: " + connection.getResponseCode());
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer saida = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            saida.append(line);
        }
        bufferedReader.close();

        System.out.println("Response HTTP: " + connection.getResponseCode());
        return saida.toString();

    }
}

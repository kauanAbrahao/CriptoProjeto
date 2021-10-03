package com.example.CriptoProjeto.entrypoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonReceiver {

    private static HttpURLConnection connection;


    //Como enviar um HTTP request?
    //Método 01: HttpURLConnection
    public static void main(String[] args){

        BufferedReader bufferedReader;
        String line;
        StringBuffer conteudo = new StringBuffer();
        try {
            URL url = new URL("https://api.coingecko.com/api/v3/coins/list");
            connection = (HttpURLConnection) url.openConnection();

            //Setup do request
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode(); //200 -> Connection sucessfull
            System.out.println("Status da conexão: " + status + "\n");

            //Falha na conexão
            if(status > 299){
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = bufferedReader.readLine()) != null){
                    conteudo.append(line);
                }
                bufferedReader.close();
            }
            //Sucesso conexão
            else{
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = bufferedReader.readLine()) != null){
                    conteudo.append(line);
                }
                bufferedReader.close();

            }
            System.out.println(conteudo.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

    }

}

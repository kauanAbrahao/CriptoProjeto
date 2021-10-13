package com.example.CriptoProjeto.entrypoint;

import com.example.CriptoProjeto.entity.Criptomoeda;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GsonReceiver {

   final String COIN_GECKO = "https://api.coingecko.com/api/v3/coins/list";
    final String COIN_BITCOIN = "https://api.coingecko.com/api/v3/coins/bitcoin";
   final String TEST_POST = "https://jsonplaceholder.typicode.com/posts/1";

   public String getCriptoJson() throws IOException {

       URL url = new URL(COIN_BITCOIN);
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

    public String getListCriptoJson() throws IOException {

        URL url = new URL(COIN_GECKO);
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

   public String postTeste(Criptomoeda criptomoeda) throws IOException {

       //Definindo a conexão
       URL url = new URL(TEST_POST);
       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       connection.setConnectTimeout(20000);
       connection.setReadTimeout(20000);
       connection.setDoOutput(true);
       connection.setUseCaches(true);
       connection.setRequestMethod(RequestMethod.POST.toString());

       //Enviando JSON pelo Body do HTTP
       String json = GsonParser.objectToJson(criptomoeda);
       byte[] bytes = json.getBytes();
       OutputStream outputStream = connection.getOutputStream();
       outputStream.write(bytes);
       outputStream.flush();
       outputStream.close();

       //Lendo o retorno do POST
       InputStream inputStream = connection.getInputStream();
       byte[] response = new byte[2048];
       StringBuffer retorno = new StringBuffer();
       int i = 0;

       //Lendo o retorno em blocos de 2048 bytes
       while((i = inputStream.read(response)) != -1){
            retorno.append(new String(response, 0, i));
       }
       inputStream.close();
       return retorno.toString();
   }

}

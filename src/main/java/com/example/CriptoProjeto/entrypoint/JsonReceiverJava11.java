package com.example.CriptoProjeto.entrypoint;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonReceiverJava11 {

    //Método 2: API HttpClient
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/albums")).build();
        client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
                .thenApply(JsonParser::parseJson)
                .join();
    }
}

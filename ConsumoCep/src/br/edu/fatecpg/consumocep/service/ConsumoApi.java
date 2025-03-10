package br.edu.fatecpg.consumocep.service;

import br.edu.fatecpg.consumocep.model.Endereco;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi  {
    private final HttpClient client;
    private final Gson gson;

    public ConsumoApi(){

    this.client = HttpClient.newHttpClient();
    this.gson = new Gson();

    }


    public Endereco buscarCep(String cep) throws IOException, InterruptedException{
        String url = "https://viacep.com.br/ws/" + cep +"/json/";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), Endereco.class);
    }


}

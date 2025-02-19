package com.jlopez.client;

import com.jlopez.entity.CountriesPopulationDTO;
import com.jlopez.util.Constants;
import com.jlopez.util.JsonToObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CountriesPopulationClient {

    public String getCountriesPopulation(){

        String apiUri= Constants.BASE_API+Constants.POPULATION;
        return executeRequest(apiUri);

    }

    private String executeRequest(String apiUri) {
        HttpRequest httpRequest = null;

        try {
            httpRequest = HttpRequest
                    .newBuilder()
                    .uri(new URI(apiUri))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            return "";
        }

        try(var httpClient = HttpClient.newHttpClient()){
            var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return null;//TODO: here add some code
        } catch (IOException | InterruptedException e) {
            return "";
        }


    }

}

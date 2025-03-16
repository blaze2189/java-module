package com.jlopez.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * El objetivo de esta clase abstracta es declarar
 * mètodos còmunes para los clientes que se implementaràn
 * la idea será crear dentro mètodos que ejecuten GET,POST, PUT, DELETE
 * aunque para este ejercicio solo se utilizaran los GET de la api
 * */
public sealed class AbstractClient implements Client permits CountriesPopulationClient,
        CountriesPopulationCitiesClient, CountriesStatesClient{

    protected String apiUri;

    protected String executeGetRequest(String apiUri) {
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
            return  httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();

        } catch (IOException | InterruptedException e) {
            return "";
        }
    }

}

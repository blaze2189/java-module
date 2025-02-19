package com.jlopez;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class CityClient {

    private static final String CITY_API = "https://api.first.org/data/v1/countries";

    public static void main(String[] args) {

        HttpRequest httpRequest = null;

        try {
            httpRequest = HttpRequest.
                    newBuilder().
                    uri(new URI(CITY_API)).
                    GET().
                    build();
        } catch (URISyntaxException e) {
            System.out.println("Error: "+e.getMessage());
        }

        try (var response = HttpClient.newHttpClient()){
            var resp = response
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();

            var result = gson.fromJson(resp.body(), Map.class);

            result.keySet().forEach(System.out::println);

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}

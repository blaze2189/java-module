package com.jlopez.client;

import com.jlopez.util.Constants;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class CountriesPopulationClient extends AbstractClient {

    {
        super.apiUri=Constants.BASE_API+Constants.POPULATION;
    }

    public String getCountriesPopulation(){

        String apiUri= Constants.BASE_API+Constants.POPULATION;
        return executeGetRequest(apiUri);

    }

}

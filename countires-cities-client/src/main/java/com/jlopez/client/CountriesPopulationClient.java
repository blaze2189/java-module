package com.jlopez.client;

import com.jlopez.entity.ApiResponse;
import com.jlopez.entity.CountriesPopulationDTO;
import com.jlopez.util.Constants;
import com.jlopez.util.JsonToObject;

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

    public ApiResponse<CountriesPopulationDTO> getCountriesPopulation(){

        var responseAsString = executeGetRequest(apiUri);

        return JsonToObject.castApiResponseCountriesPopulationDTOJsonToObject(responseAsString);
    }

}

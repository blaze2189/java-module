package com.jlopez.client;

import com.jlopez.entity.ApiResponse;
import com.jlopez.entity.CountriesPopulationCitiesDTO;
import com.jlopez.util.Constants;
import com.jlopez.util.JsonToObject;

/**
 * En esta clase se podràn agregar los métodos
 * que hagan algún request a
 * Constants.BASE_API+Constants.POPULATION_CITIES
 * */
public final class CountriesPopulationCitiesClient extends AbstractClient {

    {
        super.apiUri=Constants.BASE_API+Constants.POPULATION_CITIES;
    }

    public ApiResponse<CountriesPopulationCitiesDTO> getCountriesPopulationCities(){
        var responseAsString = executeGetRequest(apiUri);

        return JsonToObject.castApiResponseCountriesPopulationCitiesDTOJsonToObject(responseAsString);
    }

}

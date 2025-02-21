package com.jlopez.client;

import com.jlopez.util.Constants;

/**
 * En esta clase se podràn agregar los métodos
 * que hagan algún request a
 * Constants.BASE_API+Constants.POPULATION_CITIES
 * */
public final class CountriesPopulationCitiesClient extends AbstractClient {

    {
        super.apiUri=Constants.BASE_API+Constants.POPULATION_CITIES;
    }

    public String getCountriesPopulationCities(){
        return executeGetRequest(apiUri);
    }

}

package com.jlopez.client;

import com.jlopez.entity.dto.ApiResponse;
import com.jlopez.entity.dto.CountriesPopulationCitiesDTO;
import com.jlopez.util.Constants;
import com.jlopez.util.JsonToObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * En esta clase se podràn agregar los métodos
 * que hagan algún request a
 * Constants.BASE_API+Constants.POPULATION_CITIES
 * */
public final class CountriesPopulationCitiesClient extends AbstractClient {

    private static final Logger logger = LoggerFactory.getLogger(CountriesPopulationCitiesClient.class);

    {
        super.apiUri=Constants.BASE_API+Constants.POPULATION_CITIES;
    }

    public List<CountriesPopulationCitiesDTO> getCountriesPopulationCities(){
        var responseAsString = executeGetRequest(apiUri);
        logger.info("ejecutando request : {}", apiUri);
        return Optional.ofNullable(JsonToObject.castApiResponseCountriesPopulationCitiesDTOJsonToObject(responseAsString))
                .map(ApiResponse::data)
                .orElse(Collections.emptyList());
    }

}

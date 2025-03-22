package com.jlopez.client;

import com.jlopez.entity.dto.ApiResponse;
import com.jlopez.entity.dto.CountriesPopulationDTO;
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
 * Constants.BASE_API+Constants.POPULATION
 * */
public final class CountriesPopulationClient extends AbstractClient {

    private final Logger logger = LoggerFactory.getLogger(CountriesPopulationClient.class);

    {
        super.apiUri=Constants.BASE_API+Constants.POPULATION;
    }

    public List<CountriesPopulationDTO> getCountriesPopulation(){

        var responseAsString = executeGetRequest(apiUri);
        logger.info("ejecutando request : {}", apiUri);
        return Optional.ofNullable(JsonToObject.castApiResponseCountriesPopulationDTOJsonToObject(responseAsString))
                .map(ApiResponse::data).orElse(Collections.emptyList());
    }

}

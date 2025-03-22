package com.jlopez.client;

import com.jlopez.entity.dto.ApiResponse;
import com.jlopez.entity.dto.CountriesStatesDTO;
import com.jlopez.util.Constants;
import com.jlopez.util.JsonToObject;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * En esta clase se podràn agregar los métodos
 * que hagan algún request a
 * Constants.BASE_API+Constants.STATES_PATH
 */
public final class CountriesStatesClient extends AbstractClient {

    private static Logger log = LoggerFactory.getLogger(CountriesStatesClient.class);

    {
        super.apiUri = Constants.BASE_API + Constants.STATES_PATH;
    }

    public List<CountriesStatesDTO> getCountriesStates() {
        var responseAsString = executeGetRequest(apiUri);
        log.info("Request a {}", apiUri);
        return Optional.ofNullable(JsonToObject.castApiResponseCountriesStatesDTOJsonToObject(responseAsString))
                .map(ApiResponse::data).orElse(Collections.emptyList());
    }

}

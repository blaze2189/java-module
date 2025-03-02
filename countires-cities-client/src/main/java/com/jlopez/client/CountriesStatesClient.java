package com.jlopez.client;

import com.jlopez.entity.dto.ApiResponse;
import com.jlopez.entity.dto.CountriesStatesDTO;
import com.jlopez.util.Constants;
import com.jlopez.util.JsonToObject;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * En esta clase se podràn agregar los métodos
 * que hagan algún request a
 * Constants.BASE_API+Constants.STATES_PATH
 * */
public final class CountriesStatesClient extends AbstractClient {

    {
        super.apiUri = Constants.BASE_API+Constants.STATES_PATH;
    }

    public List<CountriesStatesDTO> getCountriesStates() {
        var responseAsString = executeGetRequest(apiUri);

        return Optional.ofNullable(JsonToObject.castApiResponseCountriesStatesDTOJsonToObject(responseAsString))
                .map(ApiResponse::data).orElse(Collections.emptyList());
    }

}

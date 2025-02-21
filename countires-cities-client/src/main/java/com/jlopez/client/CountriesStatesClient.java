package com.jlopez.client;

import com.jlopez.entity.ApiResponse;
import com.jlopez.entity.CountriesStatesDTO;
import com.jlopez.util.Constants;
import com.jlopez.util.JsonToObject;

public final class CountriesStatesClient extends AbstractClient {

    {
        super.apiUri = Constants.BASE_API+Constants.STATES_PATH;
    }

    public ApiResponse<CountriesStatesDTO> getCountriesStates() {
        var responseAsString = executeGetRequest(apiUri);

        return JsonToObject.castApiResponseCountriesStatesDTOJsonToObject(responseAsString);
    }

}

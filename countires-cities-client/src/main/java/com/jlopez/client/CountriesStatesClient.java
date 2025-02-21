package com.jlopez.client;

import com.jlopez.util.Constants;

public final class CountriesStatesClient extends AbstractClient {

    {
        super.apiUri = Constants.BASE_API;
    }

    public String getCountiesStates() {

        return executeGetRequest(apiUri);
    }

}

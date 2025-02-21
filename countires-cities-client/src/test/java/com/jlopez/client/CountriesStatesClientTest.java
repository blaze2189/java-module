package com.jlopez.client;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CountriesStatesClientTest {

    private final CountriesStatesClient countriesStatesClient = new CountriesStatesClient();

    @Test
    public void testGetCountriesStates(){

        var response = countriesStatesClient.getCountriesStates();
        System.out.println(response.data().size());
        assertNotNull(response);

    }

}
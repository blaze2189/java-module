package com.jlopez.client;


import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class CountriesPopulationClientTest {

    private final CountriesPopulationClient countriesPopulationClient = new CountriesPopulationClient();

    @Test
    public void testApi() {

        var response = countriesPopulationClient.getCountriesPopulation();
        System.out.println(response);
        assertNotEquals("", response);

    }

}
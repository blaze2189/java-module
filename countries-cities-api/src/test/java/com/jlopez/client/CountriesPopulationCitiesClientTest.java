package com.jlopez.client;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CountriesPopulationCitiesClientTest {

    private final CountriesPopulationCitiesClient countriesPopulationCitiesClient = new CountriesPopulationCitiesClient();

    @Test
    public void testGetCountriesPopulationCitiesClient(){
        var countriesPopulationCitiesDTO = countriesPopulationCitiesClient.getCountriesPopulationCities();
        System.out.println(countriesPopulationCitiesDTO.size());
        assertNotNull(countriesPopulationCitiesDTO);

    }

}
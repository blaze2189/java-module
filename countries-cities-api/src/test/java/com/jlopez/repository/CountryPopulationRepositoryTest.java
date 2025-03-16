package com.jlopez.repository;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountryPopulationRepositoryTest {

    private final CountryPopulationRepository countryPopulationRepository = new CountryPopulationRepository();

    @Test
    public void testCacheFill() {

        System.out.println("first call");
        var firstCall = countryPopulationRepository.getCountriesPopulationCities();
        System.out.println("Second call");
        var secondCall = countryPopulationRepository.getCountriesPopulationCities();
        assertEquals(firstCall,secondCall);

    }

}
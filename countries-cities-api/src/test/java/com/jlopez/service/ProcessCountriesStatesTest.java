package com.jlopez.service;

import com.jlopez.entity.dto.ApiResponse;
import com.jlopez.entity.dto.CountriesStatesDTO;
import com.jlopez.util.JsonToObject;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ProcessCountriesStatesTest {

    private final ProcessCountriesStates processCountriesStates = new ProcessCountriesStatesImpl();
    private final List<CountriesStatesDTO> countriesStatesDTOList = readData();

    @Test
    public void testCountStates() {

        var countedStates = processCountriesStates.listStatesForAllCountries(countriesStatesDTOList);
        countedStates.forEach(System.out::println);
        assertEquals(countriesStatesDTOList.size(), countedStates.size());
    }

    @Test
    public void testCountStatesNullList() {

        var countedStates = processCountriesStates.listStatesForAllCountries(null);
        countedStates.forEach(System.out::println);
        assertEquals(countriesStatesDTOList.size(), countedStates.size());
    }

    @Test
    public void testListCountries() {

        var listResult = processCountriesStates.listAllCountries(countriesStatesDTOList);
        listResult.forEach(System.out::println);
    }

    @Test
    public void testStatesByCountry() {

        var country = "Mexico";
        var result = processCountriesStates.listStatesForCountry(countriesStatesDTOList, country);
        System.out.println(result);
    }

    @Test
    public void testStatesByCountryWithNullSearch() {

        String country = null;
        var result = processCountriesStates.listStatesForCountry(countriesStatesDTOList, country);
        System.out.println(result);
    }

    @Test
    public void testStatesByCountryFail() {

        var country = "Mèxico";
        var result = processCountriesStates.listStatesForCountry(countriesStatesDTOList, country);
        System.out.println(result);
    }

    @Test
    public void testOrderCountriesByTotalStates() {

        var countriesStates = readData();
    }

    private List<CountriesStatesDTO> readData() {
        var path = Paths.get("./src/test/resources/countries.states.json");
        try {
            var allLines = Files.readAllLines(path);
            var result = allLines.stream().reduce((a, b) -> a + b).orElse("empty");
            var listCountriesSatatesDTO = JsonToObject.castApiResponseCountriesStatesDTOJsonToObject(result);
            return Optional.ofNullable(listCountriesSatatesDTO).map(ApiResponse::data).orElse(Collections.emptyList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
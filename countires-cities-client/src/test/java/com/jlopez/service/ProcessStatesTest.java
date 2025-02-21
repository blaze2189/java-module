package com.jlopez.service;

import com.jlopez.entity.ApiResponse;
import com.jlopez.entity.CountriesStatesDTO;
import com.jlopez.util.JsonToObject;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ProcessStatesTest {

    private final ProcessStates processStates = new ProcessStatesImpl();

    @Test
    public void testCountStates(){

        var countriesStatesDTOList = readData();
        var countedStates = processStates.countStatesAllCities(countriesStatesDTOList);
        countedStates.forEach(System.out::println);
        assertEquals(countriesStatesDTOList.size(),countedStates.size());

    }

    private List<CountriesStatesDTO> readData() {
        var path = Paths.get("./src/test/resources/countries.states.json");
        try {
            var allLines = Files.readAllLines(path);
            var result = allLines.stream().reduce((a,b)->a+b).orElse("empty");
            var listCountriesSatatesDTO = JsonToObject.castApiResponseCountriesStatesDTOJsonToObject(result);
            return Optional.ofNullable(listCountriesSatatesDTO).map(ApiResponse::data).orElse(Collections.emptyList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
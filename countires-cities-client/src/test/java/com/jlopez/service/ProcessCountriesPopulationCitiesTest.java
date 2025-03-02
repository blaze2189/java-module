package com.jlopez.service;

import com.jlopez.entity.dto.ApiResponse;
import com.jlopez.entity.dto.CountriesPopulationCitiesDTO;
import com.jlopez.util.JsonToObject;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProcessCountriesPopulationCitiesTest {

    private final ProcessCountriesPopulationCities processCountriesPopulationCities = new ProcessCountriesPopulationCitiesImpl();
    private final List<CountriesPopulationCitiesDTO> countriesPopulationCitiesDTOList = readData();

    @Test
    public void processAllCountriesPopulationCities(){

        var result = processCountriesPopulationCities.processAllCountriesPopulationCities(readData());
        //result.forEach(res -> System.out.println(res.country()+" : "+res.cityPopulationList().size()));

        var p = result.stream()
                .filter(res -> res.country().equals("Mexico"))
                .findFirst().orElse(null);
        p.cityPopulationList()
                .forEach(q -> System.out.println(q.city()));
    }

    private List<CountriesPopulationCitiesDTO> readData() {
        var path = Paths.get("./src/test/resources/countries.population.cities.json");
        try {
            var allLines = Files.readAllLines(path);
            var result = allLines.stream().reduce((a, b) -> a + b).orElse("empty");
            var listCountriesPopulation = JsonToObject.castApiResponseCountriesPopulationCitiesDTOJsonToObject(result);
            return Optional.ofNullable(listCountriesPopulation).map(ApiResponse::data).orElse(Collections.emptyList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

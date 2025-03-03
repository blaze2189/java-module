package com.jlopez.service;

import com.jlopez.entity.CityPopulation;
import com.jlopez.entity.YearPopulation;
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
    public void testProcessAllCountriesPopulationCities(){

        var result = processCountriesPopulationCities.processAllCountriesPopulationCities(countriesPopulationCitiesDTOList);
        var p = result.stream()
                .filter(res -> res.country().equals("Mexico"))
                .findFirst().orElse(null);
        p.cityPopulationList()
                .forEach(q -> System.out.println(q.city()));
    }

    @Test
    public void testProcessCountriesPopulationCitiesFilter(){

        String country = "Mexico";
        var result = processCountriesPopulationCities.processCountriesPopuationCitiesFilterByCountry( countriesPopulationCitiesDTOList ,country);
        System.out.println(result.country());
        for(CityPopulation cityPopulation :result.cityPopulationList()){
            System.out.println("----------------");
            System.out.println("city: "+cityPopulation.city());
            for(YearPopulation yearPopulation:cityPopulation.yearPopulationList()){
                System.out.println("year: "+yearPopulation.year() +" - population: "+yearPopulation.population());
            }
        }
    }

    @Test
    public void testProcessCountriesPopulationCitiesFilterWithInvalidCountry(){

        String country = "México";
        var result = processCountriesPopulationCities.processCountriesPopuationCitiesFilterByCountry( countriesPopulationCitiesDTOList ,country);
        System.out.println(result.country());
        for(CityPopulation cityPopulation :result.cityPopulationList()){
            System.out.println("----------------");
            System.out.println("city: "+cityPopulation.city());
            for(YearPopulation yearPopulation:cityPopulation.yearPopulationList()){
                System.out.println("year: "+yearPopulation.year() +" - population: "+yearPopulation.population());
            }
        }
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

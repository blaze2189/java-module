package com.jlopez.service;

import com.jlopez.entity.CityPopulation;
import com.jlopez.entity.CountriesPopulationCities;
import com.jlopez.entity.YearPopulation;
import com.jlopez.entity.dto.CountriesPopulationCitiesDTO;
import com.jlopez.entity.dto.PopulationCountDTO;

import java.util.*;

/**
 * Servicio para procesar la informaciòn recibida sobre la poblacion
 * por ciudades de paises
 * Regla la lista que recibe cada mètodo no puede ser nula
 */
public final class ProcessCountriesPopulationCitiesImpl implements ProcessCountriesPopulationCities {

    @Override
    public List<CountriesPopulationCities> processAllCountriesPopulationCities(List<CountriesPopulationCitiesDTO> countriesPopulationCitiesDTOList) {

        Map<String, CountriesPopulationCities> mapCountriesPopulationCities = new HashMap<>();

        countriesPopulationCitiesDTOList
                .forEach( countryPopulationCity -> processCountryPopulationCity(mapCountriesPopulationCities,countryPopulationCity));

        return mapCountriesPopulationCities
                .keySet()
                .stream()
                .map(mapCountriesPopulationCities::get)
                .toList();
    }

    private void processCountryPopulationCity(Map<String, CountriesPopulationCities> mapCountriesPopulationCities, CountriesPopulationCitiesDTO countriesPopulationCitiesDTO) {

        var countryExist = mapCountriesPopulationCities.keySet().parallelStream().anyMatch(s -> s.equals(countriesPopulationCitiesDTO.country()));
        if(countryExist){
            var countryInfo = mapCountriesPopulationCities.get(countriesPopulationCitiesDTO.country());
            var cityPopulationList = Optional.ofNullable(countryInfo.cityPopulationList())
                    .orElse(new ArrayList<>());
            var yearPopulationList=countriesPopulationCitiesDTO
                    .populationCounts().parallelStream()
                    .map(this::mapToYearPopulation)
                    .toList();
            CityPopulation cityPopulation = new CityPopulation(countriesPopulationCitiesDTO.city(), yearPopulationList);
            cityPopulationList.add(cityPopulation);
            //countryInfo.cityPopulationList().add(cityPopulation);
        }else{

            var yearPopulationList=countriesPopulationCitiesDTO
                    .populationCounts().parallelStream()
                    .map(this::mapToYearPopulation)
                    .toList();
            CityPopulation cityPopulation = new CityPopulation(countriesPopulationCitiesDTO.city(), yearPopulationList);
            List<CityPopulation> cityPopulationList = new ArrayList();
            cityPopulationList.add(cityPopulation);
            CountriesPopulationCities countriesPopulationCities = new CountriesPopulationCities(countriesPopulationCitiesDTO.country(), cityPopulationList);
            mapCountriesPopulationCities.put(countriesPopulationCitiesDTO.country(), countriesPopulationCities);
        }

    }

    private YearPopulation mapToYearPopulation(PopulationCountDTO populationCountDTO) {
        String year=populationCountDTO.year();
        String population = populationCountDTO.value();

        return new YearPopulation(year,population);
    }

}

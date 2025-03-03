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

    /**
     * Lectura de la respuesta de los ciudades con su poblcaciòn y estado
     * Agrupación de las ciudades por paìs
     */
    @Override
    public List<CountriesPopulationCities> processAllCountriesPopulationCities(List<CountriesPopulationCitiesDTO> countriesPopulationCitiesDTOList) {

        Map<String, CountriesPopulationCities> mapCountriesPopulationCities = new HashMap<>();

        //Agrupando ciudades por paìs
        countriesPopulationCitiesDTOList
                .forEach(countryPopulationCity -> processCountryPopulationCity(mapCountriesPopulationCities, countryPopulationCity));

        return mapCountriesPopulationCities
                .keySet()
                .parallelStream()
                .map(mapCountriesPopulationCities::get)
                .toList();
    }

    @Override
    public CountriesPopulationCities processCountriesPopuationCitiesFilterByCountry(List<CountriesPopulationCitiesDTO> countriesPopulationCitiesList, String country) {

        var citiesPopulationForCountry = countriesPopulationCitiesList.stream()
                .filter(countriesPopulationCities -> countriesPopulationCities.country().equals(country))
                .toList();

        var cityPopulationList = citiesPopulationForCountry.stream()
                .map(this::mapCountriesPopulationCitiesDTOToCountriesPopulation)
                .toList();

        return new CountriesPopulationCities(country, cityPopulationList);
    }

    private CityPopulation mapCountriesPopulationCitiesDTOToCountriesPopulation(CountriesPopulationCitiesDTO countriesPopulationCitiesDTO) {
        var yearPopulationList = countriesPopulationCitiesDTO
                .populationCounts().stream()
                .map(this::mapPopulationCountDTOToYearPopulation).toList();
        return new CityPopulation(countriesPopulationCitiesDTO.city(), yearPopulationList);
    }

    /**
     * Agrupoaciòn de ciudades por paìs
     * */
    private void processCountryPopulationCity(Map<String, CountriesPopulationCities> mapCountriesPopulationCities, CountriesPopulationCitiesDTO countriesPopulationCitiesDTO) {

        var countryExist = mapCountriesPopulationCities
                .keySet()
                .stream()
                .anyMatch(s -> s.equals(countriesPopulationCitiesDTO.country()));

        List<CityPopulation> cityPopulationList = null;

        if (countryExist) {
            var countryInfo = mapCountriesPopulationCities.get(countriesPopulationCitiesDTO.country());
            cityPopulationList = Optional.ofNullable(countryInfo.cityPopulationList())
                    .orElse(new ArrayList<>());

            var yearPopulationList = countriesPopulationCitiesDTO
                    .populationCounts().stream()
                    .map(this::mapPopulationCountDTOToYearPopulation)
                    .toList();

            CityPopulation cityPopulation = new CityPopulation(countriesPopulationCitiesDTO.city(), yearPopulationList);
            cityPopulationList.add(cityPopulation);
        } else {

            var yearPopulationList = countriesPopulationCitiesDTO
                    .populationCounts().stream()
                    .map(this::mapPopulationCountDTOToYearPopulation)
                    .toList();

            cityPopulationList = new ArrayList<>();

            CityPopulation cityPopulation = new CityPopulation(countriesPopulationCitiesDTO.city(), yearPopulationList);
            cityPopulationList.add(cityPopulation);

            CountriesPopulationCities countriesPopulationCities = new CountriesPopulationCities(countriesPopulationCitiesDTO.country(), cityPopulationList);
            mapCountriesPopulationCities.put(countriesPopulationCitiesDTO.country(), countriesPopulationCities);
        }

    }

    private YearPopulation mapPopulationCountDTOToYearPopulation(PopulationCountDTO populationCountDTO) {
        String year = populationCountDTO.year();
        String population = populationCountDTO.value();

        return new YearPopulation(year, population);
    }

}

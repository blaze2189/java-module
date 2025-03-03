package com.jlopez.service;

import com.jlopez.entity.CountriesPopulationCities;
import com.jlopez.entity.dto.CountriesPopulationCitiesDTO;

import java.util.List;

public sealed interface ProcessCountriesPopulationCities permits ProcessCountriesPopulationCitiesImpl{

    List<CountriesPopulationCities> processAllCountriesPopulationCities(List<CountriesPopulationCitiesDTO> countriesPopulationCitiesDTOList);

    CountriesPopulationCities processCountriesPopuationCitiesFilterByCountry(List<CountriesPopulationCitiesDTO> countriesPopulationCitiesList, String country);
}

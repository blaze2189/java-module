package com.jlopez.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CountriesPopulationCitiesDTO(String city,
                                           String country,
                                           List<PopulationCountDTO> populationCounts){
}

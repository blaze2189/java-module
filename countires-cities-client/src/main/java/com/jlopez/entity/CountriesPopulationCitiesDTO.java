package com.jlopez.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CountriesPopulationCitiesDTO(String city,
                                           String country,
                                           List<PopulationCountDTO> populationCounts){
}

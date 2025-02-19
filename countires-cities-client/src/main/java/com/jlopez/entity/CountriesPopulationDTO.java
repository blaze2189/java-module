package com.jlopez.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties
public record CountriesPopulationDTO (String country,
                                      String code,
                                      String iso3,
                                      @JsonProperty("populationCounts") List<PopulationCountDTO> populationCountDTOList) {
}

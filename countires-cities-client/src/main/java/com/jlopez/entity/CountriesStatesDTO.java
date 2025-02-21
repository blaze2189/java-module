package com.jlopez.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CountriesStatesDTO (String name,
                                  String iso2,
                                  String iso3,
                                  List<StateDTO> states) {
}

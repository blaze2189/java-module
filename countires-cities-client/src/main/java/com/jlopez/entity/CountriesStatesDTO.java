package com.jlopez.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public record CountriesStatesDTO (String name,
                                  String iso3,
                                  List<StateDTO> states) {
}

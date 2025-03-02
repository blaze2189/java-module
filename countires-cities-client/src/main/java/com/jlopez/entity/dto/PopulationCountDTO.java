package com.jlopez.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PopulationCountDTO(String year,
                                 String value) {
}

package com.jlopez.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties
public record PopulationCountDTO(Integer year,
                                 BigDecimal value) {
}

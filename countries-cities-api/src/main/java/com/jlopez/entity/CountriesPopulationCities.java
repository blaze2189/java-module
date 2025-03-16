package com.jlopez.entity;

import java.util.List;

public record CountriesPopulationCities (String country,
                                         List<CityPopulation> cityPopulationList ) {
}

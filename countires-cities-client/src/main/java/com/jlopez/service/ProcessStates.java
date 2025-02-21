package com.jlopez.service;

import com.jlopez.entity.CountriesStatesDTO;

import java.util.List;

public sealed interface ProcessStates permits ProcessStatesImpl{

    List<String> countStatesAllCities(List<CountriesStatesDTO> countriesStatesDTO);
}

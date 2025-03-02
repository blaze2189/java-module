package com.jlopez.service;

import com.jlopez.entity.dto.CountriesStatesDTO;
import com.jlopez.util.Order;

import java.util.List;

public sealed interface ProcessCountriesStates permits ProcessCountriesStatesImpl {

    List<String> listAllCountries(List<CountriesStatesDTO> countriesStatesDTOList);

    List<String> listStatesForAllCountries(List<CountriesStatesDTO> countriesStatesDTOList);

    CountriesStatesDTO listStatesForCountry(List<CountriesStatesDTO> listCountriesStatesDTO, String cityName);

    List<CountriesStatesDTO> orderCountriesByTotalStates(List<CountriesStatesDTO> countriesStatesDTOList, Integer topCountries, Order order);
}

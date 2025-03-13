package com.jlopez.service;

import com.jlopez.entity.dto.CountriesStatesDTO;
import com.jlopez.util.Order;

import java.util.*;

/**
 * Servicio para manejar la infomaciòn
 * de Estados por Ciudad
 * Regla de negocio el la lista que se recibe no puede ser nula
 */
public final class ProcessCountriesStatesImpl implements ProcessCountriesStates {

    @Override
    public List<String> listAllCountries(List<CountriesStatesDTO> countriesStatesDTOList) {
        return countriesStatesDTOList
                .stream()
                .map(CountriesStatesDTO::name)
                .toList();

    }

    @Override
    public List<String> listStatesForAllCountries(List<CountriesStatesDTO> listCountriesStatesDTO) {

        return listCountriesStatesDTO
                .parallelStream()
                .map(countriesStatesDTO -> "El total de estados en " + countriesStatesDTO.name() + " es de " + countriesStatesDTO.states().size())
                .toList();
    }

    @Override
    public CountriesStatesDTO listStatesForCountry(List<CountriesStatesDTO> listCountriesStatesDTO, String cityName) {

        return listCountriesStatesDTO
                .stream()
                .filter(countyStateDTO -> countyStateDTO.name().equals(cityName))
                .toList()
                .stream()
                .findFirst().orElse(null);
    }

    @Override
    public List<CountriesStatesDTO> orderCountriesByTotalStates(List<CountriesStatesDTO> countriesStatesDTOList, Integer topCountries, Order order) {

        return countriesStatesDTOList.stream()
                .sorted(Comparator.comparingInt(countryState -> countryState.states().size()))
                .limit(topCountries).toList();


    }

}

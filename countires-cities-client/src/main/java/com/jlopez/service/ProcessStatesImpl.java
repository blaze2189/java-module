package com.jlopez.service;

import com.jlopez.entity.CountriesStatesDTO;

import java.util.List;

public final class ProcessStatesImpl implements ProcessStates {

    @Override
    public List<String> countStatesAllCities(List<CountriesStatesDTO> listCountriesStatesDTO) {
        return listCountriesStatesDTO.stream()
                .map(countriesStatesDTO -> "El total de estados en "+countriesStatesDTO.name()+" es de "+countriesStatesDTO.states().size())
                .toList();
    }
}

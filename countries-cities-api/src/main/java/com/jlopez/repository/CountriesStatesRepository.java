package com.jlopez.repository;

import com.jlopez.client.CountriesStatesClient;
import com.jlopez.entity.dto.CountriesStatesDTO;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountriesStatesRepository {

    private Logger logger = LoggerFactory.getLogger(CountryPopulationRepository.class);

    private List<CountriesStatesDTO> countriesStatesDTOCache;
    private static final CountriesStatesClient countriesStatesClient = new CountriesStatesClient();

    public List<CountriesStatesDTO> getCountriesStates() {
        var cacheIsEmpty = Optional.ofNullable(countriesStatesDTOCache).isEmpty();

        if (cacheIsEmpty) {
            logger.info("Cache Ciudades-Estados esta vacía");
            logger.info("Ejecutando request");
            countriesStatesDTOCache = countriesStatesClient.getCountriesStates();
        }

        return countriesStatesDTOCache;
    }
}

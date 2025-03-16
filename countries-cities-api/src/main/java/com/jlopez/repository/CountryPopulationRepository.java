package com.jlopez.repository;

import com.jlopez.client.CountriesPopulationCitiesClient;
import com.jlopez.entity.dto.CountriesPopulationCitiesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CountryPopulationRepository {

    private final static Logger logger = LoggerFactory.getLogger(CountryPopulationRepository.class);

    private List<CountriesPopulationCitiesDTO> countriesPopulationCitiesDTOCache;
    private static final CountriesPopulationCitiesClient countriesPopulationCitiesClient = new CountriesPopulationCitiesClient();

    public List<CountriesPopulationCitiesDTO> getCountriesPopulationCities() {

        var cacheIsEmpty = Optional.ofNullable(countriesPopulationCitiesDTOCache).isEmpty();

        if(cacheIsEmpty){
            logger.info("Cache Población por ciudades esta vacía");
            logger.info("Ejecutando request");
            countriesPopulationCitiesDTOCache = countriesPopulationCitiesClient.getCountriesPopulationCities();
        }

        return countriesPopulationCitiesDTOCache;
    }


}

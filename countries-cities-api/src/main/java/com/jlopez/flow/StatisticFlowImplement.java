package com.jlopez.flow;

import com.jlopez.entity.CityPopulation;
import com.jlopez.entity.dto.CountriesPopulationCitiesDTO;
import com.jlopez.entity.dto.CountriesStatesDTO;
import com.jlopez.entity.dto.StateDTO;
import com.jlopez.repository.CountriesStatesRepository;
import com.jlopez.repository.CountryPopulationRepository;
import com.jlopez.service.ProcessCountriesPopulationCities;
import com.jlopez.service.ProcessCountriesPopulationCitiesImpl;
import com.jlopez.service.ProcessCountriesStates;
import com.jlopez.service.ProcessCountriesStatesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public final class StatisticFlowImplement implements StatisticFlow {

    private final Logger logger = LoggerFactory.getLogger(StatisticFlowImplement.class);

    private final CountryPopulationRepository countryPopulationRepository = new CountryPopulationRepository();
    private final CountriesStatesRepository countriesStatesRepository = new CountriesStatesRepository();

    private final ProcessCountriesPopulationCities processCountriesPopulationCities = new ProcessCountriesPopulationCitiesImpl();
    private final ProcessCountriesStates processCountriesStates = new ProcessCountriesStatesImpl();

    @Override
    public void getAllCountries(){
        List<CountriesStatesDTO> countriesStatesDTOList = countriesStatesRepository.getCountriesStates();
        var listAllCountries = processCountriesStates.listAllCountries(countriesStatesDTOList);
        listAllCountries.forEach(System.out::println);

    }

    @Override
    public void getStatisticsForAllCountries() {
        List<CountriesStatesDTO> countriesStatesDTOList = countriesStatesRepository.getCountriesStates();
        var countriesStatesList = processCountriesStates.listAllCountries(countriesStatesDTOList);
        countriesStatesList.forEach(this::getStatisticsForCountry);
    }

    @Override
    public void getStatisticsForCountry(String country) {

        List<CountriesPopulationCitiesDTO> countriesPopulationCitiesDTOList = countryPopulationRepository.getCountriesPopulationCities();
        List<CountriesStatesDTO> countriesStatesDTOList = countriesStatesRepository.getCountriesStates();

        var countryState = processCountriesStates.listStatesForCountry(countriesStatesDTOList, country);
        var countriesPopulationCities = processCountriesPopulationCities.processCountriesPopulationCitiesFilterByCountry(countriesPopulationCitiesDTOList, country);

        var validCountry=processCountriesStates.listAllCountries(countriesStatesDTOList)
                .parallelStream()
                .filter(streamCountry -> streamCountry.equals(country)).findAny();

        if(validCountry.isEmpty()){

            logger.info("No se tienen registros para el país: {}", country);

            return;
        }

        logger.info("Estadísticas de {}", country);
        logger.info("Total de estados {}", countryState.states().size());

        var stringStatesList = countryState.states()
                .parallelStream()
                .map(StateDTO::name)
                .reduce(" ", (a, b) -> a + "\n" + b);

        logger.info("Los estados en este país son:{}", stringStatesList);

        logger.info("Datos poblacionales de {} por ciudad", country);
        logger.info("Total de ciudades {}", countriesPopulationCities.cityPopulationList().size());
        var cityInfo = countriesPopulationCities.cityPopulationList()
                .parallelStream()
                .map(cityPopulation -> cityPopulation.city() + ": " + printInfoForCountriesPopulationCityDTO(cityPopulation));
        cityInfo.forEach(System.out::println);
    }

    private String printInfoForCountriesPopulationCityDTO(CityPopulation cityPopulation) {
        return cityPopulation
                .yearPopulationList()
                .parallelStream()
                .map(cp -> "\tEn " + cp.year() + " la población fue de " + cp.population() + " habitantes.")
                .toList()
                .parallelStream()
                .reduce(" ", (a, b) -> a + "\n" + b);
    }
}

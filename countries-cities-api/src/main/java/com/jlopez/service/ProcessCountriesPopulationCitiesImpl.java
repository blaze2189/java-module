package com.jlopez.service;

import com.jlopez.entity.CityPopulation;
import com.jlopez.entity.CountriesPopulationCities;
import com.jlopez.entity.YearPopulation;
import com.jlopez.entity.dto.CountriesPopulationCitiesDTO;
import com.jlopez.entity.dto.PopulationCountDTO;

import java.util.*;

/**
 * Servicio para procesar la informaciòn recibida sobre la poblacion
 * por ciudades de paises
 * Regla la lista que recibe cada mètodo no puede ser nula
 */
public final class ProcessCountriesPopulationCitiesImpl implements ProcessCountriesPopulationCities {

    /**
     * Lectura de la respuesta de los ciudades con su poblcaciòn y estado
     * Agrupación de las ciudades por paìs
     */
    @Override
    public List<CountriesPopulationCities> processAllCountriesPopulationCities(List<CountriesPopulationCitiesDTO> countriesPopulationCitiesDTOList) {

        Map<String, CountriesPopulationCities> mapCountriesPopulationCities = new HashMap<>();

        //Agrupando ciudades por paìs
        countriesPopulationCitiesDTOList
                .forEach(countryPopulationCity -> processCountryPopulationCity(mapCountriesPopulationCities, countryPopulationCity));

        return mapCountriesPopulationCities
                .keySet()
                .parallelStream()
                .map(mapCountriesPopulationCities::get)
                .toList();
    }

    @Override
    public CountriesPopulationCities processCountriesPopulationCitiesFilterByCountry(List<CountriesPopulationCitiesDTO> countriesPopulationCitiesList, String country) {

        var citiesPopulationForCountry = countriesPopulationCitiesList.parallelStream()
                .filter(countriesPopulationCities -> countriesPopulationCities.country().equals(country))
                .toList();

        var cityPopulationList = citiesPopulationForCountry.parallelStream()
                .map(this::mapCountriesPopulationCitiesDTOToCountriesPopulation)
                .toList();

        return new CountriesPopulationCities(country, cityPopulationList);
    }

    private CityPopulation mapCountriesPopulationCitiesDTOToCountriesPopulation(CountriesPopulationCitiesDTO countriesPopulationCitiesDTO) {
        var yearPopulationList = countriesPopulationCitiesDTO
                .populationCounts().parallelStream()
                .map(this::mapPopulationCountDTOToYearPopulation).toList();

        return new CityPopulation(countriesPopulationCitiesDTO.city(), yearPopulationList);
    }

    /**
     * Agrupaciòn de ciudades por paìs
     * */
    private void processCountryPopulationCity(Map<String, CountriesPopulationCities> mapCountriesPopulationCities, CountriesPopulationCitiesDTO countriesPopulationCitiesDTO) {

        //Validaciòn si ya ha sido agregado el paìs al mapa
        var countryExist = mapCountriesPopulationCities
                .keySet()
                .parallelStream()
                .anyMatch(s -> s.equals(countriesPopulationCitiesDTO.country()));

        //Si el paìs ya existe se toma la informaciòn del paìs en caso contrario se crearà un nuevo registro
        var cityPopulationList = Optional.ofNullable(mapCountriesPopulationCities.get(countriesPopulationCitiesDTO.country()))
                .map(CountriesPopulationCities::cityPopulationList)
                .orElse(new ArrayList<>());

        //obtenciòn de la poblaciòn por año en cada ciudad
        var yearPopulationList = countriesPopulationCitiesDTO
                .populationCounts().parallelStream()
                .map(this::mapPopulationCountDTOToYearPopulation)
                .toList();

        //creaciòn de registro para agregar en la entidad a la estadística de la poblaciòn
        CityPopulation cityPopulation = new CityPopulation(countriesPopulationCitiesDTO.city(), yearPopulationList);
        cityPopulationList.add(cityPopulation);

        //si el país no ha sido agregado al mapa se agega
        if (!countryExist) {
            CountriesPopulationCities countriesPopulationCities = new CountriesPopulationCities(countriesPopulationCitiesDTO.country(), cityPopulationList);
            mapCountriesPopulationCities.put(countriesPopulationCitiesDTO.country(), countriesPopulationCities);
        }
    }

    private YearPopulation mapPopulationCountDTOToYearPopulation(PopulationCountDTO populationCountDTO) {
        String year = populationCountDTO.year();
        String population = populationCountDTO.value();

        return new YearPopulation(year, population);
    }

}

package com.jlopez.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlopez.entity.ApiResponse;
import com.jlopez.entity.CountriesStatesDTO;
import com.jlopez.entity.PopulationCountDTO;

import static org.jboss.security.PicketBoxLogger.LOGGER;
/**
 * Clase utilitaria para hacer cast de la respuesta json
 * de la api
 */
public class JsonToObject <T>{

    public T castJsonToObject(String jsonObject){

        var objectMapper = new ObjectMapper();
        try {
            return objectMapper.
                   readValue(jsonObject, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            LOGGER.error("Invalid JSON object cast");

            return null;
        }

    }

    public static PopulationCountDTO castPopulationCountDTOJsonToObject(String jsonObject){

        var objectMapper = new ObjectMapper();
        try {
            return objectMapper.
                    readValue(jsonObject, new TypeReference<PopulationCountDTO>() {});
        } catch (JsonProcessingException e) {
            LOGGER.error("Invalid JSON object cast");

            return null;
        }

    }

    public static ApiResponse<CountriesStatesDTO> castApiResponseCountriesStatesDTOJsonToObject(String jsonObject){

        var objectMapper = new ObjectMapper();
        try {
            return objectMapper.
                    readValue(jsonObject, new TypeReference<ApiResponse<CountriesStatesDTO>>() {});
        } catch (JsonProcessingException e) {
            LOGGER.error("Invalid JSON object cast");
            e.printStackTrace();
            return null;
        }

    }

}

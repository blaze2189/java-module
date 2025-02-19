package com.jlopez.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
                   readValue(jsonObject, new TypeReference<T>() {});
        } catch (JsonProcessingException e) {
            LOGGER.error("Invalid JSON object cast");

            return null;
        }

    }

}

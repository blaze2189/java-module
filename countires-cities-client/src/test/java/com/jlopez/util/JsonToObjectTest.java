package com.jlopez.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlopez.entity.ApiResponse;
import com.jlopez.entity.CountriesPopulationCitiesDTO;
import com.jlopez.entity.CountriesStatesDTO;
import com.jlopez.entity.PopulationCountDTO;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;

public class JsonToObjectTest {

    @Test
    public void testPopulataionCountDTO(){
        String populationString = "{\"year\":2004,\"value\":12345}";
        JsonToObject<PopulationCountDTO> populationCountDTOJsonToObject = new JsonToObject<>();

        var objectMapper = new ObjectMapper();
        try {
            var mapped = objectMapper.readValue(populationString, new TypeReference<PopulationCountDTO>() {});
            System.out.println(mapped.year());

            mapped = JsonToObject.castPopulationCountDTOJsonToObject(populationString);
            System.out.println(mapped.value());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        //objectMapper.readValue(jsonObject, new TypeReference<T>() {});
        var object = populationCountDTOJsonToObject.castJsonToObject(populationString);
        assertNotNull(object);
    }

    @Test
    public void testCountryPopulationCast(){

        JsonToObject<CountriesPopulationCitiesDTO> jsonToObject = new JsonToObject<>();
       String object="{\n" +
                "      \"city\": \"Durrës\",\n" +
                "      \"country\": \"Albania\",\n" +
                "      \"populationCounts\": [\n" +
                "        {\n" +
                "          \"year\": \"2011\",\n" +
                "          \"value\": \"113249\",\n" +
                "          \"sex\": \"Both Sexes\",\n" +
                "          \"reliabilty\": \"Final figure, complete\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }";
        System.out.println("object to cast "+object);
        var countriesPopulationCitiesDTO = jsonToObject.castJsonToObject(object);
        assertNotNull(countriesPopulationCitiesDTO);

    }

    @Test
    public void testCountryStatesCast(){

        JsonToObject<CountriesStatesDTO> jsonToObject = new JsonToObject<>();
       String object=" {\n" +
               "      \"name\": \"Afghanistan\",\n" +
               "      \"iso3\": \"AFG\",\n" +
               "      \"states\": [\n" +
               "        {\n" +
               "          \"name\": \"Badakhshan\",\n" +
               "          \"state_code\": \"BDS\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Badghis\",\n" +
               "          \"state_code\": \"BDG\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Baghlan\",\n" +
               "          \"state_code\": \"BGL\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Balkh\",\n" +
               "          \"state_code\": \"BAL\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Bamyan\",\n" +
               "          \"state_code\": \"BAM\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Daykundi\",\n" +
               "          \"state_code\": \"DAY\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Farah\",\n" +
               "          \"state_code\": \"FRA\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Faryab\",\n" +
               "          \"state_code\": \"FYB\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Ghazni\",\n" +
               "          \"state_code\": \"GHA\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Ghōr\",\n" +
               "          \"state_code\": \"GHO\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Helmand\",\n" +
               "          \"state_code\": \"HEL\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Herat\",\n" +
               "          \"state_code\": \"HER\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Jowzjan\",\n" +
               "          \"state_code\": \"JOW\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Kabul\",\n" +
               "          \"state_code\": \"KAB\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Kandahar\",\n" +
               "          \"state_code\": \"KAN\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Kapisa\",\n" +
               "          \"state_code\": \"KAP\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Khost\",\n" +
               "          \"state_code\": \"KHO\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Kunar\",\n" +
               "          \"state_code\": \"KNR\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Kunduz Province\",\n" +
               "          \"state_code\": \"KDZ\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Laghman\",\n" +
               "          \"state_code\": \"LAG\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Logar\",\n" +
               "          \"state_code\": \"LOG\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Nangarhar\",\n" +
               "          \"state_code\": \"NAN\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Nimruz\",\n" +
               "          \"state_code\": \"NIM\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Nuristan\",\n" +
               "          \"state_code\": \"NUR\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Paktia\",\n" +
               "          \"state_code\": \"PIA\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Paktika\",\n" +
               "          \"state_code\": \"PKA\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Panjshir\",\n" +
               "          \"state_code\": \"PAN\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Parwan\",\n" +
               "          \"state_code\": \"PAR\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Samangan\",\n" +
               "          \"state_code\": \"SAM\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Sar-e Pol\",\n" +
               "          \"state_code\": \"SAR\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Takhar\",\n" +
               "          \"state_code\": \"TAK\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Urozgan\",\n" +
               "          \"state_code\": \"URU\"\n" +
               "        },\n" +
               "        {\n" +
               "          \"name\": \"Zabul\",\n" +
               "          \"state_code\": \"ZAB\"\n" +
               "        }\n" +
               "      ]\n" +
               "    }";
        System.out.println("object to cast "+object);
        var countryStatesDTO = jsonToObject.castJsonToObject(object);
        assertNotNull(countryStatesDTO);

    }

    @Test
    public void jsonFromFile(){
        var path = Paths.get("./src/test/resources/countries.states.short.json");
        try {
            var allLines = Files.readAllLines(path);
            System.out.println("total lines "+allLines.size());
            var result = allLines.stream().reduce((a,b)->a+b).orElse("empty");
            System.out.println(result);
            System.out.println("total leght result "+result.length());
            var object = JsonToObject.castApiResponseCountriesStatesDTOJsonToObject(result);
            System.out.println(object.data().size());
            object.data().parallelStream().forEach(c -> System.out.println(c.name()));
        //    allLines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void jsonFromFileCountryPopulation(){
       var path = Paths.get("./src/test/resources/countries.population.json");
        try {
            var allLines = Files.readAllLines(path);
            System.out.println("total lines "+allLines.size());
            var result = allLines.stream().reduce((a,b)->a+b).orElse("empty");
            System.out.println("total leght result "+result.length());
            //allLines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
package com.jlopez.api.countries.client;

import com.jlopez.flow.StatisticFlowImplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountriesClient {

    public static void main(String... args){

        StatisticFlowImplement statisticFlowImplement  = new StatisticFlowImplement();
        int option=0;
        while( option!=4){
            String menu= """ 
                                Selecciona una opcion
                                1. Listar paises
                                2. Estadisticas completas
                                3. Estadisticas de pais
                                4. Salir
                        """;
            System.out.println(menu);
            option = readMenuOption();

            switch (option){
                case 1 -> statisticFlowImplement.getAllCountries();
                case 2 -> statisticFlowImplement.getStatisticsForAllCountries();
                case 3 -> {System.out.println("Escribir nombre de Pais");
                    String country = readFromCommandLine();
                    statisticFlowImplement.getStatisticsForCountry(country);}
                case 4 -> System.out.println("Adios");
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    private static Integer readMenuOption(){
        String keyInput = readFromCommandLine();
        try {
            return Integer.parseInt(keyInput);
        }catch(NumberFormatException nbf){
            return -1;
        }
    }

    private static String readFromCommandLine() {
        BufferedReader r = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            return r.readLine();
        } catch (IOException e) {
            return "";
        }
    }



}

package com.jlopez.api.countries.client;

import com.jlopez.flow.StatisticFlowImplement;

public class CountriesClient {

    public static void main(String... args){

        StatisticFlowImplement statisticFlowImplement  = new StatisticFlowImplement();
        statisticFlowImplement.getStatisticsForAllCountries();

    }


}

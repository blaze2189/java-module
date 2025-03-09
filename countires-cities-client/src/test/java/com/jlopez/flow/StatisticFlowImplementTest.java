package com.jlopez.flow;

import org.junit.Test;

public class StatisticFlowImplementTest {

    private final static StatisticFlowImplement statisticFlowImplement = new StatisticFlowImplement();

    @Test
    public void testGetStatisticsForCountry(){

        statisticFlowImplement.getStatisticsForCountry("Mexico");

    }

    @Test
    public void testGetStatisticsForInvalidCountry(){

        statisticFlowImplement.getStatisticsForCountry("México");

    }

    @Test
    public void testGetStatisticsForNullCountry(){

        statisticFlowImplement.getStatisticsForCountry(null);

    }

    @Test
    public void testGetStatisticsForAllCountries(){
        statisticFlowImplement.getStatisticsForAllCountries();
    }

}
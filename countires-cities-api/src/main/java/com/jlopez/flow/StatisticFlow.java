package com.jlopez.flow;

public sealed interface StatisticFlow permits StatisticFlowImplement {

    void getAllCountries();

    void getStatisticsForAllCountries();

    void getStatisticsForCountry(String country);

}

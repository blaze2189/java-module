package com.jlopez.flow;

public sealed interface StatisticFlow permits StatisticFlowImplement {

    void getStatisticsForAllCountries();

    void getStatisticsForCountry(String country);

}

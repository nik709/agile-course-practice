package ru.unn.agile.currencyconverter.model;

import static ru.unn.agile.currencyconverter.model.ExchangeRates.RUBLE_TO_DOLLAR;

public class RubleDollarConverter implements CurrencyConverter {

    @Override
    public double convert(final double ruble) {
        return ruble * RUBLE_TO_DOLLAR;
    }
}

package ru.unn.agile.currencyconverter.model;

import static ru.unn.agile.currencyconverter.model.ExchangeRates.EURO_TO_RUBLE;

public class EuroRubleConverter implements CurrencyConverter {

    @Override
    public double convert(final double euro) {
        return euro * EURO_TO_RUBLE;
    }
}

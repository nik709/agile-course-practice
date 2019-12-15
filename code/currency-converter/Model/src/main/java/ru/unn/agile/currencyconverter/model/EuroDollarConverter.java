package ru.unn.agile.currencyconverter.model;

import static ru.unn.agile.currencyconverter.model.ExchangeRates.EURO_TO_DOLLAR;

public class EuroDollarConverter implements CurrencyConverter {

    @Override
    public double convert(final double euro) {
        return euro * EURO_TO_DOLLAR;
    }
}

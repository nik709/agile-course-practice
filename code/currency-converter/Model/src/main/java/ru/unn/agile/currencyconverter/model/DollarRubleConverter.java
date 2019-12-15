package ru.unn.agile.currencyconverter.model;

import static ru.unn.agile.currencyconverter.model.ExchangeRates.DOLLAR_TO_RUBLE;

public class DollarRubleConverter implements CurrencyConverter {

    @Override
    public double convert(final double dollar) {
        return dollar * DOLLAR_TO_RUBLE;
    }
}

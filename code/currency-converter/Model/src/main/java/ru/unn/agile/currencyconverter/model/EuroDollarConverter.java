package ru.unn.agile.currencyconverter.model;

public class EuroDollarConverter implements CurrencyConverter {

    private final double exchange = 1.11;

    @Override
    public double convert(final double euro) {
        return euro * exchange;
    }
}

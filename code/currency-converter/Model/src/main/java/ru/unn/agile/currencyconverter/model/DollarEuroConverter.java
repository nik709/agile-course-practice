package ru.unn.agile.currencyconverter.model;

public class DollarEuroConverter implements CurrencyConverter {

    private final double exchange = 89.92 / 100;

    @Override
    public double convert(final double dollar) {
        return dollar * exchange;
    }
}

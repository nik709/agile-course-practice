package ru.unn.agile.currencyconverter.model;

public class DollarEuroConverter implements CurrencyConverter {

    private final double exchange = 0.8992;

    @Override
    public double convert(final double dollar) {
        return dollar * exchange;
    }
}

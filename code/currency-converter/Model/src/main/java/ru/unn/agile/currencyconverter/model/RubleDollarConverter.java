package ru.unn.agile.currencyconverter.model;

public class RubleDollarConverter implements CurrencyConverter {

    private final double exchange = 0.016;

    @Override
    public double convert(final double ruble) {
        return ruble * exchange;
    }
}

package ru.unn.agile.currencyconverter.model;

public class RubleEuroConverter implements CurrencyConverter {

    private final double exchange = 1.43 / 100;

    @Override
    public double convert(double ruble) {
        return ruble * exchange;
    }
}

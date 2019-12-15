package ru.unn.agile.currencyconverter.model;

public class EuroRubleConverter implements CurrencyConverter {

    private final double exchange = 69.86;

    @Override
    public double convert(final double euro) {
        return euro * exchange;
    }
}

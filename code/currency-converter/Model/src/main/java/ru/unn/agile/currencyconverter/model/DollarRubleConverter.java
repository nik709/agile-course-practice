package ru.unn.agile.currencyconverter.model;

public class DollarRubleConverter implements CurrencyConverter {

    private final double exchange = 62.55;

    @Override
    public double convert(final double dollar) {
        return dollar * exchange;
    }
}

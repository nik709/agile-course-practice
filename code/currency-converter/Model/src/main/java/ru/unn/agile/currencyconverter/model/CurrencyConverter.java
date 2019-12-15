package ru.unn.agile.currencyconverter.model;

public class CurrencyConverter {
    private CurrencyPair currencyPair;
    private double currency;

    public CurrencyConverter(final CurrencyPair currencyPair, final double currency) {
        if (currency <= 0) {
            throw new IllegalArgumentException("Currency should be positive!");
        }
        this.currencyPair = currencyPair;
        this.currency = currency;
    }

    public double convert() {
        return currency * currencyPair.getExchange();
    }
}

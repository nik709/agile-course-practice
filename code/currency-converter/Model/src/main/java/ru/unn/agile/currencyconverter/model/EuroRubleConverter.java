package ru.unn.agile.currencyconverter.model;

public class EuroRubleConverter implements CurrencyConverter {

    @Override
    public double convert(double euro) {
        double exchangeRate = 69.86;
        return euro * exchangeRate;
    }
}

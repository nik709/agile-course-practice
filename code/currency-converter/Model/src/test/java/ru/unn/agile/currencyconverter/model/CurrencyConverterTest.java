package ru.unn.agile.currencyconverter.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyConverterTest {

    private final double delta = 0.01;

    @Test
    public void canCreateConverter() {
        var converter = new CurrencyConverter(CurrencyPair.DOLLAR_TO_EURO, 1);
        assertNotNull(converter);
    }

    @Test
    public void canConvertEuroToRuble() {
        var converter = new CurrencyConverter(CurrencyPair.EURO_TO_RUBLE, 1);
        var expectedRuble = 69.86;
        assertEquals(expectedRuble, converter.convert(), delta);
    }

    @Test
    public void canConvertRubleToEuro() {
        var converter = new CurrencyConverter(CurrencyPair.RUBLE_TO_EURO, 10000);
        var expectedEuro = 140;
        assertEquals(expectedEuro, converter.convert(), delta);
    }

    @Test
    public void canConvertEuroToDollar() {
        var converter = new CurrencyConverter(CurrencyPair.EURO_TO_DOLLAR, 100);
        var expectedDollar = 112.00000000000001;
        assertEquals(expectedDollar, converter.convert(), delta);
    }

    @Test
    public void canConvertDollarToEuro() {
        var converter = new CurrencyConverter(CurrencyPair.DOLLAR_TO_EURO, 10000);
        var expectedEuro = 8900;
        assertEquals(expectedEuro, converter.convert(), delta);
    }

    @Test
    public void canConvertDollarToRuble() {
        var converter = new CurrencyConverter(CurrencyPair.DOLLAR_TO_RUBLE, 10);
        var expectedRuble = 625.5;
        assertEquals(expectedRuble, converter.convert(), delta);
    }

    @Test
    public void canConvertRubleToDollar() {
        var converter = new CurrencyConverter(CurrencyPair.RUBLE_TO_DOLLAR, 10000);
        var expectedDollar = 160;
        assertEquals(expectedDollar, converter.convert(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotConvertNegative() {
        var converter = new CurrencyConverter(CurrencyPair.EURO_TO_RUBLE, -10000);
    }
}

package ru.unn.agile.currencyconverter.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyConverterTest {

    private final double delta = 0.01;

    @Test
    public void canCreateConverter() {
        var converter = new EuroRubleConverter();
        assertNotNull(converter);
    }

    @Test
    public void canConvertEuroToRuble() {
        var converter = new EuroRubleConverter();
        var expectedRuble = 69.86;
        assertEquals(expectedRuble, converter.convert(1), delta);
    }

    @Test
    public void canConvertRubleToEuro() {
        var converter = new RubleEuroConverter();
        var expectedEuro = 143;
        assertEquals(expectedEuro, converter.convert(10000), delta);
    }

    @Test
    public void canConvertEuroToDollar() {
        var converter = new EuroDollarConverter();
        var expectedDollar = 111;
        assertEquals(expectedDollar, converter.convert(100), delta);
    }

}

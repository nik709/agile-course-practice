package ru.unn.agile.currencyconverter.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CurrencyConverterTest {

    @Test
    public void canCreateConverter() {
        var converter = new EuroRubleConverter();
        assertNotNull(converter);
    }

}

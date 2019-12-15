package ru.unn.agile.primenumber.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PrimeNumberFinderTest {

    private double delta = 1e-3;

    @Test
    public void canInitFinder() {
        var finder = new PrimeNumberFinder(0, 10);
        assertNotNull(finder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotInitFinderWithNegativeStart() {
        var finder = new PrimeNumberFinder(-1, 10);
        assertNotNull(finder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotInitFinderWithNegativeEnd() {
        var finder = new PrimeNumberFinder(0, -1);
        assertNotNull(finder);
    }
}

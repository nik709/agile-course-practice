package ru.unn.agile.primenumber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotInitFinderWithNegativeEnd() {
        var finder = new PrimeNumberFinder(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotInitFinderWithEndBiggerThanStart() {
        var finder = new PrimeNumberFinder(10, 0);
    }

    @Test
    public void cannotFindNumber0() {
        var finder = new PrimeNumberFinder(0, 1);
        var result = finder.findNumbers();
        assertEquals("",result);
    }

    @Test
    public void canFindNumber1() {
        var finder = new PrimeNumberFinder(0, 2);
        var result = finder.findNumbers();
        assertEquals("1",result);
    }

    @Test
    public void canFindNumber3() {
        var finder = new PrimeNumberFinder(0, 4);
        var result = finder.findNumbers();
        assertEquals("1 3",result);
    }

    @Test
    public void canFindNumber5() {
        var finder = new PrimeNumberFinder(0, 6);
        var result = finder.findNumbers();
        assertEquals("1 3 5",result);
    }

    @Test
    public void canFindNumber7() {
        var finder = new PrimeNumberFinder(0, 8);
        var result = finder.findNumbers();
        assertEquals("1 3 5 7",result);
    }

    @Test
    public void canFindNumber11() {
        var finder = new PrimeNumberFinder(0, 12);
        var result = finder.findNumbers();
        assertEquals("1 3 5 7 11",result);
    }

}

package ru.unn.agile.primenumber.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrimeNumberFinderTest {

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
    public void cannotFindPrimeNumberBefore2() {
        var finder = new PrimeNumberFinder(0, 2);
        var result = finder.findNumbers();
        assertEquals("", result);
    }

    @Test
    public void canFindPrimeNumber1() {
        var finder = new PrimeNumberFinder(0, 3);
        var result = finder.findNumbers();
        assertEquals("2", result);
    }

    @Test
    public void canFindPrimeNumber3() {
        var finder = new PrimeNumberFinder(0, 4);
        var result = finder.findNumbers();
        assertEquals("2 3", result);
    }

    @Test
    public void canFindPrimeNumber5() {
        var finder = new PrimeNumberFinder(0, 6);
        var result = finder.findNumbers();
        assertEquals("2 3 5", result);
    }

    @Test
    public void canFindPrimeNumber7() {
        var finder = new PrimeNumberFinder(0, 8);
        var result = finder.findNumbers();
        assertEquals("2 3 5 7", result);
    }

    @Test
    public void canFindPrimeNumber11() {
        var finder = new PrimeNumberFinder(0, 12);
        var result = finder.findNumbers();
        assertEquals("2 3 5 7 11", result);
    }

    @Test
    public void canFindPrimeNumber101() {
        var finder = new PrimeNumberFinder(0, 102);
        var result = finder.findNumbers();
        assertTrue(result.contains(" 101"));
    }

    @Test
    public void canFindPrimeNumber907() {
        var finder = new PrimeNumberFinder(0, 1000);
        var result = finder.findNumbers();
        assertTrue(result.contains(" 907"));
    }

    @Test
    public void canFindPrimeNumbersTill100() {
        var finder = new PrimeNumberFinder(0, 100);
        var result = finder.findNumbers();
        assertEquals(
                "2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97",
                result);
    }
}

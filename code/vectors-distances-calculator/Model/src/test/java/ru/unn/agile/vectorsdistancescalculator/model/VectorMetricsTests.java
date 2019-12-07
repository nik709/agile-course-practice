package ru.unn.agile.vectorsdistancescalculator.model;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class VectorMetricsTests {

    private static final double EPS = 0.01f;

    @Test
    public void canCalculateL1DistanceOneDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(1.0);
        double expectedL1 = 1.0;
        double actualL1 = VectorMetrics.calculateL1(vector);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test
    public void canCalculateL1DistanceTwoDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(1.1);
        vector.add(2.2);
        double expectedL1 = 3.3f;
        double actualL1 = VectorMetrics.calculateL1(vector);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test
    public void canCalculateL1DistanceThreeDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(1.1);
        vector.add(2.2);
        vector.add(3.3);
        double expectedL1 = 6.6;
        double actualL1 = VectorMetrics.calculateL1(vector);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test
    public void canCalculateL1DistanceWithNegativeValues() {
        Vector<Double> vector = new Vector<>();
        vector.add(-1.1);
        vector.add(2.2);
        vector.add(-3.3);
        double expectedL1 = 6.6;
        double actualL1 = VectorMetrics.calculateL1(vector);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test(expected = NoSuchElementException.class)
    public void throwExceptionCalculateL1DistanceEmptyVector() {
        Vector<Double> vector = new Vector<>();
        VectorMetrics.calculateL1(vector);
    }

    @Test(expected = NullPointerException.class)
    public void throwNPECalculateL1DistanceNullVector() {
        Vector<Double> vector = null;
        VectorMetrics.calculateL1(vector);
    }

    @Test
    public void canCalculateL2DistanceOneDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        double expectedL1 = 2.0;
        double actualL1 = VectorMetrics.calculateL2(vector);
        assertEquals(expectedL1, actualL1, EPS);
    }

}

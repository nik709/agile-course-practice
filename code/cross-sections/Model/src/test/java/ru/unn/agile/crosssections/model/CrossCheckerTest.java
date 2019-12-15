package ru.unn.agile.crosssections.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CrossCheckerTest {

    private double delta = 1e-3;

    @Test
    public void canInitCrossChecker() {
        var checker = new CrossChecker();
        assertNotNull(checker);
    }

    @Test
    public void canCreatePoint() {
        int x = 0;
        int y = 1;
        Point point = new Point(x, y);
        assertNotNull(point);
    }

    @Test
    public void canCreatePointNegative() {
        int x = -2;
        int y = -4;
        Point point = new Point(x, y);
        assertNotNull(point);
    }

    @Test
    public void canCreateSection() {
        Point a = new Point(1, 2);
        Point b = new Point(1, 3);
        Section section = new Section(a, b);
        assertNotNull(section);
    }

    @Test
    public void canCreateSectionNegative() {
        Point a = new Point(-1, -2);
        Point b = new Point(-1, -3);
        Section section = new Section(a, b);
        assertNotNull(section);
    }
}

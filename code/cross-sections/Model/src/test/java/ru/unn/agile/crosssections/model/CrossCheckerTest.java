package ru.unn.agile.crosssections.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CrossCheckerTest {

    @Test
    public void canInitCrossChecker() {
        CrossChecker checker = new CrossChecker();
        assertNotNull(checker);
    }

    @Test
    public void canInitPoint() {
        int x = 3;
        int y = 2;
        Point point = new Point(x, y);
        assertNotNull(point);
    }

    @Test
    public void canInitPointNegative() {
        int x = -3;
        int y = -2;
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

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateSectionWithTheSamePoints() {
        Point a = new Point(-1, -2);
        Point b = new Point(-1, -2);
        Section section = new Section(a, b);
    }

    @Test
    public void canCheckCrossOnTheSameSections() {
        Point a = new Point(0, 2);
        Point b = new Point(2, 2);
        Section section1 = new Section(a, b);
        Section section2 = new Section(a, b);
        CrossChecker checker = new CrossChecker();
        assertTrue(checker.check(section1, section2));
    }

    @Test
    public void canCheckCrossOnTheSameNegativeSections() {
        Point a = new Point(-1, -2);
        Point b = new Point(-2, -2);
        Section section1 = new Section(a, b);
        Section section2 = new Section(a, b);
        CrossChecker checker = new CrossChecker();
        assertTrue(checker.check(section1, section2));
    }

    @Test
    public void canCheckCrossOnTheSameStartSections() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 2);
        Section section1 = new Section(a, b);
        Point c = new Point(0, 2);
        Point d = new Point(0, 2);
        Section section2 = new Section(c, d);
        CrossChecker checker = new CrossChecker();
        assertTrue(checker.check(section1, section2));
    }
}

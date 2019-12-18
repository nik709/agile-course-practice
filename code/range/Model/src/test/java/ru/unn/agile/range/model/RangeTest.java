package ru.unn.agile.range.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeTest {

    @Test
    public void rangeContainsIntegerValue() {
        Range range = new Range("  [  10 , 11 )   ");

        assertTrue(range.isContainsValue(10));
    }

    @Test
    public void rangeNotContainsIntegerValue() {
        Range range = new Range("[10,11)");

        assertFalse(range.isContainsValue(11));
    }

    @Test(expected = RuntimeException.class)
    public void throwWhenInitRangeIncorrectly() {
        new Range("[11,11)");
    }

    @Test
    public void rangeContainsSetOfIntegers() {
        Range range = new Range("[10,15)");

        assertTrue(range.isContainsSet(new IntegerSet(" {  10 , 11 , 13 }  ")));
    }

    @Test
    public void rangeNotContainsSetWhenOneElementContains() {
        Range range = new Range(" [ 10 , 15 ) ");

        assertFalse(range.isContainsSet(new IntegerSet(" {10  , 16} ")));
    }

    @Test
    public void rangeNotContainsSetOfIntegers() {
        Range range = new Range("[10,15)");

        assertFalse(range.isContainsSet(new IntegerSet("{9,16}")));
    }

    @Test
    public void rangeGetNotAllPointsWhenMissedPoints() {
        Range range = new Range("[10,15)");

        assertNotEquals(range.getAllPoints().toString(), new IntegerSet("{10,14}").toString());
    }

    @Test
    public void rangeGetNotAllPointsWhenExtraPoints() {
        Range range = new Range("(10,15)");

        assertNotEquals(range.getAllPoints().toString(),
                new IntegerSet("{10,11,12,13,14,15}").toString());
    }

    @Test
    public void rangeGetAllPoints() {
        Range range = new Range("[10,15)");

        assertEquals(range.getAllPoints().toString(),
                new IntegerSet("{10,11,12,13,14}").toString());
    }

    @Test
    public void rangeDoesNotContainAnotherRange1() {
        Range range = new Range("[10,15)");

        assertFalse(range.isContainRange(new Range("[9,16]")));
    }

    @Test
    public void rangeDoesNotContainAnotherRange2() {
        Range range = new Range("[10,15)");

        assertFalse(range.isContainRange(new Range("[9,13]")));
    }

    @Test
    public void rangeDoesNotContainAnotherRange3() {
        Range range = new Range("[10,15)");

        assertFalse(range.isContainRange(new Range("[11,16]")));
    }

    @Test
    public void rangeContainsAnotherRange() {
        Range range = new Range("[10,15)");

        assertTrue(range.isContainRange(new Range("[11,13]")));
    }

    @Test
    public void rangeEndPointsNegativeTest1() {
        Range range = new Range("(10,15)");

        assertNotEquals(range.endPoints().toString(), new IntegerSet("{10,15}").toString());
    }

    @Test
    public void rangeEndPointsNegativeTest2() {
        Range range = new Range("[10,15]");

        assertNotEquals(range.endPoints().toString(), new IntegerSet("{11,14}").toString());
    }

    @Test
    public void rangeEndPointsNegativeTest3() {
        Range range = new Range("(10,15]");

        assertNotEquals(range.endPoints().toString(), new IntegerSet("{11,14}").toString());
    }

    @Test
    public void rangeEndPointsNegativeTest4() {
        Range range = new Range("[10,15)");

        assertNotEquals(range.endPoints().toString(), new IntegerSet("{11,14}").toString());
    }

    @Test
    public void rangeEndPointsPositiveTest1() {
        Range range = new Range("[10,15)");

        assertEquals(range.endPoints().toString(), new IntegerSet("{10,14}").toString());
    }

    @Test
    public void rangeEndPointsPositiveTest2() {
        Range range = new Range("[10,15]");

        assertEquals(range.endPoints().toString(), new IntegerSet("{10,15}").toString());
    }

    @Test
    public void rangeEndPointsPositiveTest3() {
        Range range = new Range("(10,15)");

        assertEquals(range.endPoints().toString(), new IntegerSet("{11,14}").toString());
    }

    @Test
    public void rangeOverlapsWithAnotherRangeNegativeTest1() {
        Range range1 = new Range("[10,15)");
        Range range2 = new Range("[15,20)");

        assertFalse(range1.overlapsRange(range2));
    }

    @Test
    public void rangeOverlapsWithAnotherRangeNegativeTest2() {
        Range range1 = new Range("[10,15]");
        Range range2 = new Range("(15,20)");

        assertFalse(range1.overlapsRange(range2));
    }

    @Test
    public void rangeOverlapsWithAnotherRangeNegativeTest3() {
        Range range1 = new Range("[10,15]");
        Range range2 = new Range("(5,10)");

        assertFalse(range1.overlapsRange(range2));
    }

    @Test
    public void rangeOverlapsWithAnotherRangeNegativeTest4() {
        Range range1 = new Range("[11,15]");
        Range range2 = new Range("(5,9)");

        assertFalse(range1.overlapsRange(range2));
    }

    @Test
    public void rangeOverlapsWithAnotherRangePositiveTest1() {
        Range range1 = new Range("[11,15]");
        Range range2 = new Range("(9,19)");

        assertTrue(range1.overlapsRange(range2));
    }

    @Test
    public void rangeOverlapsWithAnotherRangePositiveTest2() {
        Range range1 = new Range("[11,15]");
        Range range2 = new Range("(13,19)");

        assertTrue(range1.overlapsRange(range2));
    }

    @Test
    public void rangeOverlapsWithAnotherRangePositiveTest3() {
        Range range1 = new Range("[11,20]");
        Range range2 = new Range("(5,19)");

        assertTrue(range1.overlapsRange(range2));
    }

    @Test
    public void rangeOverlapsWithAnotherRangePositiveTest4() {
        Range range1 = new Range("[11,20]");
        Range range2 = new Range("[11,20]");

        assertTrue(range1.overlapsRange(range2));
    }

    @Test
    public void rangeEqualsWithAnotherRangePositiveTest1() {
        Range range1 = new Range("[11,20]");
        Range range2 = new Range("[11,20]");

        assertTrue(range1.equals(range2));
    }

    @Test
    public void rangeEqualsWithAnotherRangePositiveTest2() {
        Range range1 = new Range("[11,20]");
        Range range2 = new Range("(10,21)");

        assertTrue(range1.equals(range2));
    }

    @Test
    public void rangeEqualsWithAnotherRangeNegativeTest() {
        Range range1 = new Range("[11,20]");
        Range range2 = new Range("(11,20)");

        assertFalse(range1.equals(range2));
    }

}

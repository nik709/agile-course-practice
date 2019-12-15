package ru.unn.agile.primenumber.model;

import java.util.*;

public class PrimeNumberFinder {

    private int startSpan;

    private int endSpan;

    public PrimeNumberFinder(final int startSpan, final int endSpan) {
        if (startSpan < 0 || endSpan < 0) {
            throw new IllegalArgumentException("Span's borders should be positive!");
        }
        if (startSpan > endSpan) {
            throw new IllegalArgumentException("Span's right border should be bigger than left border!");
        }
        this.endSpan = endSpan;
        this.startSpan = startSpan;
    }
}

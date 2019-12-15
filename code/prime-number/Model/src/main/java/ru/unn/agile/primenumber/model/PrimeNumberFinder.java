package ru.unn.agile.primenumber.model;

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

    public String findNumbers() {
        StringBuilder result = new StringBuilder();
        String prefix = "";
        for (int i = startSpan; i < endSpan; i++) {
            if (i == 1 || i == 3 || i == 5) {
                result.append(prefix)
                        .append(i);
                prefix = " ";
            }
        }
        return result.toString();
    }
}

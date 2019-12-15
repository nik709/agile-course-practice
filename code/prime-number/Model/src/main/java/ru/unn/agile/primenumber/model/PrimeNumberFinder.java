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
            if (isOriginalPrimeNumber(i) || isNotDividePrimeNumber(i)) {
                result.append(prefix)
                        .append(i);
                prefix = " ";
            }
        }
        return result.toString();
    }

    private boolean isOriginalPrimeNumber(int number) {
        return (number == 1 ||
                number == 3 ||
                number == 5 ||
                number == 7);
    }

    private boolean isNotDividePrimeNumber(int number) {
        return (number % 2 != 0 &&
                number % 3 != 0 &&
                number % 5 != 0 &&
                number % 7 != 0);
    }
}

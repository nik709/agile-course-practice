package ru.unn.agile.range.model;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class IntegerSet {
    private int[] values;

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (int value : values) {
            stringJoiner.add(String.valueOf(value));
        }
        return '{' + stringJoiner.toString() + '}';
    }

    public IntegerSet(final String setString) {
        String trimSetString = setString.trim();
        trimSetString = trimSetString.substring(1, trimSetString.length() - 1);
        trimSetString = trimSetString.trim();
        String[] set = trimSetString.split("[,\\s]+");
        values = Stream.of(set).mapToInt(Integer::parseInt).toArray();
    }

    public IntegerSet(final int[] values) {
        this.values = values;
    }

    public int[] getValues() {
        return values;
    }

}

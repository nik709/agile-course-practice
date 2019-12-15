package ru.unn.agile.crosssections.model;

import java.util.Objects;

public class Section {

    private Point a;
    private Point b;

    public Section(final Point a, final Point b) {
        if (a.equals(b)) {
            throw new IllegalArgumentException("Points should not be in one place");
        }
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Section section = (Section) o;
        return Objects.equals(a, section.a) &&
                Objects.equals(b, section.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

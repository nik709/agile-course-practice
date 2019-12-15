package ru.unn.agile.crosssections.model;

import java.util.Objects;

public class Section {

    private Point a;
    private Point b;

    public Section(Point a, Point b) {
        if (a.equals(b)) {
            throw new IllegalArgumentException("Points should not be in one place");
        }
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(a, section.a) &&
                Objects.equals(b, section.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

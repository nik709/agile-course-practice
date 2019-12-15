package ru.unn.agile.crosssections.model;

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
}

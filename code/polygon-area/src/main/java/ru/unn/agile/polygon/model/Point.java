package ru.unn.agile.polygon.model;

public class Point {
    private final double x;
    private final double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Point pointB) {
        return Math.sqrt(Math.pow(this.x - pointB.x, 2) + Math.pow(this.y - pointB.y, 2));
    }
}

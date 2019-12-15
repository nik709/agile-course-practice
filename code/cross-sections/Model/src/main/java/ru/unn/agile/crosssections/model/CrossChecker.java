package ru.unn.agile.crosssections.model;

public class CrossChecker {

    public CrossChecker() {
    }

    public boolean check(Section section1, Section section2) {
        return section1.equals(section2) || section1.getA() == section2.getA();
    }
}

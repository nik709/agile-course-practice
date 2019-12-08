package ru.unn.agile.dijkstraalgorithm.viewmodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EdgeViewModel {
    private final SimpleStringProperty vertex1 = new SimpleStringProperty("");
    private final SimpleStringProperty vertex2 = new SimpleStringProperty("");
    private final SimpleIntegerProperty weight = new SimpleIntegerProperty();

    public EdgeViewModel() {
        this("", "", "");
    }

    public EdgeViewModel(String vertex1, String vertex2, String weight) {
        setVertex1(vertex1);
        setVertex2(vertex2);
        setWeight(weight);
    }

    public String getVertex1() {
        return vertex1.get();
    }

    public SimpleStringProperty vertex1Property() {
        return vertex1;
    }

    public void setVertex1(String vertex1) {
        this.vertex1.set(vertex1);
    }

    public String getVertex2() {
        return vertex2.get();
    }

    public SimpleStringProperty vertex2Property() {
        return vertex2;
    }

    public void setVertex2(String vertex2) {
        this.vertex2.set(vertex2);
    }

    public int getWeight() {
        return weight.get();
    }

    public SimpleIntegerProperty weightProperty() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight.set(Integer.parseInt(weight));
    }
}

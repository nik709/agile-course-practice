package ru.unn.agile.dijkstraalgorithm.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ViewModel {

    private final StringProperty vertex1 = new SimpleStringProperty();
    private final StringProperty vertex2 = new SimpleStringProperty();
    private final StringProperty weight = new SimpleStringProperty();
    final ObservableList<EdgeViewModel> edgeList = FXCollections.observableArrayList();


    public ViewModel() {

    }

    public void addEdge() {
        EdgeViewModel newEdge = new EdgeViewModel(vertex1.get(), vertex2.get(), weight.get());
        edgeList.add(newEdge);

        vertex1.set("");
        vertex2.set("");
        weight.set("");
    }

    public String getVertex1() {
        return vertex1.get();
    }

    public StringProperty vertex1Property() {
        return vertex1;
    }

    public String getVertex2() {
        return vertex2.get();
    }

    public StringProperty vertex2Property() {
        return vertex2;
    }

    public String getWeight() {
        return weight.get();
    }

    public StringProperty weightProperty() {
        return weight;
    }

    public ObservableList<EdgeViewModel> getEdgeList() {
        return edgeList;
    }
}

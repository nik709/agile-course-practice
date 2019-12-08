package ru.unn.agile.dijkstraalgorithm.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.regex.Pattern;

public class ViewModel {

    private static final Pattern VERTEX_INPUT_AllOWED_SYMBOLES = Pattern.compile("^[a-zA-Z]+$");
    private static final Pattern WEIGHT_INPUT_AllOWED_SYMBOLES = Pattern.compile("^[1-9][0-9]*$");
    private final SimpleBooleanProperty addingNewEdgeDisabled = new SimpleBooleanProperty();


    private final StringProperty vertex1 = new SimpleStringProperty();
    private final StringProperty vertex2 = new SimpleStringProperty();
    private final StringProperty weight = new SimpleStringProperty();

    final ObservableList<EdgeViewModel> edgeList = FXCollections.observableArrayList();


    public ViewModel() {
        clearFormInput();

        BooleanBinding canCalculateBoolBinding = new BooleanBinding() {
            {
                super.bind(vertex1, vertex2, weight);
            }
            @Override
            protected boolean computeValue() {
                return (isVertex1InputCorrect() && isVertex2InputCorrect() && isWeightInputCorrect());
            }
        };
        addingNewEdgeDisabled.bind(canCalculateBoolBinding.not());
    }

    public void addEdge() {
        EdgeViewModel newEdge = new EdgeViewModel(vertex1.get(), vertex2.get(), weight.get());
        edgeList.add(newEdge);

        clearFormInput();
    }

    private void clearFormInput() {
        vertex1.set("");
        vertex2.set("");
        weight.set("");
    }

    public boolean isVertex1InputCorrect() {
        String exprText = vertex1.get().trim();
        return (VERTEX_INPUT_AllOWED_SYMBOLES.matcher(exprText).matches());
    }

    public boolean isVertex2InputCorrect() {
        String exprText = vertex2.get().trim();
        return (VERTEX_INPUT_AllOWED_SYMBOLES.matcher(exprText).matches());
    }

    public boolean isWeightInputCorrect() {
        String exprText = weight.get().trim();
        return (WEIGHT_INPUT_AllOWED_SYMBOLES.matcher(exprText).matches());
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

    public boolean isAddingNewEdgeDisabled() {
        return addingNewEdgeDisabled.get();
    }

    public SimpleBooleanProperty addingNewEdgeDisabledProperty() {
        return addingNewEdgeDisabled;
    }

    public void setAddingNewEdgeDisabled(boolean addingNewEdgeDisabled) {
        this.addingNewEdgeDisabled.set(addingNewEdgeDisabled);
    }

    public ObservableList<EdgeViewModel> getEdgeList() {
        return edgeList;
    }
}

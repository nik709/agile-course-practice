package ru.unn.agile.dijkstraalgorithm.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.dijkstraalgorithm.model.DijkstraGraph;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ViewModel {

    private DijkstraGraph graph;

    private static final Pattern VERTEX_INPUT_AllOWED_SYMBOLES = Pattern.compile("^[a-zA-Z]+$");
    private static final Pattern WEIGHT_INPUT_AllOWED_SYMBOLES = Pattern.compile("^[1-9][0-9]*$");
    private final SimpleBooleanProperty addingNewEdgeDisabled = new SimpleBooleanProperty();


    private final StringProperty vertex1 = new SimpleStringProperty();
    private final StringProperty vertex2 = new SimpleStringProperty();
    private final StringProperty weight = new SimpleStringProperty();

    private final ObservableList<EdgeViewModel> edgeList = FXCollections.observableArrayList();

    private final ObservableList<String> vertexList = FXCollections.observableArrayList();
    private ListProperty<String> vertexListProperty = new SimpleListProperty<>(vertexList);


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
        String exprText1 = vertex1.get().trim();
        String exprText2 = vertex2.get().trim();
        return (VERTEX_INPUT_AllOWED_SYMBOLES.matcher(exprText1).matches()) &&
                !(exprText1.equals(exprText2));
    }

    public boolean isVertex2InputCorrect() {
        String exprText1 = vertex1.get().trim();
        String exprText2 = vertex2.get().trim();
        return (VERTEX_INPUT_AllOWED_SYMBOLES.matcher(exprText2).matches() &&
                !(exprText1.equals(exprText2)));
    }

    public boolean isWeightInputCorrect() {
        String exprText = weight.get().trim();
        return (WEIGHT_INPUT_AllOWED_SYMBOLES.matcher(exprText).matches());
    }

    public void createGraph() {
        Set<String> vertexSet = new HashSet<>();

        List<DijkstraGraph.Edge> list = edgeList.stream()
                .map(EdgeViewModel::getEdge)
                .collect(Collectors.toList());

//        List<String> vertex1List = list.stream()
//                .map(DijkstraGraph.Edge::getV1)
//                .collect(Collectors.toList());
//
//        List<String> vertex2List = list.stream()
//                .map(DijkstraGraph.Edge::getV2)
//                .collect(Collectors.toList());

        List<String> vertex1List = edgeList.stream()
                .map(EdgeViewModel::vertex1Property)
                .map(v -> v.toString())
                .collect(Collectors.toList());

        List<String> vertex2List = list.stream()
                .map(DijkstraGraph.Edge::getV2)
                .collect(Collectors.toList());

        for (String x:vertex1List) {
            System.out.println(x.toString());
        }

        for (String x:vertex2List) {
            System.out.println(x);
        }

        graph = new DijkstraGraph(list);

        vertexSet.addAll(vertex1List);
        vertexSet.addAll(vertex2List);

        for (String x:vertexSet) {
            System.out.println(x);
        }

        vertexList.clear();
        vertexList.addAll(vertexSet);
        vertexList.addAll("a", "A", "c");
    }

    public StringProperty vertex1Property() {
        return vertex1;
    }

    public StringProperty vertex2Property() {
        return vertex2;
    }

    public StringProperty weightProperty() {
        return weight;
    }

    public SimpleBooleanProperty addingNewEdgeDisabledProperty() {
        return addingNewEdgeDisabled;
    }

    public ObservableList<EdgeViewModel> getEdgeList() {
        return edgeList;
    }

    public ListProperty<String> getVertexListProperty() {
        return vertexListProperty;
    }

}

package ru.unn.agile.dijkstraalgorithm.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.unn.agile.dijkstraalgorithm.viewmodel.EdgeViewModel;
import ru.unn.agile.dijkstraalgorithm.viewmodel.ViewModel;


public class Dijkstra {

    private final PseudoClass errorClass = PseudoClass.getPseudoClass("error");
    private final String vertexInputTooltip = "Only letters allowed";
    private final String weightInputTooltip = "Only positive integer numbers allowed";

    @FXML
    private ViewModel viewModel;

    @FXML
    private TextField vertex1TextField;
    @FXML
    private TextField vertex2TextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private Button addEdgeButton;

    @FXML
    private TableView<EdgeViewModel> tableEdges;
    @FXML
    private TableColumn<EdgeViewModel, String> vertex1Column;
    @FXML
    private TableColumn<EdgeViewModel, String> vertex2Column;
    @FXML
    private TableColumn<EdgeViewModel, Integer> weightColumn;

    @FXML Button createGraphButton;
    @FXML Button calculatePath;

    @FXML
    private ComboBox<String> fromComboBox;
    @FXML
    private ComboBox<String> toComboBox;


    @FXML
    void initialize() {
        vertex1TextField.textProperty().bindBidirectional(viewModel.vertex1Property());
        vertex1TextField.tooltipProperty().setValue(new Tooltip(vertexInputTooltip));
        viewModel.vertex1Property().addListener(obs -> setErrorBorder(vertex1TextField, !viewModel.isVertex1InputCorrect()));

        vertex2TextField.textProperty().bindBidirectional(viewModel.vertex2Property());
        vertex2TextField.tooltipProperty().setValue(new Tooltip(vertexInputTooltip));
        viewModel.vertex2Property().addListener(obs -> setErrorBorder(vertex2TextField, !viewModel.isVertex2InputCorrect()));

        weightTextField.textProperty().bindBidirectional(viewModel.weightProperty());
        weightTextField.tooltipProperty().setValue(new Tooltip(weightInputTooltip));
        viewModel.weightProperty().addListener(obs -> setErrorBorder(weightTextField, !viewModel.isWeightInputCorrect()));

        addEdgeButton.disableProperty().bindBidirectional(viewModel.addingNewEdgeDisabledProperty());
        addEdgeButton.setOnAction(e -> viewModel.addEdge());

        tableEdges.setItems(viewModel.getEdgeList());
        vertex1Column.setCellValueFactory(new PropertyValueFactory<EdgeViewModel, String>("vertex1"));
        vertex2Column.setCellValueFactory(new PropertyValueFactory<EdgeViewModel, String>("vertex2"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<EdgeViewModel, Integer>("weight"));

        createGraphButton.setOnAction(e -> viewModel.createGraph());

        fromComboBox.itemsProperty().bind(viewModel.getVertexListProperty());
        toComboBox.itemsProperty().bind(viewModel.getVertexListProperty());
//        fromComboBox.setItems(viewModel.getVertexList());
//        toComboBox.setItems(viewModel.getVertexList());
    }

    private void setErrorBorder(final TextField textField, final boolean active) {
        textField.pseudoClassStateChanged(errorClass, active);
    }
}

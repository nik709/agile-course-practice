package ru.unn.agile.dijkstraalgorithm.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.unn.agile.dijkstraalgorithm.viewmodel.EdgeViewModel;
import ru.unn.agile.dijkstraalgorithm.viewmodel.ViewModel;


public class Dijkstra {

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


    @FXML
    void initialize() {
        vertex1TextField.textProperty().bindBidirectional(viewModel.vertex1Property());
        vertex2TextField.textProperty().bindBidirectional(viewModel.vertex2Property());
        weightTextField.textProperty().bindBidirectional(viewModel.weightProperty());
        addEdgeButton.setOnAction(e -> viewModel.addEdge());

        tableEdges.setItems(viewModel.getEdgeList());
        vertex1Column.setCellValueFactory(new PropertyValueFactory<EdgeViewModel, String>("vertex1"));
        vertex2Column.setCellValueFactory(new PropertyValueFactory<EdgeViewModel, String>("vertex2"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<EdgeViewModel, Integer>("weight"));
    }
}

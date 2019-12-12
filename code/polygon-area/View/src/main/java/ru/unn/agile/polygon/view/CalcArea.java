package ru.unn.agile.polygon.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.unn.agile.polygon.viewmodel.ViewModel;

public class CalcArea {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField xTextField;
    @FXML
    private TextField yTextField;
    @FXML
    private Button addPointButton;
    @FXML
    private Button calcAreaButton;
    @FXML
    private TextArea resultTextArea;

    @FXML
    void initialize() {

    }
}

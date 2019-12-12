package ru.unn.agile.polygon.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ViewModel {

    private static final Pattern COORDINATE_INPUT_ALLOWED_SYMBOLS = Pattern.compile("^[-+]?[0-9]+\\.?[0-9]*$");

    private final StringProperty xCoordinate = new SimpleStringProperty();
    private final StringProperty yCoordinate = new SimpleStringProperty();

    private final StringProperty result = new SimpleStringProperty();


    public StringProperty xProperty() {
        return xCoordinate;
    }
    public StringProperty yProperty() {
        return yCoordinate;
    }
}
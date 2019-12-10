package ru.unn.agile.arabicromanconverter.viewmodel;

import javafx.beans.property.*;
import ru.unn.agile.arabicromanconverter.model.*;

public class ViewModel {

    private StringProperty input = new SimpleStringProperty();
    private StringProperty output = new SimpleStringProperty();
    private StringProperty error = new SimpleStringProperty();
    private StringProperty convert = new SimpleStringProperty();
    private BooleanProperty btnDisabled = new SimpleBooleanProperty();
    private ConverterType selector = ConverterType.ARABICTOROMAN;

    public ViewModel() {
        refresh();
        convert.set("Arabic to Roman");
        btnDisabled.set(true);

        input.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });
    }

    public void convert() {
        String value = input.get();
        Converter converter = selector.getConverter();
        String result = converter.convertValue(value);
        output.set(result);
    }

    public void swap() {
        if (selector == ConverterType.ARABICTOROMAN) {
            selector = ConverterType.ROMANTOARABIC;
        } else {
            selector = ConverterType.ARABICTOROMAN;
        }
        refresh();
    }

    public void refresh() {
        input.set("");
        output.set("");
        error.set("");
        convert.set(selector.toString());
    }

    public StringProperty getInput() {
        return input;
    }

    public StringProperty getOutput() {
        return output;
    }

    public StringProperty getConvert() {
        return convert;
    }

    public StringProperty getError() {
        return error;
    }

    public BooleanProperty isConvertButtonDisabled() {
        return btnDisabled;
    }

    private void onInput(final String newValue) {
        boolean isValid = selector.getConverter().validate(newValue);
        if (isValid || newValue.isEmpty()) {
            error.set("");
        } else {
            error.set(selector.getErrorMessage());
        }
        btnDisabled.set(newValue.isEmpty() || !isValid);
        output.set("");
    }
}

enum ConverterType {
    ARABICTOROMAN("Arabic to Roman", new ArabicToRomanConverter(), "Insert correct arabic number"),
    ROMANTOARABIC("Roman to Arabic", new RomanToArabicConverter(), "Insert correct roman number");

    private final String lblConvertingType;
    private final Converter converter;
    private final String errorMessage;

    ConverterType(final String label, final Converter converter, final String errorMessage) {
        this.lblConvertingType = label;
        this.converter = converter;
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return lblConvertingType;
    }

    public Converter getConverter() {
        return converter;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

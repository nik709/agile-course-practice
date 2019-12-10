package ru.unn.agile.arabicromanconverter.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.arabicromanconverter.model.*;

import static org.junit.Assert.*;

public class ArabicRomanConverterViewModelTests {

    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetEmptyInputField() {
        assertEquals("", viewModel.getInput().get());
    }

    @Test
    public void canSetEmptyOutputField() {
        assertEquals("", viewModel.getOutput().get());
    }

    @Test
    public void canSetEmptyErrorField() {
        assertEquals("", viewModel.getError().get());
    }

    @Test
    public void canRefreshField() {
        viewModel.getInput().set("test_input");
        viewModel.getOutput().set("test_output");
        viewModel.getError().set("test_error");

        viewModel.refresh();

        String result = viewModel.getInput().get()
                + viewModel.getOutput().get()
                + viewModel.getError().get();
        assertEquals("", result);
    }

    @Test
    public void isConvertLabelArabicByDefault() {
        assertEquals("Arabic to Roman", viewModel.getConvert().get());
    }

    @Test
    public void isConvertButtonDisabledByDefault() {
        assertEquals(true, viewModel.isConvertButtonDisabled().get());
    }

    @Test
    public void isConvertButtonNotDisabledAfterInsertingValue() {
        viewModel.getInput().set("1");
        assertEquals(false, viewModel.isConvertButtonDisabled().get());
    }

    @Test
    public void isConvertButtonDisabledAfterDeletingValue() {
        viewModel.getInput().set("1");
        viewModel.getInput().set("");
        assertEquals(true, viewModel.isConvertButtonDisabled().get());
    }

    @Test
    public void cantEnterNanWhileArabicSelected() {
        viewModel.getInput().set("I");
        assertEquals("Insert correct arabic number", viewModel.getError().get());
    }

    @Test
    public void canConvertFromArabicToRoman() {
        viewModel.getInput().set("1");

        viewModel.convert();

        assertEquals("I", viewModel.getOutput().get());
    }

    @Test
    public void isConvertLabelRomanAfterSwap() {
        viewModel.swap();
        assertEquals("Roman to Arabic", viewModel.getConvert().get());
    }

    @Test
    public void cantEnterNanWhileRomanSelected() {
        viewModel.swap();
        viewModel.getInput().set("1");
        assertEquals("Insert correct roman number", viewModel.getError().get());
    }

    @Test
    public void cantEnterNegativeWhileArabicSelected() {
        viewModel.getInput().set("-1");
        assertEquals("Insert correct arabic number", viewModel.getError().get());
    }

    @Test
    public void cantEnterNumberMoreThanMaxWhileArabicSelected() {
        viewModel.getInput().set("4000");
        assertEquals("Insert correct arabic number", viewModel.getError().get());
    }

    @Test
    public void canConvertFromRomanToArabic() {
        viewModel.swap();
        viewModel.getInput().set("I");

        viewModel.convert();

        assertEquals("1", viewModel.getOutput().get());
    }

    @Test
    public void canConvertWhileNonValidationError() {
        viewModel.getInput().set("1");

        assertEquals(false, viewModel.isConvertButtonDisabled().get());
    }

    @Test
    public void cantConvertWhileGettingValidationError() {
        viewModel.getInput().set("I");

        assertEquals(true, viewModel.isConvertButtonDisabled().get());
    }

    @Test
    public void canConvertWhileNonValidationErrorRomanToArabic() {
        viewModel.swap();
        viewModel.getInput().set("I");

        assertEquals(false, viewModel.isConvertButtonDisabled().get());
    }

    @Test
    public void cantConvertWhileGettingValidationErrorRomanToArabic() {
        viewModel.swap();
        viewModel.getInput().set("1");

        assertEquals(true, viewModel.isConvertButtonDisabled().get());
    }

    @Test
    public void isCleanFieldsAfterSwap() {
        viewModel.getInput().set("10");
        viewModel.convert();

        viewModel.swap();

        String result = viewModel.getInput().get()
                + viewModel.getOutput().get()
                + viewModel.getError().get();
        assertEquals("", result);
    }
}

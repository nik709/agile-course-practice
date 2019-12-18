package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class PopkovKirillTest {
    private final double delta = 0.001;

    @Test
    public void initComplexNumberWithEmptyConstructor() {
        ComplexNumber complexNumber = new ComplexNumber();

        assertEquals("0.0 + 0.0i", complexNumber.toString());
    }

    @Test
    public void getRealPartOfComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(1, 2);

        assertEquals(1.0, complexNumber.getReal(), delta);
    }

    @Test
    public void getImaginaryPartOfComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(1, 2);

        assertEquals(2.0, complexNumber.getImaginary(), delta);
    }

    @Test
    public void getRealPartOfInitWithStringsComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber("1", "2");

        assertEquals(1.0, complexNumber.getReal(), delta);
    }

    @Test
    public void getImaginaryPartOfInitWithStringsComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber("1", "2");

        assertEquals(2.0, complexNumber.getImaginary(), delta);
    }

    @Test
    public void checkAdditionOfComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber("1", "2");
        ComplexNumber complexNumber2 = new ComplexNumber("2", "3");
        ComplexNumber complexNumber3 = complexNumber1.add(complexNumber2);

        assertEquals(complexNumber3, new ComplexNumber(3, 5));
    }

    @Test
    public void checkMultiplicationOfComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber("1", "2");
        ComplexNumber complexNumber2 = new ComplexNumber("2", "-3");
        ComplexNumber complexNumber3 = complexNumber1.multiply(complexNumber2);

        assertEquals(complexNumber3, new ComplexNumber(8, 1));
    }
}

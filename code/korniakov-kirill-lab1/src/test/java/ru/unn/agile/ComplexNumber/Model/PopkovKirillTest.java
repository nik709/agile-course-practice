package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class PopkovKirillTest {
    private final double delta = 0.001;

    @Test
    public void initComplexNumberWithEmptyConstructor() {
        ComplexNumber cn = new ComplexNumber();

        assertEquals("0.0 + 0.0i", cn.toString());
    }

    @Test
    public void getRealPartOfComplexNumber() {
        ComplexNumber cn = new ComplexNumber(1, 2);

        assertEquals(1.0, cn.getReal(), delta);
    }

    @Test
    public void getImaginaryPartOfComplexNumber() {
        ComplexNumber cn = new ComplexNumber(1, 2);

        assertEquals(2.0, cn.getImaginary(), delta);
    }

    @Test
    public void getRealPartOfInitWithStringsComplexNumber() {
        ComplexNumber cn = new ComplexNumber("1", "2");

        assertEquals(1.0, cn.getReal(), delta);
    }

    @Test
    public void getImaginaryPartOfInitWithStringsComplexNumber() {
        ComplexNumber cn = new ComplexNumber("1", "2");

        assertEquals(2.0, cn.getImaginary(), delta);
    }

    @Test
    public void checkAdditionOfComplexNumbers() {
        ComplexNumber cn1 = new ComplexNumber("1", "2");
        ComplexNumber cn2 = new ComplexNumber("2", "3");
        ComplexNumber cn3 = cn1.add(cn2);

        assertEquals(3.0, cn3.getReal(), delta);
        assertEquals(5.0, cn3.getImaginary(), delta);
    }

    @Test
    public void checkMultiplicationOfComplexNumbers() {
        ComplexNumber cn1 = new ComplexNumber("1", "2");
        ComplexNumber cn2 = new ComplexNumber("2", "-3");
        ComplexNumber cn3 = cn1.multiply(cn2);

        assertEquals(8.0, cn3.getReal(), delta);
        assertEquals(1.0, cn3.getImaginary(), delta);
    }
}

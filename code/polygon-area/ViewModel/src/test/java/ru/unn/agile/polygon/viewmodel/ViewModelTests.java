package ru.unn.agile.polygon.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.polygon.model.Point;

import static org.junit.Assert.*;

public class ViewModelTests {
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
    public void isAddingValidInput () {
        setInputData();
        viewModel.addPoint();
        assertEquals(viewModel.getPointList().get(0).getX(), new Point(-1, 2.5).getX(), 1.0E-10);
        assertEquals(viewModel.getPointList().get(0).getY(), new Point(-1, 2.5).getY(), 1.0E-10);
    }

    private void setInputData() {
        viewModel.xProperty().set("-1");
        viewModel.yProperty().set("2.5");
    }
}

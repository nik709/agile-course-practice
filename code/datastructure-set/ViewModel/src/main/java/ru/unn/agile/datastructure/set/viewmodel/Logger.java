package ru.unn.agile.datastructure.set.viewmodel;

import java.util.List;

public interface Logger {

    void log(final String message);

    List<String> getLog();

}

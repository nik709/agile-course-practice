package ru.unn.agile.binarysearch.infrastructure;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

public class TxtLoggerTests {
    private static final String FILE_NAME = "./TxtLoggerTests.log";

    private TxtLogger txtLogger;

    @Before
    public void setUp() {
        txtLogger = new TxtLogger(FILE_NAME);
    }

    @Test
    public void canCreateLoggerWithFileName() {
        assertNotNull(txtLogger);
    }

    @Test
    public void canCreateLogFileOnDisk() {
        try {
            new BufferedReader(new FileReader(FILE_NAME));
        } catch (FileNotFoundException e) {
            fail("File " + FILE_NAME + " wasn't found!");
        }
    }

    @Test
    public void DateAndTimeContainInLog() {
        String testMessage = "Test message for check";

        txtLogger.log(testMessage);

        String logMessage = txtLogger.getLog().get(0);
        assertTrue(logMessage.matches("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2} > .*"));
    }

    @Test
    public void canWriteOneLogMessage() {
        String testMessage = "Test message #1";

        txtLogger.log(testMessage);

        String logMessage = txtLogger.getLog().get(0);
        assertTrue(logMessage.matches(".*" + logMessage + "$"));
    }

    @Test
    public void canWriteSeveralLogMessages() {
        String[] testMessages = {"Test message #1", "Test message #2"};

        for (String testMessage : testMessages) {
            txtLogger.log(testMessage);
        }

        List<String> logMessages = txtLogger.getLog();
        for (int i = 0; i < logMessages.size(); i++) {
            String logMessage = logMessages.get(i);
            assertTrue(logMessage.matches(".*" + logMessage + "$"));
        }
    }
}

package ru.unn.agile.stack.viewmodel;

import ru.unn.agile.stack.model.Stack;
import javafx.beans.property.*;

import java.util.List;

public class ViewModel {
    private Stack<Double> stackDouble;
    private final StringProperty isStackEmptyInfo = new SimpleStringProperty();
    private final StringProperty stackSize = new SimpleStringProperty();
    private final StringProperty topElement = new SimpleStringProperty();
    private final StringProperty popElement = new SimpleStringProperty();
    private final StringProperty pushElement = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final BooleanProperty popButtonState = new SimpleBooleanProperty();

    private ILogger logger;

    public ViewModel() {
        init();
    }

    public ViewModel(final ILogger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("Logger parameter can't be null");
        }
        this.logger = logger;

        init();
    }

    private void init() {
        stackDouble = new Stack<Double>();
        isStackEmptyInfo.set(Status.STACK_IS_EMPTY.toString());
        stackSize.set("0");
        topElement.set("None");
        popElement.set("None");
        pushElement.set("");
        status.set(Status.WAITING.toString());
        popButtonState.set(false);
    }

    public List<String> getLogList() {
        return logger.getLog();
    }

    public String getIsStackEmptyInfo() {
        return isStackEmptyInfo.get();
    }

    public StringProperty isStackEmptyInfoProperty() {
        return isStackEmptyInfo;
    }

    public String getStackSize() {
        return stackSize.get();
    }

    public StringProperty stackSizeProperty() {
        return stackSize;
    }

    public String getTopElement() {
        return topElement.get();
    }

    public StringProperty topElementProperty() {
        return topElement;
    }

    public String getPopElement() {
        return popElement.get();
    }

    public StringProperty popElementProperty() {
        return popElement;
    }

    public String getPushElement() {
        return pushElement.get();
    }

    public StringProperty pushElementProperty() {
        return pushElement;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty getStatusProperty() {
        return status;
    }

    public boolean getPopButtonState() {
        return popButtonState.get();
    }

    public BooleanProperty popButtonStateProperty() {
        return popButtonState;
    }

    public void setPushElement(final String inputElement) {
        pushElement.set(inputElement);
    }


    private void changeStackProperties() {
        int doubleStackSize = stackDouble.size();
        stackSize.set(Integer.toString(doubleStackSize));
        if (stackDouble.isEmpty()) {
            isStackEmptyInfo.set(Status.STACK_IS_EMPTY.toString());
            topElement.set("None");
            popButtonState.set(false);
        } else {
            isStackEmptyInfo.set(Status.STACK_IS_NOT_EMPTY.toString());
            topElement.set(Double.toString(stackDouble.peek()));
            popButtonState.set(true);
        }
    }

    public void pushNewElement() {
        String pushElement = getPushElement();
        try {
            if (pushElement.isEmpty()) {
                status.set(Status.WAITING.toString());
            } else {
                stackDouble.push(Double.parseDouble(pushElement));
                status.set(Status.READY.toString());
                changeStackProperties();
                logger.log("Push element " + pushElement + " into stack");
            }
        } catch (NumberFormatException e) {
            status.set(Status.BAD_FORMAT.toString());
            logger.log("Pushing element " + pushElement + " has invalid format");
        }
    }



    public void popElement() {
        if (!stackDouble.isEmpty()) {
            popElement.set(Double.toString(stackDouble.pop()));
            changeStackProperties();
            logger.log("Pop element " + getPopElement() + " from stack");
        }
    }
}

enum Status {
    WAITING("Waiting for new element"),
    READY("Ready to push new element"),
    BAD_FORMAT("Invalid format of the pushing element"),
    STACK_IS_EMPTY("Stack is empty"),
    STACK_IS_NOT_EMPTY("Stack is not empty");

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

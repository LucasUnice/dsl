package io.github.mosser.arduinoml.kernel.generator;

import io.github.mosser.arduinoml.kernel.behavioral.*;
import io.github.mosser.arduinoml.kernel.structural.*;
import io.github.mosser.arduinoml.kernel.App;

import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

    public abstract void visit(App app);

    public abstract void visit(State state);

    public abstract void visit(Mode mdoe);

    public abstract void visit(ModeTransition modeTransition);

    public abstract void visit(StateTransition stateTransition);

    public abstract void visit(Action action);

    public abstract void visit(TimeCondition timeCondition);

    public abstract void visit(DigitalSensorCondition digitalSensorCondition);

    public abstract void visit(AnalogSensorCondition analogSensorCondition);

    public abstract void visit(Actuator actuator);

    public abstract void visit(Sensor sensor);


    /***********************
     ** Helper mechanisms **
     ***********************/

    protected Map<String, Object> context = new HashMap<>();

    protected T result;

    public T getResult() {
        return result;
    }

}


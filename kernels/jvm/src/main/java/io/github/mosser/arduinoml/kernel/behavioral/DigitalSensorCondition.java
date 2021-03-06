package io.github.mosser.arduinoml.kernel.behavioral;

import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.DigitalSensor;
import io.github.mosser.arduinoml.kernel.structural.SIGNAL;
import io.github.mosser.arduinoml.kernel.structural.Sensor;

public class DigitalSensorCondition extends SensorCondition implements Condition {
    private DigitalSensor sensor;
    private SIGNAL value;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(DigitalSensor sensor) {
        this.sensor = sensor;
    }

    public SIGNAL getValue() {
        return value;
    }

    public void setValue(SIGNAL value) {
        this.value = value;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

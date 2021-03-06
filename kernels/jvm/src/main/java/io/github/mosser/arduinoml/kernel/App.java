package io.github.mosser.arduinoml.kernel;

import io.github.mosser.arduinoml.kernel.behavioral.Mode;
import io.github.mosser.arduinoml.kernel.behavioral.State;
import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import io.github.mosser.arduinoml.kernel.structural.Brick;
import io.github.mosser.arduinoml.kernel.structural.Watchable;

import java.util.ArrayList;
import java.util.List;

public class App implements NamedElement, Visitable {

    private String name;
    private List<Brick> bricks = new ArrayList<Brick>();
    private List<Watchable> watchs = new ArrayList<>();
    private List<Mode> modes = new ArrayList<>();
    private Mode initial;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public List<Mode> getModes() {
        return modes;
    }

    public void setModes(List<Mode> modes) {
        this.modes = modes;
    }

    public List<Watchable> getWatchs() {
        return watchs;
    }

    public void setWatchs(List<Watchable> watchs) {
        this.watchs = watchs;
    }

    public Mode getInitial() {
        return initial;
    }

    public void setInitial(Mode initial) {
        this.initial = initial;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

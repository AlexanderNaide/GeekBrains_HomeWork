package ru.gb.Bootcamp.Patterns.Command.Commands;

import ru.gb.Bootcamp.Patterns.Command.Light;
import ru.gb.Bootcamp.Patterns.Command.Command;

/**
 * Включить свет.
 */

public class TurnOnLight implements Command {

    private Light light;

    public TurnOnLight(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

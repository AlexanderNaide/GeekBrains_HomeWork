package ru.gb.Bootcamp.Patterns.Command.Commands;

import ru.gb.Bootcamp.Patterns.Command.Light;
import ru.gb.Bootcamp.Patterns.Command.Command;

/**
 * Выключить свет.
 */

public class TurnOffLight implements Command {

    private Light light;

    public TurnOffLight(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

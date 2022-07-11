package ru.gb.Patterns.Command.Commands;

import ru.gb.Patterns.Command.Command;
import ru.gb.Patterns.Command.Light;
import ru.gb.Patterns.Command.MusicBox;

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

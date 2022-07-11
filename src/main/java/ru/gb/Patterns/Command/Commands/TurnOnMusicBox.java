package ru.gb.Patterns.Command.Commands;

import ru.gb.Patterns.Command.Command;
import ru.gb.Patterns.Command.MusicBox;

/**
 * Включить музыкальный центр.
 */

public class TurnOnMusicBox implements Command {

    private MusicBox musicBox;

    public TurnOnMusicBox(MusicBox musicBox){
        this.musicBox = musicBox;
    }

    @Override
    public void execute() {
        musicBox.turnOn();
    }
}

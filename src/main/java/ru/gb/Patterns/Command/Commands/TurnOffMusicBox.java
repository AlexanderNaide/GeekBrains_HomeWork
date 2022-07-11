package ru.gb.Patterns.Command.Commands;

import ru.gb.Patterns.Command.Command;
import ru.gb.Patterns.Command.MusicBox;

/**
 * Отключить музыкальный центр.
 */

public class TurnOffMusicBox implements Command {

    private MusicBox musicBox;

    public TurnOffMusicBox(MusicBox musicBox){
        this.musicBox = musicBox;
    }

    @Override
    public void execute() {
        musicBox.turnOff();
    }
}

package ru.gb.Patterns.Command.Commands;

import ru.gb.Patterns.Command.Command;
import ru.gb.Patterns.Command.MusicBox;

/**
 * Сделать погромче
 */

public class MakeLoudMusicBox implements Command {

    private MusicBox musicBox;

    public MakeLoudMusicBox(MusicBox musicBox){
        this.musicBox = musicBox;
    }

    @Override
    public void execute() {
        musicBox.makeLoud();
    }
}

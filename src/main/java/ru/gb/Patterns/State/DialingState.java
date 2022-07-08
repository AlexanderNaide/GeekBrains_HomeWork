package ru.gb.Patterns.State;

import static ru.gb.Patterns.State.TalkingState.TALKING_STATE;

public class DialingState implements State{

    public static final DialingState DIALING_STATE = new DialingState();

    private DialingState(){
    }

    @Override
    public void updateState(Phone phone) {
        phone.setState(TALKING_STATE);
    }

    @Override
    public String toString() {
        return "DIALING_STATE";
    }
}

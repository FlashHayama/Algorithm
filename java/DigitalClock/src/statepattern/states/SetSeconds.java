package statepattern.states;

import statepattern.DigitalClock;

public class SetSeconds implements ClockState {

    @Override
    public StateEnum getType() {
        return StateEnum.SET_SECONDS;
    }

    @Override
    public void b1(DigitalClock context) {
        ClockState state = new SetHour();
        context.switchTo(state);
    }

    @Override
    public void b2(DigitalClock context) {
        ClockState state = new SetDate();
        context.switchTo(state);
    }

    @Override
    public void b3(DigitalClock context) {
        context.setSeconds(context.getSeconds() + 1);
    }
    
}

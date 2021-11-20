package statepattern.states;

import statepattern.DigitalClock;

public class SetHour implements ClockState {

    @Override
    public StateEnum getType() {
        return StateEnum.SET_HOUR;
    }

    @Override
    public void b1(DigitalClock context) {
        ClockState state = new DisplayHour();
        context.switchTo(state);
    }

    @Override
    public void b2(DigitalClock context) {
        ClockState state = new SetSeconds();
        context.switchTo(state);
    }

    @Override
    public void b3(DigitalClock context) {
        context.setHours(context.getHours() + 1);
    }
    
}

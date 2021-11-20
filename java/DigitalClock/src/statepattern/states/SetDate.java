package statepattern.states;

import statepattern.DigitalClock;

public class SetDate implements ClockState {

    @Override
    public StateEnum getType() {
        return StateEnum.SET_DATE;
    }

    @Override
    public void b1(DigitalClock context) {
        ClockState state = new SetSeconds();
        context.switchTo(state);
    }

    @Override
    public void b2(DigitalClock context) {
        ClockState state = new DisplayDate();
        context.switchTo(state);
    }

    @Override
    public void b3(DigitalClock context) {
        context.setDayInMonth(context.getDayInMonth() + 1);
    }
    
}

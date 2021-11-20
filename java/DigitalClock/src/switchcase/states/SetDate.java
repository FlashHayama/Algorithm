package switchcase.states;

import switchcase.DigitalClock;

public class SetDate extends ClockState {

    @Override
    public StateEnum getType() {
        return StateEnum.SET_DATE;
    }

    @Override
    public void b1(DigitalClock context) { context.setState(StateEnum.SET_SECONDS); }

    @Override
    public void b2(DigitalClock context) { context.setState(StateEnum.DISPLAY_DATE); }

    @Override
    public void b3(DigitalClock context) { context.playEvent(EventEnum.SET_DATE); }
    
}

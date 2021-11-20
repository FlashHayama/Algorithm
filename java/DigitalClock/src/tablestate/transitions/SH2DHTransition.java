package tablestate.transitions;

import tablestate.DigitalClock;
import tablestate.states.ClockState;
import tablestate.states.DisplayHour;

public class SH2DHTransition implements ITransition {

    @Override
    public void applyTransition(DigitalClock context) {
        ClockState state = new DisplayHour();
        context.switchTo(state);
    }
    
}

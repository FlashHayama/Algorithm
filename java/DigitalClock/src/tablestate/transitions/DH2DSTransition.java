package tablestate.transitions;

import tablestate.DigitalClock;
import tablestate.states.ClockState;
import tablestate.states.DisplaySecond;

public class DH2DSTransition implements ITransition {
    @Override
    public void applyTransition(DigitalClock context) {
        ClockState state = new DisplaySecond();
        context.switchTo(state);
    }
}

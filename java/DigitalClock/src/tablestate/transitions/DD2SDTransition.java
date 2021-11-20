package tablestate.transitions;

import tablestate.DigitalClock;
import tablestate.states.ClockState;
import tablestate.states.SetDate;

public class DD2SDTransition implements ITransition {

    @Override
    public void applyTransition(DigitalClock context) {
        ClockState state = new SetDate();
        context.switchTo(state);
    }
    
}

package tablestate.transitions;

import tablestate.DigitalClock;
import tablestate.states.ClockState;
import tablestate.states.SetSeconds;

public class DS2SSTransition implements ITransition {

    @Override
    public void applyTransition(DigitalClock context) {
        ClockState state = new SetSeconds();
        context.switchTo(state);
    }
    
}

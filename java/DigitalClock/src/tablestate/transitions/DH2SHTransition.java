package tablestate.transitions;

import tablestate.DigitalClock;
import tablestate.states.ClockState;
import tablestate.states.SetHour;

public class DH2SHTransition implements ITransition{

    @Override
    public void applyTransition(DigitalClock context) {
        ClockState state = new SetHour();
        context.switchTo(state);
    }
    
}

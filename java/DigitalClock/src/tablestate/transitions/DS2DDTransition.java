package tablestate.transitions;

import tablestate.DigitalClock;
import tablestate.states.ClockState;
import tablestate.states.DisplayDate;

public class DS2DDTransition implements ITransition{
    @Override
    public void applyTransition(DigitalClock context) {
        ClockState state = new DisplayDate();
        context.switchTo(state);
    }
}

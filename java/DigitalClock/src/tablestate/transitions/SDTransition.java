package tablestate.transitions;

import tablestate.DigitalClock;

public class SDTransition implements ITransition {

    @Override
    public void applyTransition(DigitalClock context) {
        context.setDayInMonth(context.getDayInMonth() + 1);
    }
    
}

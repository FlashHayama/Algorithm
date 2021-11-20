package tablestate.transitions;

import tablestate.DigitalClock;

public class SHTransition implements ITransition {

    @Override
    public void applyTransition(DigitalClock context) {
        context.setHours(context.getHours() + 1);
    }
    
}

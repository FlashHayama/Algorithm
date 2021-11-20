package tablestate.transitions;

import tablestate.DigitalClock;

public class SSTransition implements ITransition {

    @Override
    public void applyTransition(DigitalClock context) {
        context.setSeconds(context.getSeconds() + 1);
    }
    
}

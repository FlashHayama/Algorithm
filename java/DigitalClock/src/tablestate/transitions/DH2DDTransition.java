package tablestate.transitions;

import tablestate.DigitalClock;
import tablestate.states.ClockState;
import tablestate.states.DisplayDate;

/**
 * Represents the transition from the DisplayHour state to the DisplayDate state
 */
public class DH2DDTransition implements ITransition {

	@Override
	public void applyTransition(DigitalClock context) {
		ClockState state = new DisplayDate();
		context.switchTo(state);
	}

}

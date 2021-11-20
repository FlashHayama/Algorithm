package tablestate.transitions;

import tablestate.DigitalClock;
import tablestate.states.ClockState;
import tablestate.states.DisplaySecond;

/**
 * Represents the transition from the DisplayDate state to the DisplaySecond state
 */
public class DD2DSTransition implements ITransition {

	@Override
	public void applyTransition(DigitalClock context) {
		ClockState state = new DisplaySecond();
		context.switchTo(state);
	}

}

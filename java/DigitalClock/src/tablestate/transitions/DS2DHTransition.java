package tablestate.transitions;

import tablestate.DigitalClock;
import tablestate.states.ClockState;
import tablestate.states.DisplayHour;

/**
 * Represents the transition from the DisplaySecond state to the DisplayHour state
 */
public class DS2DHTransition implements ITransition {

	@Override
	public void applyTransition(DigitalClock context) {
		ClockState state = new DisplayHour();
		context.switchTo(state);
	}

}

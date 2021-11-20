package tablestate.transitions;

import tablestate.DigitalClock;

/**
 * Represents a transition of the clock
 */
public interface ITransition {
	void applyTransition(DigitalClock context);

}

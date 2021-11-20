package switchcase.states;

import switchcase.DigitalClock;

/**
 * Represents a state of the clock
 */
public abstract class ClockState {
	/**
	 * Returns the type of the state
	 * @return StateEnum the type of the state
	 */
	public abstract StateEnum getType();
	
	/**
	 * Reacts to the b1 event
	 * @param context the context in which the event occurred
	 */
	public abstract void b1(DigitalClock context);
	public abstract void b2(DigitalClock context);
	public abstract void b3(DigitalClock context);
}

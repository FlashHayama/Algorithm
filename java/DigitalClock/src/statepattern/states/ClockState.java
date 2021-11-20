package statepattern.states;

import statepattern.DigitalClock;

/**
 * Represents a state of the clock
 */
public interface ClockState {
	/**
	 * Returns the type of the state
	 * @return StateEnum the type of the state
	 */
	public StateEnum getType();
	
	/**
	 * Reacts to the b1 event
	 * @param context the context in which the event occurred
	 */
	public void b1(DigitalClock context);
	public void b2(DigitalClock context);
	public void b3(DigitalClock context);
	
}

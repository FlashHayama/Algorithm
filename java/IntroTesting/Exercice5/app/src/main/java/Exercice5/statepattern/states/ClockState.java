package Exercice5.statepattern.states;

import Exercice5.statepattern.DigitalClock;

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
	
	/**
	 * Reacts to the b2 event
	 * @param context the context in which the event occurred
	 */
	public void b2(DigitalClock context);
	
	/**
	 * Reacts to the b3 event
	 * @param context the context in which the event occurred
	 */
	public void b3(DigitalClock context);

	public void display(DigitalClock context);
}

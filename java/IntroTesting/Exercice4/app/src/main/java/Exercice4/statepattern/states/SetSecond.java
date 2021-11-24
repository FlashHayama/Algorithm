package Exercice4.statepattern.states;

import Exercice4.statepattern.DigitalClock;

/**
 * Represents the SetSecond state of the clock
 */
public class SetSecond implements ClockState {
	
	/**
	 * Returns the type of the state
	 * @return SET_SECOND the type of the state
	 */
	@Override
	public StateEnum getType() {
		return StateEnum.SET_SECOND;
	}
	
	/**
	 * Reacts to the b1 event
	 * The clock switches to SetHour state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b1(DigitalClock context) {
		ClockState state = new SetHour();
		context.switchTo(state);
	}
	
	/**
	 * Reacts to the b2 event
	 * The clock switches to SetDate state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b2(DigitalClock context) {
		ClockState state = new SetDate();
		context.switchTo(state);
	}
	
	/**
	 * Reacts to the b3 event
	 * The number of minutes is increased
	 * It goes back to 0 if it was 59 seconds
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b3(DigitalClock context) {
		context.increaseSeconds();
	}

	@Override
	public void display(DigitalClock context) {
		System.out.println("Time (edit mode): " + context.getMinutes() + ":" + context.getSeconds());
	}
}

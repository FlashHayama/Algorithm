package Exercice5.statepattern.states;

import Exercice5.statepattern.DigitalClock;

/**
 * Represents the DisplaySecond state of the clock
 */
public class DisplaySecond implements ClockState {
	
	/**
	 * Returns the type of the state
	 * @return DISPLAY_SECOND the type of the state
	 */
	@Override
	public StateEnum getType() {
		return StateEnum.DISPLAY_SECOND;
	}
	
	/**
	 * Reacts to the b1 event
	 * The clock switches to DisplayHour state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b1(DigitalClock context) {
		ClockState state = new DisplayHour();
		context.switchTo(state);
	}
	
	/**
	 * Reacts to the b2 event
	 * The clock switches to DisplayDate state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b2(DigitalClock context) {
		ClockState state = new DisplayDate();
		context.switchTo(state);
	}
	
	/**
	 * Reacts to the b3 event
	 * The clock switches to SetSecond state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b3(DigitalClock context) {
		ClockState state = new SetSecond();
		context.setTimeFreeze(true);
		context.switchTo(state);
	}

	@Override
	public void display(DigitalClock context) {
		System.out.println("Time: " + context.getMinutes() + ":" + context.getSeconds());
	}
	
}

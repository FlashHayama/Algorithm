package Exercice4.statepattern.states;

import Exercice4.statepattern.DigitalClock;

/**
 * Represents the SetHour state of the clock
 */
public class SetHour implements ClockState {

	/**
	 * Returns the type of the state
	 * @return SET_HOUR the type of the state
	 */
	@Override
	public StateEnum getType() {
		return StateEnum.SET_HOUR;
	}
	
	/**
	 * Reacts to the b1 event
	 * The clock switches to DisplayHour state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b1(DigitalClock context) {
		ClockState state = new DisplayHour();
		context.setTimeFreeze(false);
		context.switchTo(state);
	}
	
	/**
	 * Reacts to the b2 event
	 * The clock switches to SetSecond state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b2(DigitalClock context) {
		ClockState state = new SetSecond();
		context.switchTo(state);
	}
	
	/**
	 * Reacts to the b3 event
	 * The number of minutes is increased
	 * It goes back to 0 if it was 59 seconds and hour is increased
	 * If hour was 23, hour goes back to 0
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b3(DigitalClock context) {
		context.increaseMinutes();
	}

	@Override
	public void display(DigitalClock context) {
		System.out.println("Hour (edit mode): " + context.getHours() + ":" + context.getMinutes());
	}

}

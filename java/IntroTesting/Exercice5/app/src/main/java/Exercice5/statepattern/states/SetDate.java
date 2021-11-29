package Exercice5.statepattern.states;

import Exercice5.statepattern.DigitalClock;

/**
 * Represents the SetDate state of the clock
 */
public class SetDate implements ClockState {
	
	/**
	 * Returns the type of the state
	 * @return SET_DATE the type of the state
	 */
	@Override
	public StateEnum getType() {
		return StateEnum.SET_DATE;
	}
	
	/**
	 * Reacts to the b1 event
	 * The clock switches to SetSecond state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b1(DigitalClock context) {
		ClockState state = new SetSecond();
		context.switchTo(state);
	}
	
	/**
	 * Reacts to the b2 event
	 * The clock switches to DisplayDate state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b2(DigitalClock context) {
		ClockState state = new DisplayHour();
		context.setTimeFreeze(false);
		context.switchTo(state);
	}
	
	/**
	 * Reacts to the b3 event
	 * The day of the month is increased
	 * If it was the last day, day becomes 1 and month is increased
	 * month goes back to 1 if it was 12
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b3(DigitalClock context) {
		context.increaseDayInMonth();
	}

	@Override
	public void display(DigitalClock context) {
		System.out.println("Date (edit mode): " + context.getDayInMonth() + " / " + context.getMonth());
	}

}

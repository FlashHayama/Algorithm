package statepattern.states;

import statepattern.DigitalClock;

/**
 * Represents the DisplayDate state of the clock
 */
public class DisplayDate implements ClockState {
	
	/**
	 * Returns the type of the state
	 * @return DISPLAY_DATE the type of the state
	 */
	@Override
	public StateEnum getType() {
		return StateEnum.DISPLAY_DATE;
	}
	
	/**
	 * Reacts to the b1 event
	 * The clock switches to DisplaySecond state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b1(DigitalClock context) {
		ClockState state = new DisplaySecond();
		context.switchTo(state);
	}

	@Override
	public void b2(DigitalClock context) {
		ClockState state = new DisplayHour();
		context.switchTo(state);
	}

	@Override
	public void b3(DigitalClock context) {
		ClockState state = new SetDate();
		context.switchTo(state);
	}

}
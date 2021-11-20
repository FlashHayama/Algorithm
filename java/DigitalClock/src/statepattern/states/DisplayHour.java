package statepattern.states;

import statepattern.DigitalClock;

/**
 * Represents the DisplayHour state of the clock
 */
public class DisplayHour implements ClockState {

	/**
	 * Returns the type of the state
	 * @return DISPLAY_HOUR the type of the state
	 */
	@Override
	public StateEnum getType() {
		return StateEnum.DISPLAY_HOUR;
	}
	
	/**
	 * Reacts to the b1 event
	 * The clock switches to DisplayDate state
	 * @param context the context in which the event occurred
	 */
	@Override
	public void b1(DigitalClock context) {
		ClockState state = new DisplayDate();
		context.switchTo(state);
	}
	@Override
	public void b2(DigitalClock context) {
		ClockState state = new DisplaySecond();
		context.switchTo(state);
	}

	@Override
	public void b3(DigitalClock context) {
		ClockState state = new SetHour();
		context.switchTo(state);
	}

}

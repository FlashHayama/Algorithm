package switchcase.states;

import switchcase.DigitalClock;

/**
 * Represents the DisplayHour state of the clock
 */
public class DisplayHour extends ClockState {
	
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
		context.setState(StateEnum.DISPLAY_DATE);
	}
	@Override
	public void b2(DigitalClock context) { context.setState(StateEnum.DISPLAY_SECOND); }

	@Override
	public void b3(DigitalClock context) { context.setState(StateEnum.SET_HOUR);}

}

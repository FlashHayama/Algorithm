package switchcase.states;

import switchcase.DigitalClock;

/**
 * Represents the DisplayDate state of the clock
 */
public class DisplayDate extends ClockState {
	
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
		context.setState(StateEnum.DISPLAY_SECOND);
	}

	@Override
	public void b2(DigitalClock context) { context.setState(StateEnum.DISPLAY_HOUR); }

	@Override
	public void b3(DigitalClock context) { context.setState(StateEnum.SET_DATE);}

}

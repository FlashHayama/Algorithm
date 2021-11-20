package switchcase.states;

import switchcase.DigitalClock;

/**
 * Represents the DisplaySecond state of the clock
 */
public class DisplaySecond extends ClockState {
	
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
		context.setState(StateEnum.DISPLAY_HOUR);
	}
	@Override
	public void b2(DigitalClock context) { context.setState(StateEnum.DISPLAY_DATE); }

	@Override
	public void b3(DigitalClock context) { context.setState(StateEnum.SET_SECONDS);	}
	
}

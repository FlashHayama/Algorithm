package tablestate.states;

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
	
}

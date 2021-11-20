package tablestate.states;

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
}

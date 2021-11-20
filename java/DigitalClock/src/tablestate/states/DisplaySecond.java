package tablestate.states;

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
	
}

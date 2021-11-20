package switchcase;

import switchcase.states.*;

/**
 *  Represents the clock and its context
 */
public class DigitalClock {
	
	/**
	 * Time of the clock
	 */
	private	int	hours, minutes, seconds, dayInMonth, month; 
	
	/**
	 * Current state of the clock
	 */
	private ClockState currentState;
	
	/**
	 * Constructor
	 */
	public DigitalClock() {
		ClockState state = new DisplayHour();
		switchTo(state);
		setHours(0);
		setMinutes(0);
		setSeconds(0);
		setDayInMonth(1);
		setMonth(1);
	}
	
	/**
	 * 
	 * @param nextState the new state
	 */
	public void switchTo(ClockState nextState) {
		currentState = nextState;
	}
	
	/**
	 * Returns the enum type corresponding to the current state
	 * @return state
	 */
	public StateEnum getState() {
		return this.currentState.getType();
	}
	
	/**
	 * Reacts to the b1 event
	 */
	public void b1() { this.currentState.b1(this); }
	public void b2() { this.currentState.b2(this); }
	public void b3() { this.currentState.b3(this); }
	
	/**
	 * Sets the state to the given enum type
	 */
	public void setState(StateEnum state)
	{
		ClockState stateInstance = null;
		switch (state)
		{
			case DISPLAY_DATE:
				stateInstance = new DisplayDate();
				break;
			case DISPLAY_HOUR:
				stateInstance = new DisplayHour();
				break;
			case DISPLAY_SECOND:
				stateInstance = new DisplaySecond();
				break;
			case SET_DATE:
				stateInstance = new SetDate();
				break;
			case SET_HOUR:
				stateInstance = new SetHour();
				break;
			case SET_SECONDS:
				stateInstance = new SetSeconds();
				break;
			default:
				// This cannot happen
				break;
		}
		this.switchTo(stateInstance);
	}

	public void playEvent(EventEnum event){
		switch(event) 
		{
			case SET_DATE:
				this.setDayInMonth(this.getDayInMonth() + 1);
				break;
			case SET_HOUR:
				this.setHours(this.getHours() + 1);
				break;
			case SET_SECONDS:
				this.setSeconds(this.getSeconds() + 1);
				break;
			default:
				break;
		}
	}
	
	/**
	 * @return hours the hour
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @return minutes the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @return seconds the seconds
	 */
	public int getSeconds() {
		return seconds;
	}
	
	/**
	 * @return dayInMonth the day in the current month (starting from 1)
	 */
	public int getDayInMonth() {
		return dayInMonth;
	}
	
	/**
	 * @return month the number of the month (starting from 1)
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param hours the hour (0 to 23)
	 */
	public void setHours(int hours) {
		if (hours < 0 || hours > 23)
			hours = 0;
		this.hours = hours;
	}

	/**
	 * @param minutes the minutes (0 to 59)
	 */
	public void setMinutes(int minutes) {
		if (minutes < 0 || minutes > 59)
			minutes = 0;
		this.minutes = minutes;
	}
	
	/**
	 * @param seconds the seconds (0 to 59)
	 */
	public void setSeconds(int seconds) {
		if (seconds < 0 || seconds > 59)
			seconds = 0;
		this.seconds = seconds;
	}
	
	/**
	 * The value should not be bigger than the last day of the month.
	 * @param dayInMonth the day of the month (1 to last day of the month)
	 */
	public void setDayInMonth(int dayInMonth) {
		if (dayInMonth < 1 || dayExceedsLast())
			dayInMonth = 1;
		this.dayInMonth = dayInMonth;
	}
	
	/**
	 * @param month the month (1 to 12)
	 */
	public void setMonth(int month) {
		if (month < 1 || month > 12)
			month = 1;
		this.month = month;
	}
	
	/**
	 * Checks either the given day is the last day of the month
	 * @return true if day is the last day of month, false otherwise
	 */
	private boolean dayExceedsLast() {
		// February has 28 days (leap years not handled)
		if (dayInMonth >= 28 && month == 2)
			return true;
		else if (dayInMonth >= 30 && ((month % 2 == 0 && month < 7) || month % 2 == 1 && month > 8))
			return true;
		else if (dayInMonth >= 31)
			return true;
		else 
			return false;
	}
	
}

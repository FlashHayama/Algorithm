package tablestate;

import tablestate.events.EventEnum;
import tablestate.states.*;
import tablestate.transitions.*;

/**
 * Represents the clock and its context
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
	 * Transition table
	 */
	private ITransition[][] transitionTable = {
			// Current state: DISPLAY_DATE
			{
				new DD2DSTransition(), // Event b1
				new DD2DHTransition(), // Event b2
				new DD2SDTransition()  // Event b3
			},
			// Current state: DISPLAY_HOUR
			{
				new DH2DDTransition(), // Event b1
				new DH2DSTransition(), // Event b2
				new DH2SHTransition()  // Event b3
			},
			// Current state: DISPLAY_SECOND
			{
				new DS2DHTransition(), // Event b1
				new DS2DDTransition(), // Event b2
				new DS2SSTransition()  // Event b3
			},
			// Current state: SET_DATE
			{
				new SD2SSTransition(), // Event b1
				new SD2DDTransition(), // Event b2
				new SDTransition()	   // Event b3
			},
			// Current state: SET_HOUR
			{
				new SH2DHTransition(), // Event b1
				new SH2SSTransition(), // Event b2
				new SHTransition()     // Event b3
			},
			// Current state: SET_SECONDS
			{
				new SS2SHTransition(), // Event b1
				new SS2SDTransition(), // Event b2
				new SSTransition()     // Event b3
			}
	};
	
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
	public void b1() { transitionTable[currentState.getType().ordinal()][EventEnum.B1.ordinal()].applyTransition(this); }
	public void b2() { transitionTable[currentState.getType().ordinal()][EventEnum.B2.ordinal()].applyTransition(this); }
	public void b3() { transitionTable[currentState.getType().ordinal()][EventEnum.B3.ordinal()].applyTransition(this); }
	
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
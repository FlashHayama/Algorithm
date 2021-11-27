package Exercice5.statepattern;

import Exercice5.App;
import Exercice5.statepattern.states.ClockState;
import Exercice5.statepattern.states.DisplayHour;
import Exercice5.statepattern.states.StateEnum;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Represents the clock and its context
 */
public class DigitalClock {
	/**
	 * Time of the clock
	 */
	private	int	hours, minutes, seconds, dayInMonth, month;
	private boolean timeFreeze;

	private final ScheduledExecutorService timeScheduler = Executors.newScheduledThreadPool(1);
	
	/**
	 * Current state of the clock
	 */
	private ClockState currentState;
	
	/**
	 * Constructor
	 */
	public DigitalClock(App app) {
		ClockState state = new DisplayHour();
		switchTo(state);
		setHours(0);
		setMinutes(59);
		setSeconds(55);
		setDayInMonth(1);
		setMonth(1);
		timeFreeze = false;
		timeScheduler.scheduleAtFixedRate(() -> {
			updateDisplay(app);
			if (!timeFreeze)
				increaseSeconds();
		}, 1, 1, SECONDS);

	}

	public void updateDisplay(App app){
		display();
		app.getT1().setText(getHours() + ":" + getMinutes() + ":" + getSeconds());
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
	public void b1() {
		this.currentState.b1(this);
	}
	
	/**
	 * Reacts to the b2 event
	 */
	public void b2() {
		this.currentState.b2(this);
	}
	
	/**
	 * Reacts to the b3 event
	 */
	public void b3() {
		this.currentState.b3(this);
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

	public void setTimeFreeze(boolean timeFreeze) {
		this.timeFreeze = timeFreeze;
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
	
	/**
	 * Increments the day of the month
	 * If the day exceed the last day of the month,
	 * the month is increased and dayInMonth is set to 1
	 */
	public void increaseDayInMonth() {
		// If it's the last day of the month, we change month
		if (dayExceedsLast()) {
			this.setDayInMonth(1);
			this.increaseMonth();
		}
		// Else, if it's not the last day and we simply increment
		else {
			this.setDayInMonth(this.getDayInMonth()+1);
		}
	}

	/**
	 * Increments minutes if it does not exceed 59
	 * Otherwise, minutes is set to 0
	 */
	public void increaseMinutes() {
		if (this.getMinutes() >= 59) {
			this.setMinutes(0);
			this.increaseHours();
		}
		else {
			this.setMinutes(this.getMinutes()+1);
		}
	}
	
	/**
	 * Increments seconds if it does not exceed 59
	 * Otherwise, seconds is set to 0
	 */
	public void increaseSeconds() {
		if (this.getSeconds() >= 59) {
			this.setSeconds(0);
			this.increaseMinutes();
		} else {
			this.setSeconds(this.getSeconds()+1);
		}
	}
	
	/**
	 * Increments the month
	 * If month should exceed 12, it gets back to 1
	 */
	public void increaseMonth() {
		if (this.getMonth() >= 12)
			this.setMonth(1);
		else
			this.setMonth(this.getMonth()+1);
	}
	
	/**
	 * Increments hours if it does not exceed 23
	 * Otherwise, hours is set to 0
	 */
	public void increaseHours() {
		if (this.getHours() >= 23) {
			this.setHours(0);
			this.increaseDayInMonth();
		} else {
			this.setHours(this.getHours()+1);
		}
	}

	public void display() {
		currentState.display(DigitalClock.this);
	}

}

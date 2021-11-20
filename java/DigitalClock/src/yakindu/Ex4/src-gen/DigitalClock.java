/** Generated by YAKINDU Statechart Tools code generator. */

import com.yakindu.core.IStatemachine;
import java.util.LinkedList;
import java.util.Queue;

public class DigitalClock implements IStatemachine {
	public enum State {
		MAIN_REGION_DISPLAYHOUR,
		MAIN_REGION_DISPLAYSECOND,
		MAIN_REGION_DISPLAYDATE,
		MAIN_REGION_SETHOUR,
		MAIN_REGION_SETSECONDS,
		MAIN_REGION_SETDATE,
		$NULLSTATE$
	};
	
	private final State[] stateVector = new State[1];
	
	private Queue<Runnable> inEventQueue = new LinkedList<Runnable>();
	private boolean isExecuting;
	
	protected boolean getIsExecuting() {
		return isExecuting;
	}
	
	protected void setIsExecuting(boolean value) {
		this.isExecuting = value;
	}
	public DigitalClock() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NULLSTATE$;
		}
		
		clearInEvents();
		
		setHours(0);
		
		setMinutes(0);
		
		setSeconds(0);
		
		setDayInMonth(0);
		
		setMonth(0);
		
		isExecuting = false;
	}
	
	public void enter() {
		
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		
		enterSequence_main_region_default();
		isExecuting = false;
	}
	
	public void exit() {
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		
		exitSequence_main_region();
		isExecuting = false;
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NULLSTATE$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	private void clearInEvents() {
		b1 = false;
		b2 = false;
		b3 = false;
	}
	
	private void microStep() {
		switch (stateVector[0]) {
		case MAIN_REGION_DISPLAYHOUR:
			main_region_DisplayHour_react(-1);
			break;
		case MAIN_REGION_DISPLAYSECOND:
			main_region_DisplaySecond_react(-1);
			break;
		case MAIN_REGION_DISPLAYDATE:
			main_region_DisplayDate_react(-1);
			break;
		case MAIN_REGION_SETHOUR:
			main_region_SetHour_react(-1);
			break;
		case MAIN_REGION_SETSECONDS:
			main_region_SetSeconds_react(-1);
			break;
		case MAIN_REGION_SETDATE:
			main_region_SetDate_react(-1);
			break;
		default:
			break;
		}
	}
	
	private void runCycle() {
		
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		
		nextEvent();
		do { 
			microStep();
			
			clearInEvents();
			
			nextEvent();
		} while (((b1 || b2) || b3));
		
		isExecuting = false;
	}
	
	protected void nextEvent() {
		if(!inEventQueue.isEmpty()) {
			inEventQueue.poll().run();
			return;
		}
	}
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case MAIN_REGION_DISPLAYHOUR:
			return stateVector[0] == State.MAIN_REGION_DISPLAYHOUR;
		case MAIN_REGION_DISPLAYSECOND:
			return stateVector[0] == State.MAIN_REGION_DISPLAYSECOND;
		case MAIN_REGION_DISPLAYDATE:
			return stateVector[0] == State.MAIN_REGION_DISPLAYDATE;
		case MAIN_REGION_SETHOUR:
			return stateVector[0] == State.MAIN_REGION_SETHOUR;
		case MAIN_REGION_SETSECONDS:
			return stateVector[0] == State.MAIN_REGION_SETSECONDS;
		case MAIN_REGION_SETDATE:
			return stateVector[0] == State.MAIN_REGION_SETDATE;
		default:
			return false;
		}
	}
	
	
	private boolean b1;
	
	
	public void raiseB1() {
		inEventQueue.add(() -> {
			b1 = true;
		});
		runCycle();
	}
	
	private boolean b2;
	
	
	public void raiseB2() {
		inEventQueue.add(() -> {
			b2 = true;
		});
		runCycle();
	}
	
	private boolean b3;
	
	
	public void raiseB3() {
		inEventQueue.add(() -> {
			b3 = true;
		});
		runCycle();
	}
	
	private long hours;
	
	public long getHours() {
		return hours;
	}
	
	public void setHours(long value) {
		this.hours = value;
	}
	
	private long minutes;
	
	public long getMinutes() {
		return minutes;
	}
	
	public void setMinutes(long value) {
		this.minutes = value;
	}
	
	private long seconds;
	
	public long getSeconds() {
		return seconds;
	}
	
	public void setSeconds(long value) {
		this.seconds = value;
	}
	
	private long dayInMonth;
	
	public long getDayInMonth() {
		return dayInMonth;
	}
	
	public void setDayInMonth(long value) {
		this.dayInMonth = value;
	}
	
	private long month;
	
	public long getMonth() {
		return month;
	}
	
	public void setMonth(long value) {
		this.month = value;
	}
	
	/* 'default' enter sequence for state DisplayHour */
	private void enterSequence_main_region_DisplayHour_default() {
		stateVector[0] = State.MAIN_REGION_DISPLAYHOUR;
	}
	
	/* 'default' enter sequence for state DisplaySecond */
	private void enterSequence_main_region_DisplaySecond_default() {
		stateVector[0] = State.MAIN_REGION_DISPLAYSECOND;
	}
	
	/* 'default' enter sequence for state DisplayDate */
	private void enterSequence_main_region_DisplayDate_default() {
		stateVector[0] = State.MAIN_REGION_DISPLAYDATE;
	}
	
	/* 'default' enter sequence for state SetHour */
	private void enterSequence_main_region_SetHour_default() {
		stateVector[0] = State.MAIN_REGION_SETHOUR;
	}
	
	/* 'default' enter sequence for state SetSeconds */
	private void enterSequence_main_region_SetSeconds_default() {
		stateVector[0] = State.MAIN_REGION_SETSECONDS;
	}
	
	/* 'default' enter sequence for state SetDate */
	private void enterSequence_main_region_SetDate_default() {
		stateVector[0] = State.MAIN_REGION_SETDATE;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state DisplayHour */
	private void exitSequence_main_region_DisplayHour() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state DisplaySecond */
	private void exitSequence_main_region_DisplaySecond() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state DisplayDate */
	private void exitSequence_main_region_DisplayDate() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state SetHour */
	private void exitSequence_main_region_SetHour() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state SetSeconds */
	private void exitSequence_main_region_SetSeconds() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for state SetDate */
	private void exitSequence_main_region_SetDate() {
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case MAIN_REGION_DISPLAYHOUR:
			exitSequence_main_region_DisplayHour();
			break;
		case MAIN_REGION_DISPLAYSECOND:
			exitSequence_main_region_DisplaySecond();
			break;
		case MAIN_REGION_DISPLAYDATE:
			exitSequence_main_region_DisplayDate();
			break;
		case MAIN_REGION_SETHOUR:
			exitSequence_main_region_SetHour();
			break;
		case MAIN_REGION_SETSECONDS:
			exitSequence_main_region_SetSeconds();
			break;
		case MAIN_REGION_SETDATE:
			exitSequence_main_region_SetDate();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_DisplayHour_default();
	}
	
	private long react(long transitioned_before) {
		return transitioned_before;
	}
	
	private long main_region_DisplayHour_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0) {
			if (b1) {
				exitSequence_main_region_DisplayHour();
				enterSequence_main_region_DisplayDate_default();
				react(0);
				
				transitioned_after = 0;
			} else {
				if (b2) {
					exitSequence_main_region_DisplayHour();
					enterSequence_main_region_DisplaySecond_default();
					react(0);
					
					transitioned_after = 0;
				} else {
					if (b3) {
						exitSequence_main_region_DisplayHour();
						enterSequence_main_region_SetHour_default();
						react(0);
						
						transitioned_after = 0;
					}
				}
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long main_region_DisplaySecond_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0) {
			if (b1) {
				exitSequence_main_region_DisplaySecond();
				enterSequence_main_region_DisplayHour_default();
				react(0);
				
				transitioned_after = 0;
			} else {
				if (b2) {
					exitSequence_main_region_DisplaySecond();
					enterSequence_main_region_DisplayDate_default();
					react(0);
					
					transitioned_after = 0;
				} else {
					if (b3) {
						exitSequence_main_region_DisplaySecond();
						enterSequence_main_region_SetSeconds_default();
						react(0);
						
						transitioned_after = 0;
					}
				}
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long main_region_DisplayDate_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0) {
			if (b1) {
				exitSequence_main_region_DisplayDate();
				enterSequence_main_region_DisplaySecond_default();
				react(0);
				
				transitioned_after = 0;
			} else {
				if (b2) {
					exitSequence_main_region_DisplayDate();
					enterSequence_main_region_DisplayHour_default();
					react(0);
					
					transitioned_after = 0;
				} else {
					if (b3) {
						exitSequence_main_region_DisplayDate();
						enterSequence_main_region_SetDate_default();
						react(0);
						
						transitioned_after = 0;
					}
				}
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long main_region_SetHour_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0) {
			if (b1) {
				exitSequence_main_region_SetHour();
				enterSequence_main_region_DisplayHour_default();
				react(0);
				
				transitioned_after = 0;
			} else {
				if (b2) {
					exitSequence_main_region_SetHour();
					enterSequence_main_region_SetSeconds_default();
					react(0);
					
					transitioned_after = 0;
				} else {
					if (b3) {
						exitSequence_main_region_SetHour();
						setHours((hours + 1));
						
						enterSequence_main_region_SetHour_default();
						react(0);
						
						transitioned_after = 0;
					}
				}
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long main_region_SetSeconds_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0) {
			if (b1) {
				exitSequence_main_region_SetSeconds();
				enterSequence_main_region_SetHour_default();
				react(0);
				
				transitioned_after = 0;
			} else {
				if (b2) {
					exitSequence_main_region_SetSeconds();
					enterSequence_main_region_SetDate_default();
					react(0);
					
					transitioned_after = 0;
				} else {
					if (b3) {
						exitSequence_main_region_SetSeconds();
						setSeconds(getSeconds() + 1);
						
						enterSequence_main_region_SetSeconds_default();
						react(0);
						
						transitioned_after = 0;
					}
				}
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
	private long main_region_SetDate_react(long transitioned_before) {
		long transitioned_after = transitioned_before;
		
		if (transitioned_after<0) {
			if (b2) {
				exitSequence_main_region_SetDate();
				enterSequence_main_region_DisplayDate_default();
				react(0);
				
				transitioned_after = 0;
			} else {
				if (b1) {
					exitSequence_main_region_SetDate();
					enterSequence_main_region_SetSeconds_default();
					react(0);
					
					transitioned_after = 0;
				} else {
					if (b3) {
						exitSequence_main_region_SetDate();
						setDayInMonth(getDayInMonth() + 1);
						
						enterSequence_main_region_SetDate_default();
						react(0);
						
						transitioned_after = 0;
					}
				}
			}
		}
		/* If no transition was taken then execute local reactions */
		if (transitioned_after==transitioned_before) {
			transitioned_after = react(transitioned_before);
		}
		return transitioned_after;
	}
	
}

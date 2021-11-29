package Exercice5.statepattern.states;

/**
 * Enumeration used to know which state the clock is in
 */
public enum StateEnum {
	DISPLAY_DATE,
	DISPLAY_HOUR,
	DISPLAY_SECOND,
	SET_HOUR,
	SET_SECOND,
	SET_DATE
}

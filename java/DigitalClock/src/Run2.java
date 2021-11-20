public class Run2 {

	public static void main(String[] args) {
		System.out.println("Digital Clock with State Design Pattern");
		statepattern.DigitalClock dcStatePattern = new statepattern.DigitalClock();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in DISPLAY_HOUR
		
		dcStatePattern.b1();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in DISPLAY_DATE
		dcStatePattern.b1();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in DISPLAY_SECOND
		dcStatePattern.b1();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in DISPLAY_HOUR
		dcStatePattern.b2();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in DISPLAY_SECOND
		dcStatePattern.b2();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in DISPLAY_DATE
		dcStatePattern.b2();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in DISPLAY_HOUR
		
		System.out.println("===============================================");
		
		System.out.println("Digital Clock with Procedural Implementation");
		switchcase.DigitalClock dcSwitchCase = new switchcase.DigitalClock();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in DISPLAY_HOUR
		
		dcSwitchCase.b1();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in DISPLAY_DATE
		dcSwitchCase.b1();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in DISPLAY_SECOND
		dcSwitchCase.b1();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in DISPLAY_HOUR
		dcSwitchCase.b2();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in DISPLAY_SECOND
		dcSwitchCase.b2();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in DISPLAY_DATE
		dcSwitchCase.b2();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in DISPLAY_HOUR
		
		System.out.println("===============================================");
		
		System.out.println("Digital Clock with State Table");
		tablestate.DigitalClock dcTable = new tablestate.DigitalClock();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in DISPLAY_HOUR
		
		dcTable.b1();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in DISPLAY_DATE
		dcTable.b1();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in DISPLAY_SECOND
		dcTable.b1();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in DISPLAY_HOUR
		dcTable.b2();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in DISPLAY_SECOND
		dcTable.b2();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in DISPLAY_DATE
		dcTable.b2();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in DISPLAY_HOUR
	}

}

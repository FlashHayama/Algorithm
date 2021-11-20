public class Run3 {

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
		dcStatePattern.b3();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in SET_HOUR
		System.out.println("Date is " + dcStatePattern.getDayInMonth() + "/" + dcStatePattern.getMonth()); // Should be 1/1
		System.out.println("Time is " + dcStatePattern.getHours() + ":" + dcStatePattern.getMinutes() + ":" + dcStatePattern.getSeconds()); // Should be 0:0:0
		dcStatePattern.b3();
		System.out.println("Time is " + dcStatePattern.getHours() + ":" + dcStatePattern.getMinutes() + ":" + dcStatePattern.getSeconds()); // Should be 0:1:0
		for (int i = 0; i<58; i++) {
			dcStatePattern.b3();
		}
		System.out.println("Time is " + dcStatePattern.getHours() + ":" + dcStatePattern.getMinutes() + ":" + dcStatePattern.getSeconds()); // Should be 0:59:0
		dcStatePattern.b3();
		System.out.println("Time is " + dcStatePattern.getHours() + ":" + dcStatePattern.getMinutes() + ":" + dcStatePattern.getSeconds()); // Should be 1:0:0
		dcStatePattern.b2();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in SET_SECOND
		dcStatePattern.b3();
		System.out.println("Time is " + dcStatePattern.getHours() + ":" + dcStatePattern.getMinutes() + ":" + dcStatePattern.getSeconds()); // Should be 1:0:1
		dcStatePattern.b2();
		System.out.println("The clock is now in state " + dcStatePattern.getState()); // Should be in SET_DATE
		dcStatePattern.b3();
		System.out.println("Date is " + dcStatePattern.getDayInMonth() + "/" + dcStatePattern.getMonth()); // Should be 2/1
		for (int i = 0; i < 30; i++) {
			dcStatePattern.b3();
		}
		System.out.println("Date is " + dcStatePattern.getDayInMonth() + "/" + dcStatePattern.getMonth()); // Should be 1/2
		
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
		dcSwitchCase.b3();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in SET_HOUR
		System.out.println("Date is " + dcSwitchCase.getDayInMonth() + "/" + dcSwitchCase.getMonth()); // Should be 1/1
		System.out.println("Time is " + dcSwitchCase.getHours() + ":" + dcSwitchCase.getMinutes() + ":" + dcSwitchCase.getSeconds()); // Should be 0:0:0
		dcSwitchCase.b3();
		System.out.println("Time is " + dcSwitchCase.getHours() + ":" + dcSwitchCase.getMinutes() + ":" + dcSwitchCase.getSeconds()); // Should be 0:1:0
		for (int i = 0; i<58; i++) {
			dcSwitchCase.b3();
		}
		System.out.println("Time is " + dcSwitchCase.getHours() + ":" + dcSwitchCase.getMinutes() + ":" + dcSwitchCase.getSeconds()); // Should be 0:59:0
		dcSwitchCase.b3();
		System.out.println("Time is " + dcSwitchCase.getHours() + ":" + dcSwitchCase.getMinutes() + ":" + dcSwitchCase.getSeconds()); // Should be 1:0:0
		dcSwitchCase.b2();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in SET_SECOND
		dcSwitchCase.b3();
		System.out.println("Time is " + dcSwitchCase.getHours() + ":" + dcSwitchCase.getMinutes() + ":" + dcSwitchCase.getSeconds()); // Should be 1:0:1
		dcSwitchCase.b2();
		System.out.println("The clock is now in state " + dcSwitchCase.getState()); // Should be in SET_DATE
		dcSwitchCase.b3();
		System.out.println("Date is " + dcSwitchCase.getDayInMonth() + "/" + dcSwitchCase.getMonth()); // Should be 2/1
		for (int i = 0; i < 30; i++) {
			dcSwitchCase.b3();
		}
		System.out.println("Date is " + dcSwitchCase.getDayInMonth() + "/" + dcSwitchCase.getMonth()); // Should be 1/2
		
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
		dcTable.b3();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in SET_HOUR
		System.out.println("Date is " + dcTable.getDayInMonth() + "/" + dcTable.getMonth()); // Should be 1/1
		System.out.println("Time is " + dcTable.getHours() + ":" + dcTable.getMinutes() + ":" + dcTable.getSeconds()); // Should be 0:0:0
		dcTable.b3();
		System.out.println("Time is " + dcTable.getHours() + ":" + dcTable.getMinutes() + ":" + dcTable.getSeconds()); // Should be 0:1:0
		for (int i = 0; i<58; i++) {
			dcTable.b3();
		}
		System.out.println("Time is " + dcTable.getHours() + ":" + dcTable.getMinutes() + ":" + dcTable.getSeconds()); // Should be 0:59:0
		dcTable.b3();
		System.out.println("Time is " + dcTable.getHours() + ":" + dcTable.getMinutes() + ":" + dcTable.getSeconds()); // Should be 1:0:0
		dcTable.b2();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in SET_SECOND
		dcTable.b3();
		System.out.println("Time is " + dcTable.getHours() + ":" + dcTable.getMinutes() + ":" + dcTable.getSeconds()); // Should be 1:0:1
		dcTable.b2();
		System.out.println("The clock is now in state " + dcTable.getState()); // Should be in SET_DATE
		dcTable.b3();
		System.out.println("Date is " + dcTable.getDayInMonth() + "/" + dcTable.getMonth()); // Should be 2/1
		for (int i = 0; i < 30; i++) {
			dcTable.b3();
		}
		System.out.println("Date is " + dcTable.getDayInMonth() + "/" + dcTable.getMonth()); // Should be 1/2
	}

}

package calendar;
class Main {
    public static void main(String args[]) {
        CalendarView v =
            new CalendarView ( " Local copy of Tom's calendar " );
        MyCalendar cal = new MyCalendar (v , " Tom's calendar " );
        BirthdayView b = new BirthdayView("Birthdays");
        try {
	        cal.attach(b);
	        cal.addEvent (
	            new Event ( EventType.Birthday , " John " , 11 , 12 , 2016));
	        cal.addEvent (
	            new Event ( EventType.Personal , " Vacances " , 28 , 1 , 2017));
	        cal.addEvent (
	            new Event ( EventType.Work , " Meeting " , 24 , 1 , 2017));
	        v.printAll ();
	        b.printAll();
        }
        catch (MaximalSizeException e) {
        	e.printStackTrace();
        }

    }
}

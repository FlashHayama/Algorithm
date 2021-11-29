package calendar;
class Main {
    public static void main(String args[]){
        CalendarView v =
            new CalendarView ( " Local copy of Tom's calendar " );
        MyCalendar cal;
        cal = new MyCalendar (v , " Tom's calendar " );
        cal.addEvent (
            new Event ( EventType.Birthday , " John " , 11 , 11 , 2021));
        cal.addEvent (
            new Event ( EventType.Personal , " Vacances " , 28 , 1 , 2017));
        cal.addEvent (
            new Event ( EventType.Work , " Meeting " , 24 , 1 , 2017));
        v.printAll ();

    }
}

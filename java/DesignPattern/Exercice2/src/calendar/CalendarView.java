package calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class CalendarView implements Observer {
    protected ArrayList < IEvent > eventsList ;
    private String name ;
    public CalendarView ( String viewName ) {
        name = viewName ;
        eventsList = new ArrayList < IEvent >();
    }
    public ArrayList < IEvent > getEvents () {
        return eventsList ;
    }
    public void updateAll ( ArrayList < IEvent > l ) {
        eventsList.addAll ( l );
    }
    public void updateAdded ( Subject c , IEvent e ) {
        eventsList.add ( e );
    }
    public void updateRemoved ( Subject c , IEvent e ) {
        eventsList.remove ( e );
    }
    public void printAll () {
        System.out.println ( "Printing current month of " + name );
        Calendar today = new GregorianCalendar ();
        for ( IEvent e : eventsList )
            if ( e.getDate (). get ( Calendar.MONTH ) == today.get ( Calendar.MONTH ) && e.getDate (). get ( Calendar.YEAR ) == today.get ( Calendar.YEAR )) {
                System.out.println ( e );
            }
    }
}

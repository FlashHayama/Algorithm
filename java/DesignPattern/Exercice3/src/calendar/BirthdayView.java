package calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class BirthdayView implements Observer {
    protected ArrayList < Event > eventsList ;
    private String name ;
    public BirthdayView ( String viewName ) {
        name = viewName ;
        eventsList = new ArrayList < Event >();
    }
    public ArrayList < Event > getEvents () {
        return eventsList ;
    }
    public void updateAll ( ArrayList < Event > l ) {
    	for (Event e: l) {
    		if (e.getType() == EventType.Birthday) {
    			eventsList.add(e);
    		}
    	}
    }
    public void updateAdded ( Subject c , Event e ) {
        if (e.getType() == EventType.Birthday) {
        	eventsList.add(e);
        }
    }
    public void updateRemoved ( Subject c , Event e ) {
        eventsList.remove ( e );
    }
    public void printAll () {
        System.out.println ( "Printing current month of " + name );
        Calendar today = new GregorianCalendar ();
        for ( Event e : eventsList )
            if ( e.getDate (). get ( Calendar.MONTH ) == today.get ( Calendar.MONTH ) && e.getDate (). get ( Calendar.YEAR ) == today.get ( Calendar.YEAR )) {
                System.out.println ( e );
            }
    }
}

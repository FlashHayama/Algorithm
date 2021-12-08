package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BirthdayView implements Observer {
    protected ArrayList < EventBirthday > eventsList ;
    private String name ;

    public BirthdayView ( String viewName ) {
        name = viewName ;
        eventsList = new ArrayList < EventBirthday >();
    }

    @Override
    public void updateAll(ArrayList<IEvent> l) {
        for ( IEvent e : l ) {
            if (e instanceof BirthdayView){
                EventBirthday event = (EventBirthday)e;
                eventsList.add ( event );
            }
            else
            {
                System.out.println("Event " + e.getName() + " can't add in this observer");
            }
        }
    }

    @Override
    public void updateAdded(Subject s, IEvent e) {
        if (e instanceof BirthdayView){
            EventBirthday event = (EventBirthday)e;
            eventsList.add ( event );
        }
        else
        {
            System.out.println("Event " + e.getName() + " can't add in this observer");
        }
    }

    @Override
    public void updateRemoved(Subject s, IEvent e) {
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

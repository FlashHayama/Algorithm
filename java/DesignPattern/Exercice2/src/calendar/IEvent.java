package calendar;

import java.util.GregorianCalendar;

public interface IEvent {
    public String getName ();
    public EventType getType ();
    public GregorianCalendar getDate ();
    public String toString();
}

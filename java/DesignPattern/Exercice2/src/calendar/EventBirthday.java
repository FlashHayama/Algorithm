package calendar;

import java.util.GregorianCalendar;

public class EventBirthday implements IEvent{

    private GregorianCalendar date ;
    private String name ;
    private EventType type ;
    public EventBirthday(String name, int day, int month, int year) {
        this.date = new GregorianCalendar ( year , month - 1 , day );
        this.name = name ;
        this.type = EventType.Birthday ;
    }

    public String getName () {
        return name ;
    }
    public EventType getType () {
        return type ;
    }
    public GregorianCalendar getDate () {
        return date ;
    }
    
    public String toString() {
    	String result = getType().name()+": "+getName()+" "+getDate().getTime();
    	return result;
    }
    
}

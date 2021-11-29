package calendar;

import java.util.ArrayList;

public class MyCalendar extends Subject {
	private ArrayList<Event> cal;
	private ArrayList<Observer> observers;
	private String name;
	private int maxsize;

	public MyCalendar(Observer o, String calendarName) {
		maxsize = 2;
		minsize = 1;
		cal = new ArrayList<Event>();
		observers = new ArrayList<Observer>();
		name = calendarName;
		try {
			this.attach(o);
		}
		catch (MaximalSizeException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public ArrayList<Event> getEvents() {
		return cal;
	}

	public void attach(Observer o) throws MaximalSizeException {
		if (observers.size() < maxsize) {
			observers.add(o);
			o.updateAll(cal);
		} else {
			throw new MaximalSizeException(this.name + " should have at most " + maxsize + " observer ( s )! ");
		}
	}

	public void detach(Observer o) throws MinimalSizeException {
		if (observers.size() > minsize) {
			observers.remove(o);
		} else {
			throw new MinimalSizeException(this.name + " should have at least " + minsize + " observer ( s )! ");
		}
	}

	public void addEvent(Event e) {
		cal.add(e);
		this.notifyAddedEvents(e);
	}

	public void removeEvent(Event e) {
		cal.remove(e);
		this.notifyRemovedEvents(e);
	}

	public void notifyAddedEvents(Event e) {
		for (Observer o : observers)
			o.updateAdded(this, e);
	}

	public void notifyRemovedEvents(Event e) {
		for (Observer o : observers)
			o.updateRemoved(this, e);
	}
}

package calendar;
import java.util.ArrayList;

interface Observer {
    public void updateAll(ArrayList<Event> l);
    public void updateAdded(Subject s, Event e);
    public void updateRemoved(Subject s, Event e);
}

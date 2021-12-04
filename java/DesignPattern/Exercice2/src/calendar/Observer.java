package calendar;
import java.util.ArrayList;

interface Observer {
    public void updateAll(ArrayList<IEvent> l);
    public void updateAdded(Subject s, IEvent e);
    public void updateRemoved(Subject s, IEvent e);
}

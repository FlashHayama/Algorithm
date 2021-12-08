package calendar;
public abstract class Subject {
    protected int minsize = 0;
    protected int maxsize = 1;
    // minimal number of observers to be attached
    public void attach ( Observer o ) throws MaximalSizeExecption {};
    public void detach ( Observer o ) throws MinimalSizeException {};
    public void notifyAddedEvents ( IEvent e ) {};
    public void notifyRemovedEvents ( IEvent e ) {};
}

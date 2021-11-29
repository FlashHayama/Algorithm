package calendar;
public abstract class Subject {
    protected int minsize = 0;
    // minimal number of observers to be attached
    public void attach ( Observer o ) throws MaximalSizeException {};
    public void detach ( Observer o ) throws MinimalSizeException {};
    public void notifyAddedEvents ( Event e ) {};
    public void notifyRemovedEvents ( Event e ) {};
}

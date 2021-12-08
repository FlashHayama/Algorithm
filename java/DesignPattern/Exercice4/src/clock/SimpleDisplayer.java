package clock;

public class SimpleDisplayer implements Displayer {

    @Override
    public String getDisplay(ClockTimer clock) {
        return clock.getHour() + ":" + clock.getMinutes();
    }
    
}

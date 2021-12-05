package clock;

public class SecondsDisplayer extends DisplayDecorator {

    @Override
    public String getDisplay(ClockTimer clock) {
        return clock.getSeconds() + "";
    }
    
}

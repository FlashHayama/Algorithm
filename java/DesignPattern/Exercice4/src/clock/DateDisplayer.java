package clock;

public class DateDisplayer extends DisplayDecorator {

    @Override
    public String getDisplay(ClockTimer clock) {
        return clock.getDay() + "/" + clock.getMonth() + "/" + clock.getYear();
    }
    
}

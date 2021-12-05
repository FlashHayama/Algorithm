package clock;

import java.util.ArrayList;

public class ClockTimer {
	private int hour, minutes, seconds, day, month, year;
	private Displayer display = new SimpleDisplayer();
	private ArrayList<DisplayDecorator> decorators = new ArrayList<DisplayDecorator>();

	public ClockTimer(int h, int m, int s, int d, int mon, int y) {
		this.hour = h;
		this.minutes = m;
		this.seconds = s;
		this.day = d;
		this.month = mon;
		this.year = y;
	}

	public ClockTimer(int h, int m, int s, int d, int mon, int y, Displayer display) {
		this.hour = h;
		this.minutes = m;
		this.seconds = s;
		this.day = d;
		this.month = mon;
		this.year = y;
		this.display = display;
	}

	public void setDisplayer(Displayer display) {
		this.display = display;
	}

	public void addDecorator(DisplayDecorator decorator) {
		this.decorators.add(decorator);
	}

	public int getHour() {
		return hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	private int increase(int val, int low, int low_lim, int shift) {
		return val + (low / (low + shift));
	}

	private int reset(int val, int limit, int shift) {
		return (val - shift) % limit + shift;
	}

	/* * * Update and display the time . */
	public void tick() {
		seconds++;
		minutes = increase(minutes, seconds, 60, 0);
		hour = increase(hour, minutes, 60, 0);
		day = increase(day, hour, 24, 0);
		month = increase(month, day, 31, 1);
		year = increase(year, month, 12, 1);
		seconds = reset(seconds, 60, 0);
		minutes = reset(minutes, 60, 0);
		hour = reset(hour, 24, 0);
		day = reset(day, 31, 1);
		month = reset(month, 12, 1);
		System.out.println(display.getDisplay(this));
	}
}

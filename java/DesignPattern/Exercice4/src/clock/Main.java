package clock;

public class Main {
	public static void main(String[] args) {
		ClockTimer c = new ClockTimer(23, 57, 56, 31, 12, 2001);
		int count = 0;
		while (count < 24 * 60 * 60) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			c.tick();
			count++;
			if (count == 30) { // TODO afficher les secondes
			} else if (count == 60) { // TODO afficher la date et les secondes
			}
		}
	}
}
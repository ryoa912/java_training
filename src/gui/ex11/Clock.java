package gui.ex11;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {
	public Clock() {
		Timer timer = new Timer();
	}
	static public void main(String[] args) {
		Date date = new Date();
        System.out.println(date.toString());

        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Wake Up");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000L, 1000L);
	}
}
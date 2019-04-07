import java.applet.Applet;
import java.awt.*;
import java.text.DateFormat;
import java.util.Date;

public class Applet70 extends Applet implements Runnable {
	Label time;
	DateFormat timeFormat;
	Thread timer;
	volatile boolean running;
	//
	public void init() {
		time = new Label();
		time.setFont(new Font("Consolas", Font.BOLD, 12));
		time.setAlignment(Label.CENTER);
		setLayout(new BorderLayout());
		add(time, BorderLayout.CENTER);
		timeFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		setBackground(Color.black);
		setForeground(Color.yellow);
	}
	//
	public void start() {
		running = true;
		if (timer == null) {
			timer = new Thread(this);
			timer.start();
		}
	}
	//
	public void run() {
		while (running) {
			time.setText(timeFormat.format(new Date()));
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
			}
		}
		timer = null;
	}
	//
	public void stop() {
		running = false;
	}
}
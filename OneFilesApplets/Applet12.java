import java.awt.*;
import java.applet.*;

public class Applet12 extends Applet implements Runnable {
	String msg = " Una frase desplaz�ndose.";
	Thread t = null;
	int state;
	boolean stopFlag;
	//
	public void init() {
		setBackground(Color.cyan);
		setForeground(Color.red);
	}
	//
	public void start() {
		t = new Thread(this);
		stopFlag = false;
		t.start();
	}
	//
	public void run() {
		char ch;
		for( ; ;) {
			try {
				repaint();
				Thread.sleep(250);
				ch = msg.charAt(0);
				msg = msg.substring(1, msg.length());
				msg += ch;
				if (stopFlag)
					break;
			}
			catch(InterruptedException e) {
			}
		}
	}
	//
	public void stop() {
		stopFlag = true;
		t = null;
	}
	//
	public void paint(Graphics g) {
		g.drawString(msg,50,30);
	}
}
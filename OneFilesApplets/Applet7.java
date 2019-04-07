import java.awt.*;
import java.applet.*;

public class Applet7 extends Applet {
	String msg;
	//
	public void init() {
		setBackground(Color.cyan);
		setForeground(Color.red);
		msg = "En el interior de init() -- ";
	}
	//
	public void start() {
		msg+= "En el interior de start() -- ";
	}
	//
	public void paint(Graphics g) {
		msg+= " En el interior de paint().";
		g.drawString(msg,10,30);
	}
}
import java.awt.Graphics;
import java.applet.Applet;
import java.util.Date;
public class Applet28 extends Applet {
	Date todaysDate;
	//
	public void init() {
		todaysDate = new Date();
	}
	//
	public void paint(Graphics g) {
		g.drawString("Mi primer Applet ejecutado el: "+todaysDate.toString(),20,20); 
	}
}
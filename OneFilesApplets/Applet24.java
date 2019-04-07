import java.awt.*;
import java.applet.Applet;

public class Applet24 extends Applet {
	int mancho,malto;
	//
	public void init() {
		Dimension d = size();
		mancho = d.width;
		malto = d.height;
		repaint();
	}
	//
	public void paint(Graphics g) {
		g.drawLine(0,0,mancho/2,malto/2);
	}
}
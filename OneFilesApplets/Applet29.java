import java.awt.*;
import java.applet.*;

public class Applet29 extends Applet {
	int b=10, h=5;
	double a,p;
	//
	public void paint(Graphics g) {
		a=b*h;
		p=2*(b+h);
		g.drawString("Area = "+a,10,10);
		g.drawString("Perimetro = "+p,10,20);
	}
}
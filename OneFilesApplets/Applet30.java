import java.applet.*;
import java.awt.*;

public class Applet30 extends Applet {
	public void paint(Graphics gr) {
		gr.setColor(Color.red);
		gr.fillOval(20,20,100,40);
		gr.drawOval(20,20,100,40);
		gr.drawOval(140,20,100,80);
		gr.drawOval(260,20,100,100);
		gr.drawRect(600,60,100,100);
	}
}
import java.applet.*;
import java.awt.*;

public class Applet27 extends Applet {
	public void paint(Graphics gr) {
		gr.drawRoundRect(20,20,80,80,0,0);
		gr.drawRoundRect(120,20,80,80,10,10);
		gr.drawRoundRect(220,20,80,80,40,40);
		gr.drawRoundRect(320,20,80,80,80,80);
	}
}
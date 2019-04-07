import java.applet.*;
import java.awt.*;

public class Applet53 extends Applet {
	String companyName = new String("Event Handlers Incorporated");
	Font bigFont = new Font("Helvetica", Font.ITALIC,24);
	//
	public void paint(Graphics gr) {
		gr.setFont(bigFont);
		gr.setColor(Color.magenta);
		gr.drawString(companyName,10,100);
		gr.setColor(Color.orange);
		gr.drawString(companyName,40,140);
	}
}
import java.applet.*;
import java.awt.*;

public class Applet33 extends Applet {
	public void paint(Graphics gr) {
		gr.setColor(Color.red);
		setBackground(Color.blue);
		gr.fillRect(20,20,120,120);
		gr.clearRect(40,40,50,50);
		gr.drawRect(50,50,20,20);
	}
}
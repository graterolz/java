import java.awt.*;
import java.applet.*;

public class Applet2 extends Applet {
	public void init() {
		setBackground(Color.cyan);
	}
	//
	public void paint(Graphics g) {
		g.drawString("Esto est� en la ventana del applet.",10,20);
		showStatus("Esto se ense�a en la barra de estado.");
	}
}
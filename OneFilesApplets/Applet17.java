import java.awt.*;
import java.awt.event.*;

public class Applet17 extends Frame {
	public static void main(String args[]) {
		new EjMarco();
	}
	//
	public EjMarco() {
		addWindowListener(new Cierre());
		setTitle("Marco");
		setSize(200,100);
		setVisible(true);
	}
	//
	public void paint(Graphics g) {
		Font letrero = new Font("SansSerif", Font.ITALIC, 14);
		g.setFont(letrero);
		g.drawString("Bienvenido al AWT",42,60);
	}
}
//
class Cierre extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);   
	}
}
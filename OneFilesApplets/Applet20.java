import java.awt.*;
import java.awt.event.*;

public class Applet20 extends Frame implements WindowListener {
	public static void main(String args[]) {
		new Applet20();   
	}
	// 
	public Applet20() {
		addWindowListener(this);
		setTitle("Marco");
		setSize(200,100);
		setVisible(true);
	}
	// 
	public void paint(Graphics g) {
		Font letrero = new Font("SansSerif", Font.ITALIC,14);
		g.setFont(letrero);
		g.drawString("Bienvenido al AWT",42,60);
	}
	//
	public void windowClosing(WindowEvent e) {
		System.exit(0);   
	}
	// 
	public void windowActivated(WindowEvent e) {} 
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
}
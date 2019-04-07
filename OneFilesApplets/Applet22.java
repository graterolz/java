import java.awt.*;
import java.awt.event.*;

public class Botones extends Frame {
	public Botones() {
		addWindowListener(new Cierre3());
		Panel panelBotones = new Panel();
		for(int i=1;i<8;i++)
			panelBotones.add(new Button("Boton "+i));
		add( "South",panelBotones);
	}
	//
	public static void main(String args[]) {
		Botones ventana = new Botones();
		ventana.setTitle("El AWT");
		ventana.setSize(400,250);
		ventana.setVisible(true);
	}
}
//
class Applet22 extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
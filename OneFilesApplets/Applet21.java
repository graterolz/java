import java.awt.*;
import java.awt.event.*;

public class Paneles extends Frame {
	public Paneles() {
		addWindowListener(new Cierre3());
		Panel pX = new Panel();
		pX.setBackground(Color.black);
		Panel pY = new Panel();
		pY.setBackground(Color.red);
		Label etiqueta1 = new Label("Los paneles se adaptan");
		Label etiqueta2 = new Label("a nuestro tamaño");
		etiqueta1.setBackground(Color.white);
		pY.add(etiqueta1);
		pY.add(etiqueta2);
		pX.add(pY);
		add(pX);
	}
	//
	public static void main(String args[]) {
		Paneles ventana = new Paneles();
		ventana.setLayout(new FlowLayout());
		ventana.setTitle("El AWT");
		ventana.setSize(300,120);
		ventana.setVisible(true);
	}
}
//
class Applet21 extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
import java.awt.*;
import java.awt.event.*;

public class Otros5 extends Frame implements ActionListener {
	int edad=0;
	TextField texto2;
	//
	public Otros5() {
		addWindowListener(new Cierre3());
		Label etiqueta1 = new Label("Introduzca su nombre: ");
		add(etiqueta1);
		TextField texto1 = new TextField("",35);
		add(texto1);
		Label etiqueta2 = new Label("Introduzca la edad en años"+" y pulse <Return> a continuacion");
		add(etiqueta2);
		texto2 = new TextField("",2);
		texto2.setEchoChar('*');
		add(texto2);
		texto2.addActionListener(this);
	}
	//
	public void paint(Graphics g) {
		try {
			edad = Integer.parseInt(texto2.getText());
			g.drawString("Joven de "+edad+" años",24,150);
		}
		catch(Exception ex) {}
	}
	//
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==texto2)
			repaint();
	}
	// 
	public static void main(String args[]) {
		Otros5 vt = new Otros5();
		vt.setLayout(new FlowLayout());
		vt.setTitle(" El AWT ");
		vt.setSize(400,250);
		vt.setVisible(true);
	}
}
import java.awt.*;
import java.awt.event.*;

public class Otros9 extends Frame implements ItemListener {
	private Choice seleccion;
	String elemento = "";
	//
	public Otros9() {
		addWindowListener(new Cierre3());
		seleccion = new Choice();
		seleccion.addItem("Uno");
		seleccion.addItem("Dos");
		seleccion.addItem("Tercero");
		seleccion.select(1);
		seleccion.addItemListener(this);
		add(seleccion);
	}
	//
	public static void main(String args[]) {
		Otros9 ventana = new Otros9();
		ventana.setLayout(new FlowLayout());
		ventana.setTitle("El AWT");
		ventana.setSize(400,250);
		ventana.setVisible(true);
	}
	//
	public void paint(Graphics g) {
		elemento = seleccion.getSelectedItem();
		g.drawString("Elemento seleccionado "+elemento,20,230);
	}
	//
	public void itemStateChanged(ItemEvent e) {
		repaint();
	}
}
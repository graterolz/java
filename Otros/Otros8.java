import java.awt.*;
import java.awt.event.*;

public class Otros8 extends Frame implements ItemListener {
	private Checkbox op1,op2,op3,op4;
	private CheckboxGroup menu;
	//
	public EjCheckboxGroup() {
		addWindowListener(new Cierre3());
		menu = new CheckboxGroup();
		op1 = new Checkbox("Primera opción", menu,false);
		op2 = new Checkbox("Segunda opción", menu,false);
		op3 = new Checkbox("Tercera opción", menu,false);
		op4 = new Checkbox("Cuarta opción", menu,false);
		add(op1);
		add(op2);
		add(op3);
		add(op4);
		op1.addItemListener(this);
		op2.addItemListener(this);
		op3.addItemListener(this);
		op4.addItemListener(this);
	}
	//
	public static void main(String args[]) {
		EjCheckboxGroup ventana = new EjCheckboxGroup();
		ventana.setLayout(new GridLayout(3,2));
		ventana.setTitle("El AWT");
		ventana.setSize(400,250);
		ventana.setResizable(false);
		ventana.setVisible(true);
	}
	//
	public Insets getInsets() {
		return new Insets(20,20,20,20);
	}
	//
	public void paint(Graphics g) {
		if(menu.getSelectedCheckbox()!=null) 
			g.drawString("Elemento seleccionado "+menu.getSelectedCheckbox().getLabel(),20,230); 
	}
	//
	public void itemStateChanged(ItemEvent e) {
		repaint ();
	}
}
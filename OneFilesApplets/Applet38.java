import javax.swing.*;
import java.awt.*;

public class Applet38 extends Applet implements ActionListener, ItemListener {
	String msg="";
	Color r =new Color(32,54,76);
	Button boton1;
	List lista = new List();
	LayoutManager Layout;
	JComboBox combo;
	String [] ColorList;
	//
	public void init() {
		Layout = new FlowLayout ();
		boton1 = new Button("Cambiar color");
		ColorList = new String [9];
		ColorList [0] = "Red";
		ColorList [1] = "Magenta";
		ColorList [2] = "Blue";
		ColorList [3] = "Cyan";
		ColorList [4] = "Green";
		ColorList [5] = "Yellow";
		ColorList [6] = "White";
		ColorList [7] = "Gray";
		ColorList [8] = "Black";
		combo = new JComboBox (ColorList);
		combo.addItemListener(this);
		lista.add("azul");
		add(new Label("Meresco un 20 estudie mucho"));
		add(combo);
		add(lista);
		add(boton1);
		lista.addActionListener(this);
		boton1.addActionListener(this);
	}
	//
	public void itemStateChanged(ItemEvent e) {
		int Selection;
		Selection = combo.getSelectedIndex();
		if (Selection == 0) {
			setBackground (Color.red);
			msg ="USANDO COMBOBOX";
			r = Color.cyan;
		}
		else if (Selection == 1) {
			setBackground (Color.magenta);
			msg ="USANDO COMBOBOX";
			r = Color.red;
		}
		else if (Selection == 2) {
			setBackground (Color.blue);
			msg ="USANDO COMBOBOX";
			r = Color.green;
		}
		else if (Selection == 3) {
			setBackground (Color.cyan);
			msg ="USANDO COMBOBOX";
			r = Color.blue;
		}
		else if (Selection == 4) {
			setBackground (Color.green);
			msg ="USANDO COMBOBOX";
			r = Color.yellow;
		}
		else if (Selection == 5) {
			setBackground (Color.yellow);
			msg ="USANDO COMBOBOX";
			r = Color.pink;
		}
		else if (Selection == 6) {
			setBackground (Color.white);
			msg ="USANDO COMBOBOX";
			r = Color.blue;
		}
		else if (Selection == 7) {
			setBackground (Color.gray);
			msg ="USANDO COMBOBOX";
			r = Color.cyan;
		}
		else if (Selection == 8) {
			setBackground (Color.black);
			msg ="USANDO COMBOBOX";
			r = Color.red;
		}
	}
	//
	public void actionPerformed(ActionEvent ae) {
		String str=ae.getActionCommand();
		if(str.equals("Cambiar color")) {
			setBackground(Color.black);
			msg="HOLA MUNDO!!";
			r=Color.pink;
		}
		else {
			msg="Uso del LISTBOX";setBackground(Color.blue);r=Color.red;
		}
		repaint();
	}
	//
	public void paint(Graphics g) {
		g.setColor(r);
		g.drawString(msg,6,100);
	}
}
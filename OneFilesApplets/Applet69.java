import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Applet69 extends Applet implements ActionListener {
	List lista;
	TextField texto;
	Button boton;
	String selecciones[];
	//
	public void init(){
		texto = new TextField(40);
		add(texto);
		lista = new List(4, true);
		lista.add("Item 1");
		lista.add("Item 2");
		lista.add("Item 3");
		lista.add("Item 4");
		lista.add("Item 5");
		lista.add("Item 6");
		lista.add("Item 7");
		lista.add("Item 8");
		lista.add("Item 9");
		add(lista);
		boton = new Button("Mostrar selecciones");
		boton.addActionListener(this);
		add(boton);
		boton.setBackground(Color.red);
		texto.setBackground(Color.black);
		texto.setForeground(Color.yellow);
		this.setBackground(Color.orange);
	}
	//
	public void actionPerformed(ActionEvent e) {
		String cadenaSalida = new String("Las selecciones son:");
		if(e.getSource() == boton){
			selecciones = lista.getSelectedItems();
			for(int index = 0; index < selecciones.length; index++){
				cadenaSalida += " " + selecciones[index];
			}
			texto.setText(cadenaSalida);
		}
	}
}
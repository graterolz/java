import java.applet.Applet;
import java.awt.*;

public class Applet62 extends Applet implements ActionListener {
	List listaSeleccion;
	TextField text1;
	//
	public void init(){
		text1 = new TextField(20);
		add(text1);
		listaSeleccion = new List(4);
		listaSeleccion.add("Elemento 1");
		listaSeleccion.add("Elemento 2");
		listaSeleccion.add("Elemento 3");
		listaSeleccion.add("Elemento 4");
		listaSeleccion.add("Elemento 5");
		listaSeleccion.add("Elemento 6");
		listaSeleccion.add("Elemento 7");
		listaSeleccion.add("Elemento 8");
		listaSeleccion.add("Elemento 9");
		add(listaSeleccion);
		listaSeleccion.addActionListener(this);
		listaSeleccion.setBackground(Color.black);
		listaSeleccion.setForeground(Color.yellow);
		this.setBackground(Color.orange);
	}
	//
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == listaSeleccion){
			text1.setText(((List) e.getSource()).getSelectedItem());
		}
	}
}
import java.awt.*;
import java.applet.Applet;

class Applet71 extends Panel {
	Button boton;
	Label etiqueta;
	//
	void tarjetaPanel(tarjeta applet, String cardnumber) {
		boton = new Button("Siguiente");
		boton.addActionListener(applet);
		add(boton);
		etiqueta = new Label("Esta es la tarjeta nº " + cardnumber);
		add(etiqueta);
	}
}
//
public class tarjeta extends Applet implements ActionListener {
	int index = 1;
	CardLayout cardlayout;
	tarjetaPanel panel1, panel2, panel3;
	//
	public void init() {
		cardlayout = new CardLayout();
		setLayout(cardlayout);
		panel1 = new tarjetaPanel(this, "Amarilla");
		panel1.setBackground(Color.yellow);
		panel2 = new tarjetaPanel(this, "Roja");
		panel2.setBackground(Color.red);
		panel3 = new tarjetaPanel(this, "Aaranja");
		panel3.setBackground(Color.orange);
		add("primero", panel1);
		add("segundo", panel2);
		add("tercero", panel3);
		cardlayout.show(this, "primero");
	}
	//
	public void actionPerformed(ActionEvent evento) {
		switch(++index){
			case 1:
				cardlayout.show(this, "primero");
				break;
			case 2:
				cardlayout.show(this, "segundo");
				break;
			case 3:
				cardlayout.show(this, "tercero");
				break;
		}
		if(index == 3) index = 0;
		repaint();
	}
}
import java.awt.*;
import java.applet.Applet;

public class Applet64 extends Applet implements ActionListener {
	Button boton, botonCerrar;
	botonera menuWindow;
	//
	public void init() {
		boton = new Button("Ver administrador BorderLayout");
		botonCerrar = new Button("Cerrar ventana");
		add(boton);
		add(botonCerrar);
		boton.addActionListener(this);
		botonCerrar.addActionListener(this);
		menuWindow = new botonera();
		menuWindow.setSize(400, 200);
		menuWindow.setLocation(500,250);
	}
	//
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == boton){
			menuWindow.setVisible(true);
		}
		else{
			if(event.getSource() == botonCerrar){
				menuWindow.setVisible(false);
			}
		}
	}
}
//
class botonera extends Frame {
	botonera() {
		setTitle("BorderLayout");
		add("North",new Button("Boton Norte"));
		add("South",new Button("Boton Sur"));
		add("West",new Button("Boton Oeste"));
		add("East",new Button("Boton Este"));
		add("Center",new Button("Boton Centro"));
	}
}
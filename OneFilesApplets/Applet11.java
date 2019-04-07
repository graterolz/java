import java.awt.*;
import java.applet.*;

public class Applet11 extends Applet implements ActionListener {
	TextField name,pass;
	//
	public void init() {
		Label namep = new Label("Nombre: ",Label.RIGHT);
		Label passp = new Label("Password: ",Label.RIGHT);
		name = new TextField(12);
		pass = new TextField(8);
		pass.setEchoChar('?');
		add(namep);
		add(name);
		add(passp);
		add(pass);
		name.addActionListener(this);
		pass.addActionListener(this);
	}
	//
	public void actionPerformed(ActionEvent ae) {
		repaint();
	}
	//
	public void paint(Graphics g) {
		g.drawString("Nombre: "+name.getText(),6,60);
		g.drawString("Texto seleccionado en Nombre:   "+name.getSelectedText(),6,80);
		g.drawString("Password: "+pass.getText(),6,100);
	}
}
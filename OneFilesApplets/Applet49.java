import java.applet.Applet;
import java.awt.*;

public class Applet49 extends Applet implements ActionListener {
	TextArea textarea1;
	Button boton;
	//
	public void init(){
		textarea1 = new TextArea("", 15, 15, TextArea.SCROLLBARS_BOTH);
		boton = new Button("Pulsa el boton");
		boton.addActionListener(this);
		add(textarea1);
		add(boton);
	}
	//
	public void actionPerformed (ActionEvent e) {
		String text = "Esto es un area de texto..";
		if(e.getSource() == boton){
			textarea1.insert(text, 0);
		}
	}
}
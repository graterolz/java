import java.applet.Applet;
import java.awt.*;

public class Applet59 extends Applet implements ActionListener {
	TextArea areaTexto;
	Button boton;
	//
	public void init() {
		areaTexto = new TextArea("Esto es un texto", 5, 20, TextArea.SCROLLBARS_BOTH);
		boton = new Button("Buscar \"texto\"");
		add(areaTexto);
		add(boton);
		boton.addActionListener(this);
		setBackground(Color.yellow);
	}
	//
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == boton){
			String s = areaTexto.getText();
			String s1 = new String("texto");
			int location = s.indexOf(s1);
			areaTexto.select(location, location + s1.length());
		}
	}
}
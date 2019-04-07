import java.applet.Applet;
import java.awt.*;

public class Applet44 extends Applet implements ActionListener {
	TextArea areaTexto;
	Button boton;
	//
	public void init() {
		areaTexto = new TextArea("Texto que puedes reemplazar", 6, 30,TextArea.SCROLLBARS_BOTH);
		boton = new Button("Reeplazar por .....");
		add(areaTexto);
		add(boton);
		boton.addActionListener(this);
		boton.setBackground(Color.red);
		areaTexto.setBackground(Color.black);
		areaTexto.setForeground(Color.yellow);
		this.setBackground(Color.orange);
	}
	//
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == boton){
			areaTexto.replaceRange(".....",areaTexto.getSelectionStart(),areaTexto.getSelectionEnd()) ;
		}
	}
}
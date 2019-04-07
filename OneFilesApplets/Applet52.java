import java.applet.Applet;
import java.awt.*;

public class Applet52 extends Applet implements ActionListener {
	TextField text1;
	Button button1;
	//
	public void init(){
		text1 = new TextField(20);
		add(text1);
		button1 = new Button("Pulsa este boton");
		add(button1);
		button1.addActionListener(this);
	}
	//
	public void actionPerformed(ActionEvent e){
		String texto = new String ("Muy bien!!!");
		if(e.getSource() == button1){
			text1.setText(texto);
		}
	}
}
import java.applet.Applet;
import java.awt.*;

public class Applet58 extends Applet implements ActionListener {
	TextField text1;
	Button button1;
	//
	public void init() {
		text1 = new TextField(20);
		add(text1);
		button1 = new Button("Pulsa este boton");
		add(button1);
		button1.addActionListener(this);
	}
	//
	public void actionPerformed(ActionEvent event)
	{
		String texto = new String ("Muy bien!!!");
		if(event.getSource() == button1){
			text1.setText(texto);
		}
	}
}
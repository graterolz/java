import java.applet.Applet;
import java.awt.*;

public class Applet51 extends Applet implements ActionListener {
	public TextField texto1;
	public TextField texto2;
	//
	public void init() {
		texto1 = new TextField(35);
		texto2 = new TextField(35);
		add(texto1);
		add(texto2);
		texto1.setEchoChar('*');
		texto1.addActionListener(this);
	}
	//
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == texto1){
			texto2.setText(texto1.getText());
		}
	}
}
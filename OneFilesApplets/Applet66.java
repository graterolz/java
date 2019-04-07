import java.applet.Applet;
import java.awt.*;

public class Applet66 extends Applet implements ItemListener {
	Checkbox checkbox1, checkbox2, checkbox3, checkbox4;
	TextField texto;
	//
	public void init() {
		checkbox1 = new Checkbox("A");
		checkbox1.addItemListener(this);
		checkbox2 = new Checkbox("B");
		checkbox2.addItemListener(this);
		checkbox3 = new Checkbox("C");
		checkbox3.addItemListener(this);
		checkbox4 = new Checkbox("D");
		checkbox4.addItemListener(this);
		add(checkbox1);
		add(checkbox2);
		add(checkbox3);
		add(checkbox4);
		texto = new TextField(25);
		add(texto);
	}
	//
	public void itemStateChanged(ItemEvent event) {
		if(event.getItemSelectable() == checkbox1){
			texto.setText("Casilla A activada");
		} else if(event.getItemSelectable() == checkbox2){
			texto.setText("Casilla B activada");
		} else if(event.getItemSelectable() == checkbox3){
			texto.setText("Casilla C activada");
		} else if(event.getItemSelectable() == checkbox4){
			texto.setText("Casilla D activada");
		}
	}
}
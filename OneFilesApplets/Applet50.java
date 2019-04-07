import java.applet.Applet;
import java.awt.*;

public class Applet50 extends Applet {
	Label etiqueta1;
	Label etiqueta2;
	Label etiqueta3;
	//
	public void init() {
		etiqueta1 = new Label("Etiqueta nº 1", Label.LEFT);
		etiqueta1.setBackground(Color.red);
		add(etiqueta1);
		etiqueta2 = new Label("Etiqueta nº 2", Label.CENTER);
		etiqueta2.setBackground(Color.blue);
		add(etiqueta2);
		etiqueta3 = new Label("Etiqueta nº 3", Label.RIGHT);
		etiqueta3.setBackground(Color.orange);
		add(etiqueta3);
	}
}
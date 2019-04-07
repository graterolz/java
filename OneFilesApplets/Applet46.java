import java.applet.Applet;
import java.awt.*;

public class Applet46 extends Applet implements AdjustmentListener {
	TextField texto;
	Scrollbar barra1, barra2;
	//
	public void init() {
		barra1 = new Scrollbar(Scrollbar.HORIZONTAL, 1, 20, 1, 200);
		barra2 = new Scrollbar(Scrollbar.VERTICAL, 1, 20, 1, 200);
		barra1.addAdjustmentListener(this);
		barra2.addAdjustmentListener(this);
		texto = new TextField(20);
		add(texto);
		add(barra1);
		add(barra2);
	}
	//
	public void adjustmentValueChanged(AdjustmentEvent e) {
		if(e.getAdjustable() == barra1 || e.getAdjustable() == barra2) {
			texto.setText("Horizontal: " + barra1.getValue() + " Vertical: " + barra2.getValue());
		}
	}
}
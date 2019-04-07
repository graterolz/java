import java.awt.*;
import java.applet.Applet;

public class Applet68 extends Applet implements AdjustmentListener {
	Scrollbar barra1, barra2;
	int x = 0;
	int y = 0;
	//
	public void init() {
		barra1 = new Scrollbar(Scrollbar.HORIZONTAL, 1, 10, 1, 100);
		barra2 = new Scrollbar(Scrollbar.VERTICAL, 1, 10, 1, 100);
		add(barra1);
		add(barra2);
		barra2.addAdjustmentListener(this);
		barra1.addAdjustmentListener(this);
		setBackground(Color.black);
		setForeground(Color.yellow);
	}
	//
	public void paint(Graphics g) {
		g.drawString("Texto que puedes desplazar.", x, y);
	}
	//
	public void adjustmentValueChanged(AdjustmentEvent e) {
		if(e.getAdjustable() == barra1) {
			x = (int) (getSize().width * (float) barra1.getValue() / 100);
			repaint();
		}else
			 if(e.getAdjustable() == barra2){
				 y = (int) (getSize().width * (float) barra2.getValue() / 100);
				 repaint();
			}
	}
}
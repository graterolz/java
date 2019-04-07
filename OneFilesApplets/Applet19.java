import java.awt.*;
import java.applet.*;

public class Applet19 extends Applet {
	int coordX, coordY;
	//
	public void init() {
		coordX=-1;
		coordY=-1;
		addMouseMotionListener(new AdaptadorMovimientosRaton());
	}
	//
	public void paint(Graphics g) {
		if (coordX!=-1)
			g.drawString("("+coordX+","+coordY+")",coordX,coordY);
	}
	//
	class AdaptadorMovimientosRaton extends MouseMotionAdapter {
		public void mouseMoved(MouseEvent evento){
			coordX=evento.getX();
			coordY=evento.getY();
			repaint();
		}
	}
}
import java.awt.*;
import java.applet.*;

public class Applet8 extends Applet implements MouseListener, MouseMotionListener {
	String msg = "";
	int mouseX=0,mouseY=0;
	//
	public void init() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	//
	public void mouseClicked(MouseEvent me) {
		mouseX=0;
		mouseY=10;
		msg="Click en el ratón.";
		repaint();
	}
	//
	public void mouseEntered(MouseEvent me) {
		mouseX=0;
		mouseY=10;
		msg="El ratón ha entrado";
		repaint();
	}
	//
	public void mouseExited(MouseEvent me) {
		mouseX=0;
		mouseY=10;
		msg="El ratón ha salido";
		repaint();
	}
	//
	public void mousePressed(MouseEvent me) {
		mouseX=me.getX();
		mouseY=me.getY();
		msg="Down.";
		repaint();
	}
	//
	public void mouseReleased(MouseEvent me) {
		mouseX=me.getX();
		mouseY=me.getY();
		msg="Up.";
		repaint();
	}
	//
	public void mouseDragged(MouseEvent me) {
		mouseX=me.getX();
		mouseY=me.getY();
		msg="*";
		showStatus("Arrastrando el ratón en " + mouseX + ", " + mouseY);
		repaint();
	}
	//
	public void mouseMoved(MouseEvent me) {
		showStatus("Arrastrando el ratón en " + me.getX() + ", " + me.getY());
	}
	//
	public void paint(Graphics g) {
		g.drawString(msg,mouseX,mouseY);
	}
}
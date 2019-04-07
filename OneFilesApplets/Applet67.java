import java.awt.*;
import java.applet.Applet;

public class Applet67 extends Applet implements MouseListener, MouseMotionListener {
	TextField text1;
	//
	public void init(){
		text1 = new TextField(35);
		add(text1);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	//
	public void mousePressed(MouseEvent e) {
		if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
			text1.setText("Bot�n izquierdo del rat�n apretado en " + e.getX() + "," + e.getY());
		}
		else{
			text1.setText("Bot�n derecho del rat�n apretado en " + e.getX() + "," + e.getY());
		}
	}
	//
	public void mouseClicked(MouseEvent e) {
		text1.setText("Hizo clic sobre el rat�n en " + e.getX() + "," + e.getY());
	}
	//
	public void mouseReleased(MouseEvent e) {
		text1.setText("Se solt� el bot�n del rat�n.");
	}
	//
	public void mouseEntered(MouseEvent e) {
		text1.setText("Rat�n para introducir.");
	}
	//
	public void mouseExited(MouseEvent e) {
		text1.setText("Rat�n para salir.");
	}
	//
	public void mouseDragged(MouseEvent e) {
		text1.setText("Se arrast� el rat�n.");
	}
	//
	public void mouseMoved(MouseEvent e) {
		text1.setText("Se movi� el rat�n.");
	}
}
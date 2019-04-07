import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Applet74 extends Applet implements ActionListener {
	Button botonOn, botonOf;
	labelFrame window;
	//
	public void init() {
		botonOn = new Button("Ver ventana");
		botonOf = new Button("Ocultar ventana");
		add(botonOn);
		add(botonOf);
		botonOn.addActionListener(this);
		botonOf.addActionListener(this);
		window = new labelFrame("Ventana Java");
		window.setSize(640,480);
	}
	//
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == botonOn){
			window.setVisible(true);
		}
		if(event.getSource() == botonOf){
			window.setVisible(false);
		}
	}
}
//
class labelFrame extends Frame implements MouseListener {
	Label label;
	//
	void labelFrame(String titulo){
		super(titulo);
		setLayout(new FlowLayout());
		setBackground(Color.orange);
		label = new Label("Esta es una ventana frame de Java................");
		add(label);
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public voidwindowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}
	//
	public void mousePressed(MouseEvent e){
		if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
			label.setText("Botón izquierdo del ratón pulsado en " + e.getX() + "," + e.getY());
		}
		else{
			label.setText("Botón derecho del ratón pulsado en " + e.getX() + "," + e.getY());
		}
	}
	//
	public void mouseClicked(MouseEvent e) {
		label.setText("Pulsó el ratón en " + e.getX() + "," + e.getY());
	}
	//
	public void mouseReleased(MouseEvent e) {
		label.setText("Se soltó el botón del ratón.");
	}
	//
	public void mouseEntered(MouseEvent e) {
		label.setText("Se intruducio el ratón");
	}
	//
	public void mouseExited(MouseEvent e) {
		label.setText("El raton salió");
	}
}
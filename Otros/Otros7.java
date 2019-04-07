import java.awt.*;
import java.awt.event.*;

public class Otros7 {
	public static void main(String args[]) {
		Marco elMarco = new Marco();
		elMarco.setTitle("Marco");
		elMarco.setSize(400,200);
		elMarco.setVisible(true);
		elMarco.addWindowListener(new Cerrar());
		Dialogo dialogoNoModal = new Dialogo(elMarco,"Dialogo no modal",false);
		dialogoNoModal.setBackground(Color.yellow);
		dialogoNoModal.getGraphics();
		dialogoNoModal.setBounds(100,100,300,100);
		dialogoNoModal.addWindowListener(new Cerrar(dialogoNoModal));
		dialogoNoModal.setVisible(true);
		Dialogo dialogoModal = new Dialogo(elMarco,"Dialogo Modal",true);
		dialogoModal.setSize(300,100);
		dialogoModal.addWindowListener(new Cerrar(dialogoModal));
		dialogoModal.setVisible(true);
	}
}
//
class Marco extends Frame {
	public void paint(Graphics g) {
		Font letrero = new Font("Courier", Font.BOLD, 12);
		g.setFont(letrero);
		g.drawString("Bienvenido al AWT",24,70);
	}
}
//
class Dialogo extends Dialog {
	Dialogo (Frame ventana,String titulo, boolean modo) {
		super(ventana,titulo,modo);
	}
	//
	public void paint(Graphics g) {
		if(super.isModal())
			g.drawString("Ciérreme para poder acceder" + " a otras ventanas",10,40);
		else
			g.drawString("Desde este cuadro puede acceder" + " a otras ventanas",10,40);
	}
}
//
class Cerrar extends WindowAdapter {
	Dialogo otroDialogo;
	//
	Cerrar (Dialogo unDialogo) {
		otroDialogo = unDialogo;
	} 
	//
	Cerrar() {
		otroDialogo = null;
	}
	//
	public void windowClosing(WindowEvent evt) {
		if(otroDialogo!=null)
			otroDialogo.dispose();
		else
			System.exit(0);
	}
}
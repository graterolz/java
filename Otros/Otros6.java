import java.awt.*;
import java.awt.event.*;

public class Otros6 {
	public static void main(String args[]) {
		Ventana ventanas = new Ventana();
	}
}
//
class Ventana {
	String msg = "";
	//
	public Ventana() {
		Frame elMarco = new Frame();
		FileDialog dialogoArchivos = new FileDialog(elMarco,"Elija archivo",FileDialog.LOAD);
		dialogoArchivos.setVisible(true);
		String nombre = dialogoArchivos.getFile();
		String directorio = dialogoArchivos.getDirectory();
		if (nombre!=null) {
			msg = "Archivo seleccionado: "+ directorio+nombre;
			Dialogo2 dialogoModal = new Dialogo2(elMarco,"Dialogo Modal",true,msg);
			dialogoModal.setSize(msg.length()*5+24,100);
			dialogoModal.addWindowListener(new Cerrar2(dialogoModal));
			dialogoModal.setVisible(true);
		}
		System.exit(0);
	}
}
//
class Dialogo2 extends Dialog {
	String mensaje;
	//
	Dialogo2 (Frame ventana, String titulo, boolean modo, String msg) {
		super(ventana,titulo,modo);
		mensaje = msg;
	}
	// 
	public void paint(Graphics g) {
		Font letrero = new Font("Helvetica",Font.PLAIN,10);
		g.setFont(letrero);
		g.drawString(mensaje,12,40);
	}
}
//
class Cerrar2 extends WindowAdapter {
	Dialogo2 otroDialogo;
	//
	Cerrar2 (Dialogo2 unDialogo) {
		otroDialogo = unDialogo;

	}
	//
	public void windowClosing(WindowEvent evt) {
		otroDialogo.dispose();   
	}
}
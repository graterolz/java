import java.awt.*;
import javax.swing.*;

public class Applet16 extends JApplet {
	String Resultado; 
	String primernumero; 
	String segundonumero;
	//
	public void init() {
		double numero1; 
		double numero2; 
		primernumero = JOptionPane.showInputDialog("Ingrese el primer numero:" );
		segundonumero = JOptionPane.showInputDialog( "Ingrese el segundo numero:" );
		numero1 = Double.parseDouble( primernumero );
		numero2 = Double.parseDouble( segundonumero );
		if ( numero1 > numero2 )
			Resultado = numero1 + " Es mayor.";
		else if ( numero1 < numero2 )
			Resultado = numero2 + " Es mayor.";
		else
			Resultado = "Son iguales.";
	}
	//
	public void paint( Graphics g ) {
		g.drawRect( 15, 10, 270, 80 );
		g.drawString( "Primer numero: " + primernumero, 25, 25 );
		g.drawString( "Segundo numero " + segundonumero, 25, 45 );
		g.drawString( Resultado, 25, 65 );
	}
}
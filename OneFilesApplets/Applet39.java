import java.awt.*;
import javax.swing.*;

public class Applet39 extends JApplet  {
	String uno,dos,tres,cuatro,cinco,Resultadomenor,Resultadomayor;
	//
	public void init() {
		double numero1,numero2,numero3,numero4,numero5; 
		uno = JOptionPane.showInputDialog("Ingrese el primer numero:" );
		dos = JOptionPane.showInputDialog( "Ingrese el segundo numero:" );
		tres= JOptionPane.showInputDialog( "Ingrese el tercer numero:" );
		cuatro= JOptionPane.showInputDialog( "Ingrese el cuarto numero:" );
		cinco= JOptionPane.showInputDialog( "Ingrese el quinto numero:" );
		numero1 = Double.parseDouble(uno);
		numero2 = Double.parseDouble(dos);
		numero3 = Double.parseDouble(tres);
		numero4 = Double.parseDouble(cuatro);
		numero5 = Double.parseDouble(cinco);
		if(numero1 < numero2 && numero1 < numero3 && numero1 < numero4 && numero1 < numero5) 
			Resultadomenor = numero1 + " El Numero Menor.";
		else{
			if(numero2 < numero1 && numero2 < numero3 && numero2 < numero4 && numero2 < numero5) 
				Resultadomenor = numero2 + " El Numero Menor.";  
			else if(numero3 < numero1 && numero3 < numero2 && numero3 < numero4 && numero3 < numero5)
				Resultadomenor = numero3 + " El Numero Menor.";
				if (numero4 < numero1 && numero4 < numero2 && numero4 < numero3 && numero4 < numero5)
					Resultadomenor = numero4 + " El Numero Menor.";
				else if (numero5 < numero1 && numero5 < numero2 && numero5 < numero3 && numero5 < numero4)
					Resultadomenor = numero5 + " El Numero Menor.";
		}
		if(numero1 > numero2 && numero1 > numero3 && numero1 > numero4 && numero1 > numero5){
			Resultadomayor = numero1 + " El Numero Mayor.";
		}
		else{
			if(numero2 > numero1 && numero2 > numero3 && numero2 > numero4 && numero2 > numero5){
				Resultadomayor = numero2 + " El Numero Mayor.";
			}
			else if(numero3 > numero1 && numero3 > numero2 && numero3 > numero4 && numero3 > numero5){
				Resultadomayor = numero3 + " El Numero Mayor.";  
				if (numero4 > numero1 && numero4 > numero2 && numero4 > numero3 && numero4 > numero5){
					Resultadomayor = numero4 + " El Numero Mayor.";  
				}
				else{
					if (numero5 > numero1 && numero5 > numero2 && numero5 > numero3 && numero5 > numero4)
						Resultadomayor = numero5 + " El Numero Mayor.";  
				}
			}
		}
	}
	//
	public void paint (Graphics g) {
		g.drawString(Resultadomenor,30,30);
		g.drawString(Resultadomayor,40,40);
	}
}
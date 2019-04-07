import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class Applet37 extends JApplet {
	String Resultado;
	String Resultado1;
	String Resultado2;
	String Resultado3;
	String primernumero; 
	String segundonumero;
	String tercernumero;
	//
	public void init() {
		double numero1; 
		double numero2;
		double numero3;
		double suma;
		double producto;
		double promedio;
		primernumero = JOptionPane.showInputDialog("Ingrese el primer numero:");
		segundonumero = JOptionPane.showInputDialog("Ingrese el segundo numero:");
		tercernumero= JOptionPane.showInputDialog("Ingrese el tercer numero:");
		numero1 = Double.parseDouble(primernumero);
		numero2 = Double.parseDouble(segundonumero);
		numero3 = Double.parseDouble(tercernumero);
		suma=(numero1+numero2+numero3);
		producto=(numero1*numero2*numero3);
		promedio=(numero1+numero2+numero3)/3;
		if (numero1 > numero2){
			Resultado = numero1 + " Es mayor.";
			Resultado1 = suma + " Suma.";
			Resultado2 = producto + " Producto.";
			Resultado3 = promedio + " Promedio.";
		}
		else if (numero1 < numero2){
			Resultado = numero2 + " Es mayor.";
			Resultado1 = suma + " Suma.";
			Resultado2 = producto + " Producto.";
			Resultado3 = promedio + " Promedio.";
		}
		else{
			Resultado = "Son iguales.";
			Resultado1 = suma + " Suma.";
			Resultado2 = producto + " Producto.";
			Resultado3 = promedio + " Promedio.";
		}
	}
	//
	public void paint(Graphics g) {
		g.drawRect(15, 10, 270, 80);
		g.drawString("Primer numero: " + primernumero, 25, 25);
		g.drawString("Segundo numero " + segundonumero, 25, 45);
		g.drawString("Tercer numero " + tercernumero, 25, 65);
		g.drawString(Resultado, 25, 85);
		g.drawString("Promedio " + Resultado3, 25, 105);
		g.drawString("Producto " + Resultado2, 25, 125);
		g.drawString("Suma " + Resultado1, 25, 145);
	}
}
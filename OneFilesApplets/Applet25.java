import java.awt.*;
import java.applet.Applet;

public class Applet25 extends Applet {
	double soles=3.52,marcos=2.08,euros=1.07;
	double s=15,m=15,d=15,tot=0;
	//
	public void paint(Graphics g) {
		tot=((s/soles)+(m/marcos)+d)/euros;
		g.drawString("Centro de Salud = "+(tot*0.6),10,10);
		g.drawString("Comedor de niños = "+(tot*0.4),10,20);
		g.drawString("Gastos Administrativoa = "+(tot*0.0),10,30);
	}
}
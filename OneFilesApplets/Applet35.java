import java.awt.*;
import javax.swing.*;

public class Applet35 extends JApplet {
	String line1;
	String line2;
	String line3;
	//
	public void init() {
		String input;
		double radius;
		input = JOptionPane.showInputDialog( "Enter radius:" );
		radius = Double.parseDouble( input );
		line1 = String.format("Diameter is %.3f", ( 2 * radius ) );
		line2 = String.format("Area is %.3f", ( Math.PI * radius * radius ) );
		line3 = String.format("Circumference is %.3f", ( 2 * Math.PI * radius ) );
	}
	//
	public void paint( Graphics g ) {
		g.drawString( line1, 25, 30 );
		g.drawString( line2, 25, 45 );
		g.drawString( line3, 25, 60 );
	}
}
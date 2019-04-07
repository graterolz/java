import java.applet.*;
import java.awt.*;
import java.util.*;

public class Applet3 extends Applet {
	Random R;
	//
	public void init() {
		System.out.println("Code base in "+getCodeBase());
		System.out.println("Document base is; "+getDocumentBase());
		R= new Random();
	}
	//
	public void paint(Graphics g) {
		int x,y,last_x,last_y;
		int xdim= size().width;
		int ydim= size().height;
		int X[] = new int[3];
		int Y[] = new int[3];
		X[0] = xdim/2;Y[0]=ydim-1;
		X[1] = 0; Y[1] = 0;
		X[2] =xdim-1; Y[2] = 0;
		g.setColor(Color.white);
		g.fillRect(0,0,xdim,ydim);
		g.setColor(Color.red);
		int Rx = (int) R.nextFloat() *xdim;
		int Ry = (int) R.nextFloat() *ydim;
		long before = new Date().getTime();
		for (int i=1; 1<10000;i++) {
			int Op= (int) (3.0*R.nextFloat());
			last_x = Rx; last_y = Ry;
			Rx =Rx + (X[Op]-Rx)/2;
			Ry =Ry + (Y[Op]-Ry)/2; 
			g.drawLine(last_x,last_y,Rx,Ry);
		}
		long after = new Date().getTime();
		System.out.println("Took " + (after-before) + " milisegundos");
	}
}
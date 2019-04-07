import java.awt.*;
import javax.swing.JApplet;

public class Applet78 extends JApplet implements MouseMotionListener {
	Dimension d;
	int coordX[] = {250,350,330,350,250,270,250};
	int coordY[] = {100,100,125,150,150,125,100};
	int puntos = 7;
	int posX = 0, posY=0;
	int memX = 0, memY=0;
	//
	public void init() {
		d = this.getSize();
		addMouseMotionListener(this);
	}
	//
	public void mouseDragged(MouseEvent me) {}
	//
	public void mouseMoved(MouseEvent me) {
		this.showStatus("Coordenadas en : " +me.getX() + ", " + me.getY());	
		posX = me.getX();
		posY = me.getY();
		this.repaint();
	}
	//
	public void update(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(0,posY,d.width-1,posY);
		g.drawLine(posX,0,posX,d.height-1);
		g.setColor(Color.white);
		if (memY != posY) {
			g.drawLine(0,memY,d.width-1,memY);
			memY = posY;
		}	
		if (memX != posX)	{
			g.drawLine(memX,0,memX,d.height-1);
			memX = posX;
		}
		g.setColor(Color.black);
		this.paint(g);
	}
	//
	public void update(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0,0,d.width-1,d.height-1);
		g.setColor(Color.black);
		g.drawLine(0,posY,d.width-1,posY);
		g.drawLine(posX,0,posX,d.height-1);
		this.paint(g);
	}
	//
	public void paint(Graphics g) {
		g.drawRect(0,0,d.width-1,d.height-1);
		g.drawLine(10,10,110,60);
		g.setColor(Color.green);
		g.fillRect(130,10,100,50);
		g.setColor(Color.orange);
		g.drawRoundRect(250,10,150,50,20,20);
		g.setColor(Color.blue);
		g.fillArc(10,100,100,50,90,270);
		g.setColor(Color.magenta);
		g.drawOval(130,100,100,50);
		g.setColor(Color.red);
		g.fillPolygon(coordX,coordY,puntos);
		g.setColor(Color.gray);
		g.drawString("Linea",10,80);
		g.drawString("Rectangulo sólido",130,80);
		g.drawString("Rectángulo redondeado",250,80);
		g.drawString("Arco sólido",10,170);
		g.drawString("Elipse",130,170);
		g.drawString("Un poligono propio",250,170);
		g.drawString("Este texto queda cortado", d.width-60,170);
	}
}
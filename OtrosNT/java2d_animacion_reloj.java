import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;

public class pnlReloj extends DBPanel implements KeyListener {
	private int hora = 0;
	private int minuto = 0;
	private int segundo = 0;
	private int mili = 0;
	private float radioH = 0.5f;
	private float radioM = 0.7f;
	private float radioS = 1.0f;
	//
	public pnlReloj() {
		super();
	}
	//
	public void actualizarEstado() {
		Calendar c = new GregorianCalendar();
		hora = c.get(Calendar.HOUR);
		minuto = c.get(Calendar.MINUTE);
		segundo = c.get(Calendar.SECOND);
		mili = c.get(Calendar.MILLISECOND);
	}
	//
	public void dibujarBuffer() {
		bufferG.clearRect(0,0,buffer.getWidth(),buffer.getHeight());
		int radio = (int)( Math.min(this.getWidth(),this.getHeight()) / 2 ) - 6;
		int radioHoras = (int)( radioH * radio );
		int radioMinutos = (int)( radioM * radio );
		int radioSegundos = (int)( radioS * radio );
		double radianes;
		int xCentro = (int)( this.getWidth() / 2 );
		int yCentro = (int)( this.getHeight() / 2 );
		int x;
		int y;
		radianes = (hora * 30 - 90) * Math.PI / 180 ; 
		x = (int)( Math.cos(radianes) * radioHoras + xCentro );
		y = (int)( Math.sin(radianes) * radioHoras + yCentro );
		bufferG.setColor(Color.RED);
		bufferG.drawLine(xCentro,yCentro,x,y);
		radianes = (minuto * 6 - 90) * Math.PI / 180 ;
		x = (int)( Math.cos(radianes) * radioMinutos + xCentro );
		y = (int)( Math.sin(radianes) * radioMinutos + yCentro );
		bufferG.setColor(Color.BLUE);
		bufferG.drawLine(xCentro,yCentro,x,y);
		radianes = ( ( segundo * 1000 + mili ) * 0.006 + - 90 ) * Math.PI / 180 ;
		x = (int)( Math.cos(radianes) * radioSegundos + xCentro );
		y = (int)( Math.sin(radianes) * radioSegundos + yCentro );
		bufferG.setColor(Color.GREEN);
		bufferG.drawLine(xCentro,yCentro,x,y);
	}
	//
	public void keyTyped(KeyEvent e) {
	}
	//
	public void keyPressed(KeyEvent e) {
		switch( e.getKeyCode() ) {
			case KeyEvent.VK_S: { 
				iniciar();
				System.out.println("INICIAR");
				break;
			}
		}
	}
	//
	public void keyReleased(KeyEvent e) {
	}
}
//
public class frmMain extends JFrame {
	private pnlReloj pnlReloj1 = new pnlReloj();
	private BorderLayout borderLayout1 = new BorderLayout();
	//
	public frmMain() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	private void jbInit() throws Exception {
		this.getContentPane().setLayout(borderLayout1);
		this.setSize( new Dimension(400, 300) );
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		pnlReloj1.setBackground(Color.white);
		this.getContentPane().add(pnlReloj1, BorderLayout.CENTER);
		this.addKeyListener(pnlReloj1);
	}
}
//
public class java2d_animacion_reloj {
	public static void main(String[] args) {
		frmMain m = new frmMain();
		m.setVisible(true);
	}
}
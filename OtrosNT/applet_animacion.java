import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Random;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class animationPanel extends DBPanel implements KeyListener {
	private Color mBackColor = Color.WHITE;
	private Color mColor = Color.BLACK;
	private int mNumeroDeLados = 5;
	private float offset = 0.0f;
	private boolean mHasCentricLines = false;
	private boolean mHasCloseLines = true;
	private int mRadio = 100 ;
	//
	public animationPanel() {
		this.addKeyListener(this);
	}
	//
	public void actualizarEstado() {
		offset += 0.01 ;
	}
	//
	public void dibujarBuffer() {
		try {
			Graphics2D g2 = this.bufferG;
			g2.setBackground(mBackColor);
			g2.clearRect(0, 0, this.getWidth(), this.getHeight());
			int xc = (int)(this.getWidth() / 2);
			int yc = (int)(this.getHeight() / 2);
			double radianes = 0.0d;
			double grados = 0.0d;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
			g2.setColor(mColor);
			int x = 0;
			int y = 0;
			int radio = mRadio;
			double paso = 360.0d / mNumeroDeLados;
			LinkedList<Point2D> puntos = new LinkedList<Point2D>();
			Point2D punto;
			while (grados < 360) {
				radianes = grados * Math.PI / 180;
				radianes += offset;
				x = (int)(Math.cos(radianes) * radio) + xc;
				y = (int)(Math.sin(radianes) * radio) + yc;
				punto = new Point2D.Float(x, y);
				puntos.add(punto);
				grados += paso;
				if (mHasCentricLines) {
					g2.drawLine(xc, yc, x, y);
				} else if (!mHasCloseLines) {
					g2.drawOval(x, y, 1, 1);
				}
			}
			if (mHasCloseLines) {
				GeneralPath p = new GeneralPath();
				if (puntos.size() > 0) {
					punto = puntos.get(0);
					p.moveTo((float)punto.getX(), (float)punto.getY());
					puntos.remove(punto);
					for (Point2D tmpPunto : puntos) {
						p.lineTo((float)tmpPunto.getX(),(float)tmpPunto.getY());
					}
					p.closePath();
				}
				g2.draw(p);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	private Random r = new Random();
	//
	private Color getRandColor() {
		return new Color( r.nextInt(255), r.nextInt(255), r.nextInt(255) );
	}
	//
	public void keyTyped(KeyEvent e) {}
	//
	public void keyPressed(KeyEvent e) {
		if( e.getKeyCode() == KeyEvent.VK_C ) {
			this.mBackColor = getRandColor();
			this.mColor = getRandColor();
		}
		else if( e.getKeyCode() == KeyEvent.VK_UP ) {
			this.mNumeroDeLados++;
		}
		else if( e.getKeyCode() == KeyEvent.VK_DOWN ) {
			this.mNumeroDeLados--;
		}
		else if( e.getKeyCode() == KeyEvent.VK_A ) {
			this.mRadio++;
		}
		else if( e.getKeyCode() == KeyEvent.VK_Z ) {
			this.mRadio--;
		}
		else if( e.getKeyCode() == KeyEvent.VK_D ) {
			this.mHasCentricLines = ! this.mHasCentricLines ;
		}
		else if( e.getKeyCode() == KeyEvent.VK_L ) {
			this.mHasCloseLines = ! this.mHasCloseLines ;
		}
	}
	//
	public void keyReleased(KeyEvent e) {}
}
//
public class animationApplet extends Applet {
	private animationPanel mPanel = new animationPanel();
	//
	public animationApplet() {
		this.setLayout(new BorderLayout());
		this.add( mPanel , BorderLayout.CENTER );
		mPanel.iniciar();
		this.addKeyListener(mPanel);
	}
}
//
public class DBPanel extends JPanel implements Runnable {
	protected BufferedImage buffer = null;
	protected Graphics2D bufferG = null;
	protected int frameRate = 30;
	protected int delay = 20;
	protected volatile boolean isRunning = false;
	protected Thread animador = null;
	//
	public void iniciar() {
		if( animador == null || ! isRunning ) {
			animador = new Thread(this);
			isRunning = true;
			animador.start();
		}
	}
	//
	public void parar() {
		isRunning = false;
	}
	//
	public DBPanel() {
		try {
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	private void jbInit() throws Exception {
		this.setLayout( null );
		this.setIgnoreRepaint(true);
		this.addComponentListener(new ResizeListener());
	}
	//
	public void crearBuffer() {
		try {
			BufferedImage tmpBuffer = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_RGB);
			Graphics2D tmpBufferG = tmpBuffer.createGraphics();
			tmpBufferG.setBackground(this.getBackground());
			tmpBufferG.clearRect(0,0,tmpBuffer.getWidth(),tmpBuffer.getHeight());
			if( buffer != null && bufferG != null ) {
				tmpBufferG.drawImage(buffer,0,0,null);
				bufferG.dispose();
			} 
			buffer = tmpBuffer;
			bufferG = tmpBufferG;
			System.out.println("Buffer Creado Con Exito.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	public void run() {
		while( isRunning ) {
			try {
				actualizarEstado();
				dibujarBuffer();
				dibujar();    
				System.out.println("running...");
				try  {
					animador.sleep(delay);
				}
				catch (Exception ex)  {
					ex.printStackTrace();
				}
				finally  {}    
			}
			catch (Exception e) {
				System.out.println("error pequeño");
				e.printStackTrace();
			}
		}
	}
	//
	public void dibujarBuffer() {}
	public void actualizarEstado() {}
	//
	public void dibujar() {
		Graphics2D g = (Graphics2D)this.getGraphics();
		if( g != null && buffer != null ) {
			g.drawImage(buffer,0,0,null);
		}
	}
	//
	public void setFrameRate(int frameRate) {
		this.frameRate = frameRate;
		try {
			delay = 1000 / frameRate ;
		}
		catch (Exception ex)  {
			ex.printStackTrace();
			delay = 20;
		}
		finally  {}
	}
	//
	public int getFrameRate() {
		return frameRate;
	}
	//
	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	//
	public boolean isIsRunning() {
		return isRunning;
	}
	//
	protected void sizeChange() {}
	//
	class ResizeListener extends ComponentAdapter {
		public void componentResized(ComponentEvent e) {
			try {
				crearBuffer();
				sizeChange();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
//
public class applet_animacion {
	public applet_animacion() {}
	//
	public static void main(String[] args) {
		System.out.println("applet");
		JFrame f = new JFrame();
		f.setSize(200, 200);
		f.setLayout(new BorderLayout());
		animationApplet a = new animationApplet();
		f.add( a , BorderLayout.CENTER );
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setVisible(true);
	}
}
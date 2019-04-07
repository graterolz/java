import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class frmMain extends JFrame {
	private GamePanel gamePanel1 = new GamePanel();
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
		this.getContentPane().add(gamePanel1, BorderLayout.CENTER);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.addKeyListener(gamePanel1);
	}
}
//
public class GamePanel extends JPanel implements Runnable, KeyListener {
	private Thread mAnimator = null;
	private volatile boolean isRunning = false;
	private volatile boolean isOver = false;
	private Color mColor = Color.WHITE;
	private Timer mFrameRateTimer = new Timer(1000,new FrameRateListener());
	private volatile int mNumeroDeFrames;
	private BufferedImage backBuffer = null;
	private Graphics2D backBufferG = null;
	private int anchoAnterior = 0;
	private int altoAnterior = 0;
	private Ball pelota = null;
	private Ball pelota2 = null;
	private long segundos = 0;
	//
	public GamePanel() {
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
	}
	//
	public void createBackBuffer() {
		backBuffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		backBufferG = backBuffer.createGraphics();
	}
	//
	public void drawBackBuffer() {
		if( backBufferG != null ) {
			backBufferG.setBackground(mColor);
			backBufferG.clearRect(0,0,backBuffer.getWidth(),backBuffer.getHeight());
			pelota.dibujar(backBufferG);
			pelota2.dibujar(backBufferG);
		}
	}
	//	
	public void start() {
		if( mAnimator == null || !isRunning ) {
			pelota = new Ball( 100 , 100 );
			pelota.setDireccion((float)1.2);
			pelota.setVelocidad((float)5.0);;
			pelota2 = new Ball( 120 , 100 );
			pelota2.setMColor(Color.BLUE);
			pelota2.setDireccion((float)1.2);
			pelota2.setVelocidad((float)10.0);;
			isRunning = true;
			mAnimator = new Thread(this);
			mAnimator.start();
			mFrameRateTimer.start();
		}
	}
	//
	public void paintState() {
		Graphics2D g = (Graphics2D)this.getGraphics();
		if( g != null ) {
			if (anchoAnterior != this.getWidth() || 
				altoAnterior != this.getHeight()) {
				createBackBuffer();
				anchoAnterior = this.getWidth();
				altoAnterior = this.getHeight();
			}
			drawBackBuffer();
			g.drawImage(backBuffer,0,0,null);
		}
	}
	//
	public void updateState() {
		if( segundos == 5 ) {
			int g = (int)(Math.random() * 255);
			int b = (int)(Math.random() * 255);
			int r = (int)(Math.random() * 255);
			pelota.setMColor(new Color(r,g,b));
			g = (int)(Math.random() * 255);
			b = (int)(Math.random() * 255);
			r = (int)(Math.random() * 255);
			pelota2.setMColor(new Color(r,g,b));
			segundos = 0 ;
		}
		pelota.rotar( (int)( Math.random() * 5 ));
		pelota2.rotar( (int)( Math.random() * 2 ));
		pelota.setRegion(0,0,this.getWidth(),this.getHeight());
		pelota2.setRegion(0,0,this.getWidth(),this.getHeight());
		pelota.mover();
		pelota2.mover();
	}
	//
	public void run() {
		while( isRunning ) {
			updateState();
			paintState();
			mNumeroDeFrames ++;
			try  {
				mAnimator.sleep(33);   
			}
			catch (Exception ex)  {
				ex.printStackTrace();
			}
			finally  {}
		}
	}
	//
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		switch( e.getKeyCode() ) {
			case KeyEvent.VK_S: {
				start();
			}
		}
	}
	//
	public void keyReleased(KeyEvent e) {}
	//
	class FrameRateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("FPS: " + mNumeroDeFrames);
			mNumeroDeFrames = 0;
			segundos++;
		}
	}
}
//
public class Ball {
	private int x = 0;
	private int y = 0;
	private int diametro = 10;
	private int radio = 5;
	private float direccion = 0.0f;
	private float velocidad = 14.0f;
	private Color mColor = Color.RED;
	private int minX = 0;
	private int minY = 0;
	private int maxX = 0;
	private int maxY = 0;
	//
	public void setRegion(int minx, int miny, int maxx, int maxy ) {
		minX = minx;
		minY = miny;
		maxX = maxx;
		maxY = maxy;
	}
	//
	public Ball(int xi, int yi) {
		x = xi;
		y = yi;
	}
	//
	public void rotar(int pGrados) {
		direccion += (double)(pGrados * Math.PI / 180);
	}
	//
	public void mover() {
		int tmpx = x;
		int tmpy = y;
		x += (int)(Math.cos(direccion) * velocidad);
		y += (int)(Math.sin(direccion) * velocidad);
		if( x >= ( maxX - radio ) || x <= ( minX + radio ) ) {
			direccion = (float)( Math.PI - direccion);
			x = tmpx + (int)(Math.cos(direccion) * velocidad);
			y = tmpy + (int)(Math.sin(direccion) * velocidad);
		}
		if( y >= ( maxY - radio ) || y <= ( minY + radio ) ) {
			direccion = (float)( 2 * Math.PI - direccion );
			x = tmpx + (int)(Math.cos(direccion) * velocidad);
			y = tmpy + (int)(Math.sin(direccion) * velocidad);
		}
	}
	//
	public void dibujar(Graphics2D g) {
		g.setColor(mColor);
		g.fillOval(x - radio, y - radio, diametro, diametro);
	}
	//
	public void setX(int x) {
		this.x = x;
	}
	//
	public int getX() {
		return x;
	}
	//
	public void setY(int y) {
		this.y = y;
	}
	//
	public int getY() {
		return y;
	}
	//
	public void setDireccion(float direccion) {
		this.direccion = direccion;
	}
	//
	public float getDireccion() {
		return direccion;
	}
	//
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	//
	public float getVelocidad() {
		return velocidad;
	}
	//
	public void setMColor(Color mColor) {
		this.mColor = mColor;
	}
	//
	public Color getMColor() {
		return mColor;
	}
}
//
public class animacion_java2d_pelotas {
	public animacion_java2d_pelotas() {}
	//
	public static void main(String[] args) {
		System.out.println("Java 2D Test 1");
		frmMain m = new frmMain();
		m.setVisible(true);
	}
}
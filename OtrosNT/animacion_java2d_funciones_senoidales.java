import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

public class Ball {	
	private float mAnguloActual = 0.0f;
	private float mAnguloDelta = 0.01f;
	private int mRadioMax = 100 ; 
	private int mRadioBola = 5;
	private int mX = 0;
	private int mY = 0;
	private int mK = 5;
	private int mXOffset = 0;
	private int mYOffset = 0;
	private Color mColor = Color.red;
	double maxAngle = Math.PI ;
	double angleOffset = 1.0;
	//
	public Ball() {}
	//	
	public void actualizarEstado() {
		mAnguloActual += mAnguloDelta;
		double r = Math.cos( (double)mK * ( mAnguloActual - angleOffset ) );
		double radio = r * (double)mRadioMax ;
		mX = (int)( Math.cos( mAnguloActual) * radio );
		mY = (int)( Math.sin( mAnguloActual) * radio );
		mX += mXOffset;
		mY += mYOffset;
	}
	//
	public void dibujarse( Graphics g ) {
		g.setColor(mColor);
		g.fillOval(mX, mY, mRadioBola*2, mRadioBola*2);
	}
	//
	public void setAnguloDelta(float mAnguloDelta) {
		this.mAnguloDelta = mAnguloDelta;
	}
	//
	public float getAnguloDelta() {
		return mAnguloDelta;
	}
	//
	public void setRadioMax(int mRadioMax) {
		this.mRadioMax = mRadioMax;
	}
	//
	public int getRadioMax() {
		return mRadioMax;
	}
	//
	public void setRadioBola(int mRadioBola) {
		this.mRadioBola = mRadioBola;
	}
	//
	public int getRadioBola() {
		return mRadioBola;
	}
	//
	public int getX() {
		return mX;
	}
	//
	public int getY() {
		return mY;
	}
	//
	public void setK(int mK) {
		this.mK = mK;
	}
	//
	public int getK() {
		return mK;
	}
	//
	public void setXOffset(int mXOffset) {
		this.mXOffset = mXOffset;
	}
	//
	public int getXOffset() {
		return mXOffset;
	}
	//
	public void setYOffset(int mYOffset) {
		this.mYOffset = mYOffset;
	}
	//
	public int getYOffset() {
		return mYOffset;
	}
	//
	public void setColor(Color mColor) {
		this.mColor = mColor;
	}
	//
	public Color getColor() {
		return mColor;
	}
}
//
public class DBPanel extends JPanel implements Runnable {
	protected BufferedImage buffer = null;
	protected Graphics2D bufferG = null;
	protected int frameRate = 10;
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
		} catch (Exception e) {
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
	//
	public void run() {
		while( isRunning ) {
			actualizarEstado();
			dibujarBuffer();
			dibujar();
			try {
				animador.sleep(delay);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			finally { }
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
		catch (Exception ex) {
			ex.printStackTrace();
			delay = 20;
		}
		finally {}
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
	class ResizeListener extends ComponentAdapter {
		public void componentResized(ComponentEvent e) {
			crearBuffer();
		}
	}
}
//
public class frmMain extends JFrame {
	private MathFuncPanel mPanel = new MathFuncPanel();
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
		this.setSize(new Dimension(400, 300));
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		mPanel.setBackground(Color.white);
		this.getContentPane().add(mPanel, BorderLayout.CENTER);
		this.addKeyListener(mPanel);
	}
}
//
public class MathFuncPanel extends DBPanel implements KeyListener {
	private LinkedList<Ball> mElementos = new LinkedList<Ball>();
	private boolean mLimpiarFondo = true;
	int ultimoK = 5;
	//
	public MathFuncPanel() {
		try {
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	private void jbInit() throws Exception {
		this.setLayout(null);
	}
	//
	public void keyTyped(KeyEvent e) {}
	//
	public void actualizarEstado() {
		for (Ball e : mElementos) {
			e.actualizarEstado();
		}
	}
	//
	public void dibujarBuffer() {
		if (mLimpiarFondo) {
			this.bufferG.clearRect(0, 0, buffer.getWidth(),buffer.getHeight());
		}
		for (Ball e : mElementos) {
			e.dibujarse(this.bufferG);
		}
	}
	//
	private void iniciarFunc() {
		if (isRunning) {
			return;
		}
		Ball b = new Ball();
		int mx = (int)(this.getWidth() / 2.0);
		int my = (int)(this.getHeight() / 2.0);
		b.setXOffset(mx);
		b.setYOffset(my);
		mElementos.add(b);
		this.iniciar();
	}
	//
	public Color getRandColor() {
		int r = (int)(Math.random() * 255);
		int g = (int)(Math.random() * 255);
		int b = (int)(Math.random() * 255);
		return new Color(r, g, b);
	}
	//
	void agregarBola() {
		Ball b = new Ball();
		b.setColor(getRandColor());
		Random r = new Random();
		b.setAnguloDelta((float)Math.pow(-1, r.nextInt(2)) * r.nextInt(10) * 0.002f + 0.002f);
		ultimoK = r.nextInt(7) + 1;
		b.setK(ultimoK);
		b.setRadioMax(Math.min(this.getWidth(), this.getHeight()) / 2);
		int mx = (int)(this.getWidth() / 2.0);
		int my = (int)(this.getHeight() / 2.0);
		b.setXOffset(mx);
		b.setYOffset(my);
		mElementos.add(b);
	}
	//
	void agregarBola2() {
		Ball b = new Ball();
		b.setColor(getRandColor());
		Random r = new Random();
		b.setAnguloDelta((float)Math.pow(-1, r.nextInt(2)) * r.nextInt(10) * 0.002f + 0.002f);
		b.setK(ultimoK);
		b.setRadioMax(Math.min(this.getWidth(), this.getHeight()) / 2);
		int mx = (int)(this.getWidth() / 2.0);
		int my = (int)(this.getHeight() / 2.0);
		b.setXOffset(mx);
		b.setYOffset(my);
		mElementos.add(b);
	}
	//
	void cambiarColores() {
		for (Ball e : mElementos) {
			e.setColor(getRandColor());
		}
	}
	//
	void quitarBola() {
		if (mElementos.size() > 1) {
			mElementos.removeLast();
		}
	}
	//
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_S: {
				iniciarFunc();
				break;
			}
			case KeyEvent.VK_F: {
				mLimpiarFondo = !mLimpiarFondo;
				break;
			}
			case KeyEvent.VK_R: {
				quitarBola();
				break;
			}
			case KeyEvent.VK_C: {
				cambiarColores();
				break;
			}
			case KeyEvent.VK_A: {
				agregarBola();
				break;
			}
			case KeyEvent.VK_Q: {
				agregarBola2();
				break;
			}
		}
	}
	//
	public void keyReleased(KeyEvent e) {}
}
//
public class animacion_java2d_funciones_senoidales {
	public animacion_java2d_funciones_senoidales() {}
	//
	public static void main(String[] args) {
		System.out.println("java2d demo 1");
		frmMain m = new frmMain();
		m.setVisible(true);
	}
}

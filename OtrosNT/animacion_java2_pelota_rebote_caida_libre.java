import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

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
	LinkedList<Ball> finalizadas = new LinkedList<Ball>();
	//
	public void actualizarEstado() {
		boolean fuera = false; 
		finalizadas.clear();
		for (Ball e : mElementos) {
			e.actualizarEstado();
			if( e.isOutOfArea() ) {
				fuera = true; 
				finalizadas.add(e);
			}
		}
		for( Ball e : finalizadas ) {
			mElementos.remove(e);
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
		b.setH( this.getHeight() );
		b.setArea(this);
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
		b.setH( this.getHeight() );
		b.setArea(this);
		b.setColor(getRandColor());
		Random r = new Random();
		b.setVX( ( r.nextDouble() + 0.5 ) * 2 );
		b.setK( ( r.nextDouble() * 0.5 ) + 0.1 );
		b.setAY( ( r.nextDouble() * 0.5 ) + 0.1 );
		b.setRadioBola( r.nextInt(10) + 2 );
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
		}
	}
	//
	public void keyReleased(KeyEvent e) {}
}
//
public class frmMain extends JFrame {
	private MathFuncPanel mPanel = new MathFuncPanel();
	private BorderLayout borderLayout1 = new BorderLayout();
	//
	public frmMain() {
		try {
			jbInit();
		}
		catch (Exception e) {
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
			finally {}
		}
	}
	//
	public void dibujarBuffer() {}
	//
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
public class Ball {	
	private int mRadioBola = 5;
	private float mX = 0;
	private float mY = 0;
	private double mVY = 0 ;
	private double mAY = 0.2 ;
	private double mVX = 1 ;
	private int mH = 100;
	private Color mColor = Color.red;
	private Component mArea = null;
	private int mDireccion = 1 ;
	private boolean mFin = false;
	private boolean mOutOfArea = false;
	private double mK = 0.1;
	//
	public Ball() {
	 
	}
	//
	public void actualizarEstado() {
		if( mFin || mOutOfArea ) {
			return;
		}
		mX += mVX ;
		if( mDireccion == 1 ){
			mY -= mVY;
			if( mY < mRadioBola*2 ) {
				//mY = 0 ;
				mDireccion = 2;
				double delta = (double) mVY * mK ;
				System.out.println("Delta -" + delta );
				System.out.println("VY " + mVY );
				double newVY = mVY - (delta+0.01) ;
				if( delta < 0.1 ) {
					mFin = true;
				}
				System.out.println("NEW VY " + newVY );
				mVY = (float)newVY;
			}
			else {
				mVY += mAY;
			}
		}
		else if( mDireccion == 2 ) {
			mY += mVY;
			mVY -= mAY;
			if( mVY < 0 ) {
				//mVY = 0;
				mDireccion = 1; 
			}
		}
	}
	//
	public void dibujarse( Graphics g ) {
		g.setColor(mColor);
		g.fillOval((int)mX, (int)( mH - mY ), mRadioBola*2, mRadioBola*2);
		int y = (int)( mH - mY );
		if( mX > mArea.getWidth() || mX < 0 ) {
			mOutOfArea = true;
		}
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
		return (int)mX;
	}
	//
	public int getY() {
		return (int)mY;
	}
	//
	public void setColor(Color mColor) {
		this.mColor = mColor;
	}
	//
	public Color getColor() {
		return mColor;
	}
	//
	public void setArea(Component mArea) {
		this.mArea = mArea;
	}
	//
	public Component getArea() {
		return mArea;
	}
	//
	public void setH(int mH) {
		this.mY = mH;
		this.mH = mH;
	}
	//
	public int getH() {
		return mH;
	}
	//
	public void setVY(double mVY) {
		this.mVY = mVY;
	}
	//
	public double getVY() {
		return mVY;
	}
	//
	public void setAY(double mAY) {
		this.mAY = mAY;
	}
	//
	public double getAY() {
		return mAY;
	}
	//
	public void setVX(double mVX) {
		this.mVX = mVX;
	}
	//
	public double getVX() {
		return mVX;
	}
	//
	public boolean isOutOfArea() {
		return mOutOfArea || mFin ;
	}
	//
	public void setK(double mK) {
		this.mK = mK;
	}
	//
	public double getK() {
		return mK;
	}
}
//
public class Main {
	public Main() {}
	//
	public static void main(String[] args) {
		System.out.println("java2d demo 1");
		frmMain m = new frmMain();
		m.setVisible(true);
	}
}
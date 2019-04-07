import java.awt.geom.Point2D;
import java.util.Random;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Color;
import static org.lwjgl.opengl.GL11.*;
import java.io.File;

public class TestGame {
	private Color c = new Color(Color.BLUE);
	private int fps;
	private long lastFPS;
	private Random r = new Random();
	private float mAngulo = 0.0f;
	private float mVelocidadAngular = 0.0f;
	private float mOffsetAngulo = 0.0f;
	private float mVelocidadOffet = 0.0f;
	private int mNumeroDePuntos = 3;
	private float mA = 3.0f;
	//
	public TestGame() {
		super();
	}
	//
	public void init() {
		try {
			Display.setDisplayMode(new DisplayMode(600, 600));
			Display.create();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 600, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		glPointSize(5.0f);
		lastFPS = getTime();
	}
	//
	public void loop() {
		while (!Display.isCloseRequested()) {
			pollInput();
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glColor3b(c.getRedByte(), c.getBlueByte(), c.getGreenByte());
			glBegin(GL_POINTS);
			float angulo = this.mAngulo;
			float step = (float)(2.0 * Math.PI / this.mNumeroDePuntos);
			int radio = 290;
			while (angulo < this.mAngulo + 2.0 * Math.PI) {
				float r = (float)Math.sin(this.mA * angulo + this.mOffsetAngulo) * radio;
				int x = 300 + (int)(r * Math.cos(angulo));
				int y = 300 + (int)(r * Math.sin(angulo));
				float R = (float)Math.abs( Math.cos( angulo) );
				float B = (float)Math.abs( Math.sin( angulo ) );
				float G = (float)Math.abs( Math.sin( angulo + Math.PI/3.0 ) );
				glColor3f(R, G, B);
				glVertex2f(x, y);
				angulo += step;
			}
			glEnd();
			this.mAngulo += this.mVelocidadAngular;
			this.mOffsetAngulo += this.mVelocidadOffet;
			Display.update();
			Display.sync(60);
			updateFPS();
		}
		Display.destroy();
	}
	//
	private double distanciaAlMouse(Point2D pPunto) {
		double y = 600 - Mouse.getY();
		return Math.sqrt(Math.pow((pPunto.getX() - Mouse.getX()), 2.0) + Math.pow((pPunto.getY() - y), 2.0));
	}
	//
	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	//
	private void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
	//
	private void pollInput() {
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_B) {
					glClearColor(r.nextFloat(), r.nextFloat(), r.nextFloat(), 1.0f);
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_C) {
					c.set(r.nextInt(255), r.nextInt(255), r.nextInt(255));
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
					Display.destroy();
					System.exit(0);
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_A) {
					this.mNumeroDePuntos += 10;
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_Z) {
					if (this.mNumeroDePuntos > 0) {
						this.mNumeroDePuntos -= 10;
					}
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_S) {
					this.mA += 0.1f;
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_X) {
					if (this.mA > 0) {
						this.mA -= 0.1f;
					}
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_F) {
					this.mVelocidadOffet += 0.001;
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_V) {
					this.mVelocidadOffet -= 0.001;
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_Q) {
					this.mVelocidadAngular += 0.0001;
				}
				else if (Keyboard.getEventKey() == Keyboard.KEY_W) {
					this.mVelocidadAngular -= 0.0001;
				}
			}
		}
		if (Mouse.isButtonDown(0)) {

		}
	}
}
//
public class Main {
	public Main() {
		super();
	}
	//
	public static void main(String[] args) {
		System.out.println("prueba LWJGL");
		TestGame t = new TestGame();
		t.init();
		t.loop();
	}
}
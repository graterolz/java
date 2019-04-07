import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.LinkedList;
import java.util.Random;

public class ColorChanger extends Thread {
	private LinkedList<JPanel> mPaneles = new LinkedList<JPanel>();	
	private Random r = new Random();
	//
	public void agregarPanel( JPanel pPanel ) {
		mPaneles.add( pPanel );
	}
	//
	private Color getRandColor() {
		return new Color( r.nextInt(255), r.nextInt(255) ,r.nextInt(255) );
	}
	//
	public ColorChanger() {
		super();
	}
	//
	public void run() {
		try {
			while( true ) {
				for( int i = 0 ; i < mPaneles.size(); i++ ) {
					JPanel actual = mPaneles.get(i);
					actual.setBackground( getRandColor() );
				}
				Thread.sleep(1000);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//
public class java_uso_thread_animacion {
	public java_uso_thread_animacion() {
		super();
	}
	//
	public static void main(String[] args) {
		System.out.println("main");
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}
//
public class MainFrame extends JFrame {
	private JPanel mPanelA = null ;
	private JPanel mPanelB = null ;
	private ColorChanger mCG = null ;
	//
	public MainFrame() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	private void jbInit() throws Exception {
		this.getContentPane().setLayout( new FlowLayout() );
		this.setSize( new Dimension(400, 300) );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mPanelA = new JPanel();
		mPanelB = new JPanel();
		mPanelA.setPreferredSize(new Dimension(100,100));
		mPanelB.setPreferredSize(new Dimension(100,100));
		mPanelA.setBackground(Color.GREEN);
		mPanelB.setBackground(Color.BLUE);
		this.add( mPanelA );
		this.add( mPanelB );
		mCG = new ColorChanger();
		mCG.agregarPanel(mPanelA);
		mCG.agregarPanel(mPanelB);
		mCG.start();
	}
}
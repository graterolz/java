import java.awt.Dimension;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javazoom.jl.player.* ;

public class MainFrame extends JFrame {
	private PlayerThread elReproductor = null ;
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
		this.getContentPane().setLayout( null );
		this.setSize( new Dimension(400, 300) );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFileChooser f = new JFileChooser();
		int dialog = f.showOpenDialog(this);
		File file = f.getSelectedFile() ; 
		elReproductor = new PlayerThread( file.getAbsolutePath() );
		elReproductor.start();
	}
}
//
public class PlayerThread extends Thread {	
	private jlp mReproductor = null ;
	//
	public PlayerThread( String pFileName ) {
		try {
			String [] args = new String[1];
			args[0] = pFileName ;
			mReproductor = jlp.createInstance( args );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	public void run() {
		try {
			while(true) {
				mReproductor.play();
				Thread.sleep(1000);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//
public class musica_de_fondo_mp3 {
	public musica_de_fondo_mp3() {
		super();
	}
	//
	public static void main(String[] args) {
		System.out.println("main");
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}
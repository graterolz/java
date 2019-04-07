import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private JMenuBar jMenuBar1 = new JMenuBar();
	private JMenu jMenu1 = new JMenu();
	private JMenuItem jMenuItem1 = new JMenuItem();
	private ImagePanel mPanel = new ImagePanel();
	private JMenuItem jMenuItem2 = new JMenuItem();
	private boolean mCaptura = false;
	//
	public MainFrame() {
		try {
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	private void jbInit() throws Exception {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.setSize(new Dimension(400, 300));
		this.setTitle("Capura de Pantalla");
		this.setJMenuBar(jMenuBar1);
		jMenu1.setText("Archivo");
		jMenuItem1.setText("Capturar");
		jMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem1_actionPerformed(e);
			}
		});
		jMenuItem2.setText("Guardar");
		jMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItem2_actionPerformed(e);
			}
		});
		jMenu1.add(jMenuItem1);
		jMenu1.add(jMenuItem2);
		jMenuBar1.add(jMenu1);
		JScrollPane area = new JScrollPane(mPanel);
		this.add(area, BorderLayout.CENTER);
	}
	//
	private void jMenuItem1_actionPerformed(ActionEvent e) {
		try {
			Robot r = new Robot();
			Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage temp = r.createScreenCapture(screenSize);
			this.mPanel.setImagen(temp);
			mPanel.repaint();
			mCaptura = true;
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	//
	private void jMenuItem2_actionPerformed(ActionEvent e) {
		if (!mCaptura) {
			return;
		}
		try {
			JFileChooser f = new JFileChooser();
			if (f.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File temp = f.getSelectedFile();
				String path = temp.getAbsolutePath() ;
				if( path.indexOf('.') == -1 ) {
					path = path + ".png";
				} else if( path.toLowerCase().contains("png") == false ){
					path = path.replace(".", "");
					path = path + ".png";
				}
				mPanel.guardarImagenEnArchivo( path );
				Desktop.getDesktop().open(new File(path));
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
//


public class ImagePanel extends JPanel {

	private BufferedImage mImagen = null;

	public ImagePanel() {
		super();
	}

	public boolean guardarImagenEnArchivo(String pPath) {

		try {
			
			if( mImagen == null ) {
				return false;
			}
			
			
			
			FileOutputStream s = new FileOutputStream( pPath );
			
			ImageIO.write(mImagen, "png", s );
			
			s.close();
			
			return true; // ok 
		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
		}
	
		return false;
		
	}

	public void paint(Graphics g) {

		super.paint(g);

		if (mImagen != null) {

			try {

				g.drawImage(mImagen, 0, 0, this.getWidth(), this.getHeight(),
							null);

			} catch (Exception e) {
				// TODO: Add catch code
				e.printStackTrace();
			}

		}

	}

	public void setImagen(BufferedImage mImagen) {
		this.mImagen = mImagen;
	}

	public BufferedImage getImagen() {
		return mImagen;
	}
}
//
public class captura_pantalla {
	public captura_pantalla() {
		super();
	}
	//
	public static void main(String[] args) {
		System.out.println("main");
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}
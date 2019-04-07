import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
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
		JPanel principal = new JPanel(); 
		try {
			URL imagen = MainFrame.class.getResource("imagenes/we.jpg");
			BufferedImage img = ImageIO.read(imagen);
			BgBorder borde = new BgBorder( img );
			principal.setBorder(borde);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		this.setContentPane(principal);
	}
}
//
public class BgBorder implements Border {
	private BufferedImage mImagen = null;
	//
	public BgBorder(BufferedImage pImagen) {
		mImagen = pImagen;
	}
	//
	public void paintBorder(Component c, Graphics g, int x, int y, int width,int height) {
		if (mImagen != null) {
			g.drawImage(mImagen, 0, 0, width, height, null);
		}
	}
	//
	public Insets getBorderInsets(Component c) {
		return new Insets(0, 0, 0, 0);
	}
	//
	public boolean isBorderOpaque() {
		return true;
	}
}
//
public class jpanel_imagen_fondo {
	public jpanel_imagen_fondo() {}
	//
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible( true );
	}
}
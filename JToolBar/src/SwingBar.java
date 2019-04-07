import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SwingBar extends JFrame {
	public static int WIDTH = 300;
	public static int HEIGHT = 300;
	public static String TITLE = "SwingMenu.- Aguilar Calderon Jose Alfonso.";
	Container frameContainer;
	JToolBar toolBar=new JToolBar();
	String [] iconFiles= {"new.gif","open.gif","save.gif","cut.gif","copy.gif","paste.gif"	};
	String[] labelBoton= {"New","Open","Save","Cut","Copy","Paste"};
	ImageIcon[] icons =new ImageIcon[iconFiles.length];
	JButton[] botones = new JButton [labelBoton.length];
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem fileExit = new JMenuItem("Exit");
	//
	public SwingBar() {
		super(TITLE);
		construirGUI();
		setupEventHandlers();
		setSize(WIDTH,HEIGHT);
		show();
	}
	//
	void construirGUI() {
		setupMenuBar();
		layoutComponents();
	}
	//
	void setupMenuBar() {
		fileMenu.add(fileExit);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}
	//
	public void layoutComponents() {
		frameContainer = getContentPane();
		frameContainer.setLayout(new BorderLayout());
		for(int i =0;i<labelBoton.length; ++i) {
			icons[i]= new ImageIcon(iconFiles[i]);
			botones[i]= new JButton(icons[i]);
			botones[i].setToolTipText(labelBoton[i]);
			if (i==3)toolBar.addSeparator();
			toolBar.add(botones[i]);
		}
		frameContainer.add("North",toolBar);
	}
	//
	void setupEventHandlers() {
		addWindowListener(new WindowHandler());
		fileExit.addActionListener(new MenuItemHandler());
	}
	//
	public static void main(String[] args) {
		SwingBar aplicacion = new SwingBar();
	}
	//
	public class WindowHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	//
	public class MenuItemHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd= e.getActionCommand();
			if (cmd.equals("Exit"))System.exit(0);
		}
	}
}
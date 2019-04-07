import java.awt.*;
import javax.swing.*;

public class Class54 extends JPanel {
	private static final int COLOR_POSITION = 0;
	private static final int STRING_POSITION = 1;
	//
	static Object buttonColors[][] = {
		{ Color.red, "red" },
		{ Color.blue, "blue" },
		{ Color.green, "green" },
		{ Color.black, "black" }, null,
		{ Color.cyan, "cyan" }
	};
	//
	public static void main(String args[]) {
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println(actionEvent.getActionCommand());
			}
		};
		JFrame frame = new JFrame("JToolBar Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JToolBar toolbar = new JToolBar();
		toolbar.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
		for (int i = 0, n = buttonColors.length; i < n; i++) {
			Object color[] = buttonColors[i];
			if (color == null) {
				toolbar.addSeparator();
			}
			else {
				Icon icon = new DiamondIcon((Color) color[COLOR_POSITION],true, 20, 20);
				JButton button = new JButton(icon);
				button.setActionCommand((String) color[STRING_POSITION]);
				button.addActionListener(actionListener);
				toolbar.add(button);
			}
		}
		Action action = new ActionMenuSample.ShowAction(frame);
		toolbar.add(action);
		Container contentPane = frame.getContentPane();
		contentPane.add(toolbar, BorderLayout.NORTH);
		JTextArea textArea = new JTextArea();
		JScrollPane pane = new JScrollPane(textArea);
		contentPane.add(pane, BorderLayout.CENTER);
		frame.setSize(350, 150);
		frame.setVisible(true);
	}
}
//
class DiamondIcon implements Icon {
	private Color color;
	private boolean selected;
	private int width;
	private int height;
	private Polygon poly;
	private static final int DEFAULT_WIDTH = 10;
	private static final int DEFAULT_HEIGHT = 10;
	//
	public DiamondIcon(Color color) {
		this(color, true, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	//
	public DiamondIcon(Color color, boolean selected) {
		this(color, selected, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	//
	public DiamondIcon(Color color, boolean selected, int width, int height) {
		this.color = color;
		this.selected = selected;
		this.width = width;
		this.height = height;
		initPolygon();
	}
	//
	private void initPolygon() {
		poly = new Polygon();
		int halfWidth = width / 2;
		int halfHeight = height / 2;
		poly.addPoint(0, halfHeight);
		poly.addPoint(halfWidth, 0);
		poly.addPoint(width, halfHeight);
		poly.addPoint(halfWidth, height);
	}
	//
	public int getIconHeight() {
		return height;
	}
	//
	public int getIconWidth() {
		return width;
	}
	//
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.translate(x, y);
		if (selected) {
			g.fillPolygon(poly);
		}
		else {
			g.drawPolygon(poly);
		}
		g.translate(-x, -y);
	}
}
//
class ActionMenuSample {
	public static class ShowAction extends AbstractAction {
		Component parentComponent;
		//
		public ShowAction(Component parentComponent) {
			super("About");
			putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_A));
			this.parentComponent = parentComponent;
		}
		//
		public void actionPerformed(ActionEvent actionEvent) {
			Runnable runnable = new Runnable() {
				public void run() {
					JOptionPane.showMessageDialog(parentComponent,"About Life", "About Box V1.0",JOptionPane.INFORMATION_MESSAGE);
				}
			};
			SwingUtilities.invokeLater(runnable);
		}
	}
	//
	public static void main(String args[]) {
		JFrame frame = new JFrame("Action Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Action showAction = new ShowAction(frame);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('f');
		JMenuItem newMenuItem = new JMenuItem("New", 'N');
		fileMenu.add(newMenuItem);
		JMenuItem openMenuItem = new JMenuItem("Open", 'O');
		fileMenu.add(openMenuItem);
		JMenuItem closeMenuItem = new JMenuItem("Close", 'C');
		fileMenu.add(closeMenuItem);
		fileMenu.addSeparator();
		JMenuItem saveMenuItem = new JMenuItem("Save", 'S');
		fileMenu.add(saveMenuItem);
		fileMenu.add(showAction);
		fileMenu.addSeparator();
		JMenuItem exitMenuItem = new JMenuItem("Exit", 'X');
		fileMenu.add(exitMenuItem);
		menuBar.add(fileMenu);
		JMenu editMenu = new JMenu("Edit");
		JMenuItem cutMenuItem = new JMenuItem("Cut", 'T');
		KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.CTRL_MASK);
		cutMenuItem.setAccelerator(ctrlXKeyStroke);
		editMenu.add(cutMenuItem);
		JMenuItem copyMenuItem = new JMenuItem("Copy", 'C');
		KeyStroke ctrlCKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C,Event.CTRL_MASK);
		copyMenuItem.setAccelerator(ctrlCKeyStroke);
		editMenu.add(copyMenuItem);
		JMenuItem pasteMenuItem = new JMenuItem("Paste", 'P');
		KeyStroke ctrlVKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_V,Event.CTRL_MASK);
		pasteMenuItem.setAccelerator(ctrlVKeyStroke);
		pasteMenuItem.setEnabled(false);
		editMenu.add(pasteMenuItem);
		editMenu.addSeparator();
		JMenuItem findMenuItem = new JMenuItem("Find", 'F');
		KeyStroke f3KeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0);
		findMenuItem.setAccelerator(f3KeyStroke);
		editMenu.add(findMenuItem);
		editMenu.setMnemonic('e');
		editMenu.add(showAction);
		menuBar.add(editMenu);
		frame.setJMenuBar(menuBar);
		frame.setSize(350, 250);
		frame.setVisible(true);
	}
}
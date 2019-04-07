import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Otros4 {
	private static String labelPrefix = "Valor: ";
	private int estadoInicial = 1;
	//
	public Component createComponents() {
		final JLabel label = new JLabel(labelPrefix + "1");
		JButton button1 = new JButton("Estado inicial (1)");
		button1.setForeground(new Color(255,255,0));
		button1.setBackground(new Color(0,0,255));
		button1.setMnemonic(KeyEvent.VK_I);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoInicial=1;
				label.setText(labelPrefix + estadoInicial);
			}
		});
		label.setLabelFor(button1);
		JButton button2 = new JButton(" +2 ");
		button2.setForeground(new Color(0,0,255));
		button2.setBackground(new Color(255,255,0));
		button2.setMnemonic(KeyEvent.VK_M);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoInicial=estadoInicial+2;
				label.setText(labelPrefix + estadoInicial);
			}
		});
		JButton button3 = new JButton(" -2 ");
		button3.setForeground(new Color(100,0,0));
		button3.setBackground(new Color(0,255,255));
		button3.setMnemonic(KeyEvent.VK_N);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoInicial=estadoInicial-2;
				label.setText(labelPrefix + estadoInicial);
			}
		});
		JButton button4 = new JButton(" *2 ");
		button4.setForeground(new Color(0,255,255));
		button4.setBackground(new Color(100,0,0));
		button4.setMnemonic(KeyEvent.VK_O);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoInicial=estadoInicial*2;
				label.setText(labelPrefix + estadoInicial);
			}
		});
		JButton button5 = new JButton(" /2 ");
		button5.setForeground(new Color(255,255,220));
		button5.setBackground(new Color(165,85,60));
		button5.setMnemonic(KeyEvent.VK_P);
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estadoInicial=estadoInicial/2;
				label.setText(labelPrefix + estadoInicial);
			}
		});
		JButton button6 = new JButton(" FIN");
		button6.setForeground(new Color(0,255,0));
		button6.setBackground(new Color(255,0,15));
		button6.setMnemonic(KeyEvent.VK_F);
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		pane.setLayout(new GridLayout(0, 1));
		pane.setForeground(new Color(255,0,0));
		pane.setBackground(new Color(0,255,0));
		pane.add(button1);
		pane.add(button2);
		pane.add(button3);
		pane.add(button4);
		pane.add(button5);
		pane.add(button6);
		pane.add(label);
		return pane;
	}
	//
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e) {
		}
		JFrame frame = new JFrame("Ejercicio 3.1 (OperMAts)");
		Otros4 app = new Otros4();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);
		frame.setForeground(new Color(255,0,0));
		frame.setBackground(new Color(0,255,0));
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.pack();
		frame.setVisible(true);
	}
}
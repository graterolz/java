import java.awt.*;
import javax.swing.*;

public class Applet73 extends JApplet {
	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;
	private JTextField t;
	//
	public void init() {
		setLayout(new FlowLayout());
		a = new JButton("P�lsame a");
		b = new JButton("P�lsame b");
		c = new JButton("P�lsame c");
		d = new JButton("P�lsame d");
		add (a);
		add (b);
		add (c);
		add (d);
		t = new JTextField(20);
		add(t);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText ("Hola mundo");
			}
		});
	}
}
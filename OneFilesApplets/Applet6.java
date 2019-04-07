import java.awt.*;
import java.applet.*;

public class Applet6 extends Applet implements ActionListener {
	String msg="";
	Button yes,no,quiza;
	//
	public void init() {
		yes = new Button("Si");
		no = new Button("No");
		quiza = new Button("Sin decidir");
		add(yes);
		add(no);
		add(quiza);
		yes.addActionListener(this);
		no.addActionListener(this);
		quiza.addActionListener(this);
	}
	//
	public void actionPerformed(ActionEvent ae) {
		String str=ae.getActionCommand();
		if(str.equals("Si")) {
			msg="Ha pulsado Si";
		}
		else if(str.equals("No")) { 
			msg="Ha pulsado No";
		}
		else {
			msg="Ha pulsado Sin decidir";
		}
		repaint();
	}
	//
	public void paint(Graphics g) {
		g.drawString(msg,6,100);
	}
 }
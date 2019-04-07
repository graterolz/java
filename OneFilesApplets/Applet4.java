import java.awt.*;
import java.applet.*;

public class Applet4 extends Applet implements ItemListener {
	String msg="";
	Checkbox win98,winNT,solaris,mac;
	//
	public void init() {
		win98 = new Checkbox("Windows 98",null,true);
		winNT = new Checkbox("Windows NT/2000");
		solaris = new Checkbox("Solaris");
		mac = new Checkbox("macOS");
		add(win98);
		add(winNT);
		add(solaris);
		add(mac);
		win98.addItemListener(this);
		winNT.addItemListener(this);
		solaris.addItemListener(this);
		mac.addItemListener(this);
	}
	//
	public void itemStateChanged(ItemEvent ae) {
		repaint();
	}
	//
	public void paint(Graphics g) {
		msg="Estado actual: ";
		g.drawString(msg,6,80);
		msg="   Windows 98: "+ win98.getState();
		g.drawString(msg,12,100);
		msg="   Windows NT/2000: "+ winNT.getState();
		g.drawString(msg,18,120);
		msg="   Solaris: "+ solaris.getState();
		g.drawString(msg,24,140);
		msg="   MacOS: "+ mac.getState();
		g.drawString(msg,28,160);
	}
}
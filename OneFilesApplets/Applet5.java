import java.awt.*;
import java.applet.*;

public class Applet5 extends Applet implements ItemListener {
	Choice os,browser;
	String msg="";
	//
	public void init() {
		os = new Choice();
		browser = new Choice();
		os.add("Windows 98");
		os.add("Windows NT/2000");
		os.add("Solaris");
		os.add("MacOS");
		browser.add("Netscape 1.1");
		browser.add("Netscape 2.x");
		browser.add("Netscape 3.x");
		browser.add("Netscape 4.x"); 
		browser.add("Internet Explorer 3.0");
		browser.add("Internet Explorer 4.0");
		browser.add("Internet Explorer 5.0");
		browser.add("Linx 2.4");
		browser.select("Netscape 4.x");
		add(os);
		add(browser);
		os.addItemListener(this);
		browser.addItemListener(this);
	}
	//
	public void itemStateChanged(ItemEvent ie) {
		repaint();
	}
	//
	public void paint(Graphics g) {
		msg = "Actual OS: "+os.getSelectedItem();
		g.drawString(msg,6,120); 
		msg = "Actual navegador: "+browser.getSelectedItem();
		g.drawString(msg,6,140);
	}
}
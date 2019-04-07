import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Applet65 extends JApplet {
	JPopupMenu popup;
	JPanel p;
	public void init() {
		Container c = getContentPane();
		p = new JPanel();
		popup = new JPopupMenu();
		JMenuItem menuItem = new JMenuItem("Item 1");
		popup.add(menuItem);
		menuItem = new JMenuItem("Item 2");
		popup.add(menuItem);
		menuItem = new JMenuItem("Item 3");
		popup.add(menuItem);
		p.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				if(me.isPopupTrigger()) {
					popup.show(p, me.getX(), me.getY());
				}
			}
			public void mouseReleased(MouseEvent me){
				if(me.isPopupTrigger()) {
					popup.show(p, me.getX(), me.getY());
				}
			}
		});
		c.add(p);
	}
}
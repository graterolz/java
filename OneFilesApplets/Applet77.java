import java.awt.*;
import java.applet.Applet;
import java.util.Vector;

class Applet77 extends Panel {
	Vector labels = new Vector();
	Vector menus = new Vector();
	Insets margins = new Insets(3, 10, 3, 10);
	int spacing = 10;
	Color highlightColor;
	boolean remeasure = true;
	int[] widths;
	int[] startPositions;
	int ascent, descent;
	Dimension prefsize = new Dimension();
	int highlightedItem = -1;
	//
	public Applet77() {
		enableEvents(AWTEvent.MOUSE_EVENT_MASK|AWTEvent.MOUSE_MOTION_EVENT_MASK);
	}
	//
	public void addMenu(String label, PopupMenu menu) {
		insertMenu(label, menu, -1);
	}
	//
	public void insertMenu(String label, PopupMenu menu, int index) {
		if (index < 0){
			index += labels.size() + 1;
			this.add(menu);
			labels.insertElementAt(label, index);
			menus.insertElementAt(menu, index);
			remeasure = true;
			invalidate();
		}
	}
	//
	public Insets getMargins() {
		return (Insets) margins.clone();
	}
	//
	public void setMargins(Insets margins) {
		this.margins = margins;
		remeasure = true;
		invalidate();
	}
	//
	public int getSpacing() {
		return spacing;
	}
	//
	public void setSpacing(int spacing) {
		if (this.spacing != spacing) {
			this.spacing = spacing;
			remeasure = true;
			invalidate();
		}
	}
	//
	public Color getHighlightColor() {
		if (highlightColor == null)
			return getForeground();
		else
			return highlightColor;
	}
	//
	public void setHighlightColor(Color c) {
		if (highlightColor != c) {
			highlightColor = c;
			repaint();
		}
	}
	//
	public void setFont(Font f) {
		super.setFont(f);
		remeasure = true;
		invalidate();
	}
	//
	public void setForeground(Color c) {
		super.setForeground(c);
		repaint();
	}
	//
	public void setBackground(Color c) {
		super.setBackground(c);
		repaint();
	}
	//
	public void paint(Graphics g) {
		if (remeasure){
			measure();
		}
		Dimension size = getSize();
		int baseline = size.height - margins.bottom - descent;
		g.setFont(getFont());
		int nummenus = labels.size();
		for (int i = 0; i < nummenus; i++) {
			if ((i == highlightedItem) && (highlightColor != null)){
				g.setColor(getHighlightColor());
			}
			else{
				g.setColor(getForeground());
			}
			g.drawString((String) labels.elementAt(i), startPositions[i],baseline);
		}
		Color bg = getBackground();
		g.setColor(bg.darker());
		g.drawLine(0, size.height - 2, size.width, size.height - 2);
		g.setColor(bg.brighter());
		g.drawLine(0, size.height - 1, size.width, size.height - 1);
	}
	//
	protected void processMouseEvent(MouseEvent e){
		int type = e.getID();
		int item = findItemAt(e.getX());
		if (type == MouseEvent.MOUSE_PRESSED){
			if (item == -1)
				return;
			Dimension size = getSize();
			PopupMenu pm = (PopupMenu) menus.elementAt(item);
			if (pm != null)
				pm.show(this, startPositions[item] - 3, size.height);
		}
		else if (type == MouseEvent.MOUSE_EXITED) {
			if (highlightedItem != -1) {
				highlightedItem = -1;
				if (highlightColor != null)
					repaint();
			}
		}
		else if ((type == MouseEvent.MOUSE_MOVED)||(type == MouseEvent.MOUSE_ENTERED)){
			if (item != highlightedItem){
				highlightedItem = item;
				if (highlightColor != null)
					repaint();
			}
		}
	}
	//
	protected void processMouseMotionEvent(MouseEvent e){
		processMouseEvent(e);
	}
	//
	protected int findItemAt(int x) {
		int nummenus = labels.size();
		int halfspace = spacing / 2 - 1;
		int i;
		for (i = nummenus - 1; i >= 0; i--) {
			if ((x >= startPositions[i] - halfspace) && (x <= startPositions[i] + widths[i] + halfspace))
				break;
		}
		return i;
	}
	//
	protected void measure() {
		FontMetrics fm = this.getFontMetrics(getFont());
		ascent = fm.getAscent();
		descent = fm.getDescent();
		int nummenus = labels.size();
		widths = new int[nummenus];
		startPositions = new int[nummenus];
		int pos = margins.left;
		for(int i = 0; i < nummenus; i++){
			startPositions[i] = pos;
			String label = (String) labels.elementAt(i);
			widths[i] = fm.stringWidth(label);
			pos += widths[i] + spacing;
		}
		prefsize.width = pos - spacing + margins.right;
		prefsize.height = ascent + descent + margins.top + margins.bottom;
		remeasure = false;
	}
	//
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
	//
	public Dimension getPreferredSize() {
		if (remeasure)
			measure();
		return prefsize;
	}
	//
	public Dimension minimumSize() {
		return getPreferredSize();
	}
	//
	public Dimension preferredSize() {
		return getPreferredSize();
	}
	//
	public void addNotify() {
		super.addNotify();
		measure();
	}
	//
	public boolean isFocusTraversable() {
		return false;
	}
}
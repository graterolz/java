import java.awt.*;

public class Otros2 extends Frame {
	public static void main(String[] args) {
		Otros2 miVentana=new Otros2("Una Ventana",300,150);
		miVentana.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	//
	public Otros2 (String titulo, int x, int y) {
		super(titulo);
		setSize(x,y);
		añadeMenu();
		show();
	}
	//
	public void añadeMenu() {
		MenuBar mb;
		Menu m1,m2;
		MenuItem mi1_1,mi1_2;
		CheckboxMenuItem mi2_1;
		mb = new MenuBar();
		setMenuBar(mb);
		m1 = new Menu("Menú 1",true);
		mb.add(m1);
		mi1_1 = new MenuItem("Menu item 1_1");
		m1.add(mi1_1);
		mi1_2 = new MenuItem("Menú item 1_2");
		m1.add(mi1_2);
		m2 = new Menu("Menú 2");
		mb.add(m2);
		mi2_1 = new CheckboxMenuItem("Menú item 2_1");
		m2.add(mi2_1);
	}
}
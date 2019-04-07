import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class MenuFrame extends Frame {
	String msg = "";
	CheckboxMenuItem debug, test;
	//
	MenuFrame(String title) {
		super(title);
		MenuBar mbar = new MenuBar();
		setMenuBar(mbar);
		Menu file = new Menu("Archivo");
		MenuItem item1, item2, item3, item4, item5;
		file.add(item1 = new MenuItem("Nuevo..."));
		file.add(item2 = new MenuItem("Abrir..."));
		file.add(item3 = new MenuItem("Cerrar..."));
		file.add(item4 = new MenuItem("-"));
		file.add(item5 = new MenuItem("Salir..."));
		mbar.add(file);
		//
		Menu edit = new Menu("Edición");
		MenuItem item6, item7, item8, item9;
		edit.add(item6 = new MenuItem("Cortar..."));
		edit.add(item7 = new MenuItem("Copiar..."));
		edit.add(item8 = new MenuItem("Pegar..."));
		edit.add(item9 = new MenuItem("-"));
		//
		Menu sub = new Menu("Especial");
		MenuItem item10, item11, item12;
		sub.add(item10 = new MenuItem("Primero"));
		sub.add(item11 = new MenuItem("Segundo"));
		sub.add(item12 = new MenuItem("Tercero"));
		edit.add(sub);
		//
		debug = new CheckboxMenuItem("Depurar");
		edit.add(debug);
		test = new  CheckboxMenuItem("Prueba");
		edit.add(test);
		mbar.add(edit);
		//
		MyMenuHandler handler = new MyMenuHandler(this);
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		item4.addActionListener(handler);
		item5.addActionListener(handler);
		item6.addActionListener(handler);
		item7.addActionListener(handler);
		item8.addActionListener(handler);
		item9.addActionListener(handler);
		item10.addActionListener(handler);
		item11.addActionListener(handler);
		item12.addActionListener(handler);
		debug.addActionListener(handler);
		test.addActionListener(handler);
		//
		MyWindowAdapter adapter = new MyWindowAdapter(this);
		addWindowListener(adapter);
	}
	//
	public void paint(Graphics g) {
		g.drawString(msg,10,200);
		if(debug.getState())
			g.drawString("Depuracion activada...",10,220);
		else
			g.drawString("Depuracion desactivada...",10,220);

		if(test.getState())
			g.drawString("Prueba activada...",10,240);
		else
			g.drawString("Prueba desactivada...",10,240);
	}
}
//
class MyWindowAdapter extends WindowAdapter {
	MenuFrame menuFrame;
	//
	public MyWindowAdapter(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	//
	public void windowClosing(WindowEvent we) {
		menuFrame.setVisible(false);
	}
}
//
class MyMenuHandler implements ActionListener, ItemListener {
	MenuFrame menuFrame;
	//
	public MyMenuHandler(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	//
	public void actionPerformed(ActionEvent ae) {
		String msg = "Usted ha seleccionado ";
		String arg = (String) ae.getActionCommand();
		if(arg.equals("Nuevo..."))
			msg+="Nuevo.";
		else if(arg.equals("Abrir..."))
			msg+="Abrir.";
		else if(arg.equals("Cerrar..."))
			msg+="Cerrar.";
		else if(arg.equals("Salir..."))
			msg+="Salir.";
		else if(arg.equals("Edición"))
			msg+="Edición.";
		else if(arg.equals("Cortar"))
			msg+="Cortar.";
		else if(arg.equals("Copiar"))
			msg+="Copiar.";
		else if(arg.equals("Pegar"))
			msg+="Pegar.";
		else if(arg.equals("Primero"))
			msg+="Primero.";
		else if(arg.equals("Segundo"))
			msg+="Segundo.";
		else if(arg.equals("Tercero"))
			msg+="Tercero.";
		else if(arg.equals("Depurar"))
			msg+="Depurar.";
		else if(arg.equals("Prueba"))
			msg+="Prueba.";
		menuFrame.msg = msg;
		menuFrame.repaint();
	}
	//
	public void itemStateChanged(ItemEvent ie) {
		menuFrame.repaint();
	}
}
//
public class Applet1 extends Applet {
	Frame f;
	//
	public void init() {
		f = new MenuFrame("Menu Demo");
		int width = Integer.parseInt(getParameter("width"));
		int height = Integer.parseInt(getParameter("height"));
		setSize(new Dimension(width,height));
		f.setSize(width,height);
		f.setVisible(true);
	}
	//
	public void start() {
		f.setVisible(true);
	}
	//
	public void stop() {
		f.setVisible(false);
	}
}
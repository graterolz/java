import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Applet61 extends Applet implements ActionListener {
	Button boton, botonCerrar;
	ventana1 menuWindow;
	//
	public void init() {
		boton = new Button("Visualizar menú en ventana");
		botonCerrar = new Button("Cerrar ventana menús");
		add(boton);
		add(botonCerrar);
		boton.addActionListener(this);
		botonCerrar.addActionListener(this);
		menuWindow = new ventana1();
		menuWindow.setSize(200, 200);
		menuWindow.setLocation(500,250);
	}
	//
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == boton){
			menuWindow.setVisible(true);
		}
		else{
			if(event.getSource() == botonCerrar){
				menuWindow.setVisible(false);
			}
		}
	}
}
//
class ventana1 extends Frame {
	ventana1() {
		setSize(250,250);
		setTitle("Ventana de menus1");
		Menu fichero= new Menu("Archivo");
		Menu nuevo= new Menu("Nuevo");
		Menu opciones= new Menu("Opciones");
		Menu ayuda=new Menu("Ayuda");
		MenuBar barra= new MenuBar();
		nuevo.add(new MenuItem("Grafico",new MenuShortcut('g')));
		nuevo.add(new MenuItem("Texto",new MenuShortcut('t')));
		fichero.add(nuevo);
		fichero.add(new MenuItem("Cargar",new MenuShortcut('c')));
		fichero.add(new MenuItem("Salvar",new MenuShortcut('s',true))).setEnabled(false);
		fichero.addSeparator();
		fichero.add(new MenuItem("Salir",new MenuShortcut('s')));
		barra.add(fichero);
		opciones.add(new CheckboxMenuItem("Alta Resolucion"));
		opciones.add(new CheckboxMenuItem("Sin fondo"));
		opciones.add(new CheckboxMenuItem("Blanco y negro"));
		barra.add(opciones);
		ayuda.add(new MenuItem("Contenido",new MenuShortcut('c',true)));
		ayuda.addSeparator();
		ayuda.add(new MenuItem("Acerca de",new MenuShortcut('a')));
		barra.setHelpMenu(ayuda);
		barra.add(ayuda);
		setMenuBar(barra);
	}
}
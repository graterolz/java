import java.applet.Applet;
import java.awt.*;

public class Applet63 extends Applet implements ItemListener {
	CheckboxGroup grupo;
	TextField cajaTexto;
	Checkbox boton1, boton2, boton3, boton4;
	//
	public void init() {
		grupo = new CheckboxGroup();
		boton1 = new Checkbox("1", false, grupo);
		boton2 = new Checkbox("2", false, grupo);
		boton3 = new Checkbox("3", false, grupo);
		boton4 = new Checkbox("4", false, grupo);
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		boton1.addItemListener(this);
		boton2.addItemListener(this);
		boton3.addItemListener(this);
		boton4.addItemListener(this);
		cajaTexto = new TextField(35);
		add(cajaTexto);
	}
	//
	public void itemStateChanged(ItemEvent e){
		cajaTexto.setText("El botón de opción Nº " + ((Checkbox) e.getItemSelectable()).getLabel() + " está seleccionado");
	}
}
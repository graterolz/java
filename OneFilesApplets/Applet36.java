import java.awt.*;
import java.applet.*;

public class Applet36 extends Applet implements ActionListener{
	String mensaje = "Mensaje de Prueba.";
	Color r =new Color(32,54,76);
	Button boton1,boton2,boton3;
	Choice choice = new Choice();
	//
	public void init(){
		setBackground(Color.YELLOW);
		choice = new Choice();
		choice.addItem("Amarillo");
		choice.addItem("Azul");
		choice.addItem("Rojo");
		boton1 = new Button("Negro");
		boton2 = new Button("Blanco");
		boton3 = new Button("Gris");
		add(choice);
		add(boton1);
		add(boton2);
		add(boton3);
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
	}
	//
	public void actionPerformed(ActionEvent ae){
		String str=ae.getActionCommand();
		if(str.equals("Negro")){
			setBackground(Color.black);
			r = Color.YELLOW;
		}
		else if(str.equals("Blanco")){
			setBackground(Color.WHITE);
			r = Color.RED;
		}
		else{
			setBackground(Color.GRAY);
			r = Color.WHITE;
		}
		repaint();
	}
	//
	public boolean action(Event event, Object object) {
		if (event.target == choice){
			String selection = choice.getSelectedItem();
			if (selection.equals("Amarillo")){
				setBackground(Color.YELLOW);
				r = Color.BLUE;
			}
			else if (selection.equals("Azul")){
				setBackground(Color.BLUE);
				r = Color.RED;
			}
			else{
				setBackground(Color.RED);
				r = Color.GRAY;
			}
			return(true);
		}
		else{
			return(false);
		}
	}
	//
	public void paint(Graphics g){
		g.setColor(r);
		g.drawString(mensaje,100,100);
	}
}
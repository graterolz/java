import java.awt.*;
import java.applet.*;

public class Applet9 extends Applet {
	String nombreFuente;
	int tamañoFuente;
	float separación;
	boolean active;
	//
	public void start() {
		String param;
		nombreFuente = getParameter("nombreFuente");
		if (nombreFuente==null)
			nombreFuente = "No encontrada";
		param = getParameter("tamañoFuente");
		try {
			if (param != null)
				tamañoFuente = Integer.parseInt(param);
			else
				tamañoFuente = 0;
		}
		catch (NumberFormatException e) {
			tamañoFuente = -1;
		}
		param = getParameter("separación");
		try {
			if (param != null)
				separación = Float.valueOf(param).floatValue();
			else
				separación = 0;
		}
		catch(NumberFormatException e) {
			separación = -1;
		}
		param = getParameter("accountEnabled");
		if (param != null)
			active = Boolean.valueOf(param).booleanValue();
	}
	//
	public void paint(Graphics g) {
		g.drawString("Nombre de la fuente: " + nombreFuente,0,10);
		g.drawString("Tamaño de la fuente: " + tamañoFuente,0,26);
		g.drawString("Separación: " + separación,0,42);
		g.drawString("Activo: " + active,0,58);
	}
}
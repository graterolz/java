import java.awt.*;
import java.applet.*;

public class Applet9 extends Applet {
	String nombreFuente;
	int tama�oFuente;
	float separaci�n;
	boolean active;
	//
	public void start() {
		String param;
		nombreFuente = getParameter("nombreFuente");
		if (nombreFuente==null)
			nombreFuente = "No encontrada";
		param = getParameter("tama�oFuente");
		try {
			if (param != null)
				tama�oFuente = Integer.parseInt(param);
			else
				tama�oFuente = 0;
		}
		catch (NumberFormatException e) {
			tama�oFuente = -1;
		}
		param = getParameter("separaci�n");
		try {
			if (param != null)
				separaci�n = Float.valueOf(param).floatValue();
			else
				separaci�n = 0;
		}
		catch(NumberFormatException e) {
			separaci�n = -1;
		}
		param = getParameter("accountEnabled");
		if (param != null)
			active = Boolean.valueOf(param).booleanValue();
	}
	//
	public void paint(Graphics g) {
		g.drawString("Nombre de la fuente: " + nombreFuente,0,10);
		g.drawString("Tama�o de la fuente: " + tama�oFuente,0,26);
		g.drawString("Separaci�n: " + separaci�n,0,42);
		g.drawString("Activo: " + active,0,58);
	}
}
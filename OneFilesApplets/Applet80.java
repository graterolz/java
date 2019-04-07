import java.net.*;
import java.util.*;
import java.awt.*;
import java.applet.*;
import javax.swing.*;
public class Applet80 extends JApplet {
	private HashMap sitios;
	private Vector nombresSitios;
	private JList selectorSitios;
	//
	public void init() {
		sitios = new HashMap();
		nombresSitios = new Vector();
		obtenerSitiosDeParametrosHTML();
		Container contenedor = getContentPane();
		contenedor.add( new JLabel( "Seleccione un sitio para navegar" ), BorderLayout.NORTH );
		selectorSitios = new JList( nombresSitios );
		selectorSitios.addListSelectionListener( new ListSelectionListener() {
			public void valueChanged( ListSelectionEvent evento ) {
				Object objeto = selectorSitios.getSelectedValue();
				URL nuevoDocumento = ( URL ) sitios.get( objeto );
				AppletContext navegador = getAppletContext();
				navegador.showDocument( nuevoDocumento );
			}
		});
		contenedor.add( new JScrollPane( selectorSitios ), BorderLayout.CENTER );
	}
	//
	private void obtenerSitiosDeParametrosHTML() {
		String titulo, ubicacion;
		URL url;
		int contador = 0;
		titulo = getParameter( "titulo" + contador );
		while ( titulo != null ) {
			ubicacion = getParameter( "ubicacion" + contador );
			try {
				url = new URL( ubicacion );
				sitios.put( titulo, url );
				nombresSitios.add( titulo );
			}
			catch ( MalformedURLException excepcionURL ) {
				excepcionURL.printStackTrace();
			}
			++contador;
			titulo = getParameter( "titulo" + contador );
		}
	}
}
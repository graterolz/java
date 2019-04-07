import java.awt.*;
import javax.swing.*;
class Class44{
	public static JMenuBar MyMenu(){
		JMenuBar Mnu = new JMenuBar();
		//
		JMenu Lavado = new JMenu("Lavado");
		JMenuItem Normal = new JMenuItem("Normal");
		Lavado.add(Normal);
		Lavado.addSeparator();
		JMenuItem Especial = new JMenuItem("Especial");
		Lavado.add(Especial);
		//
		JMenu SGenerales = new JMenu("Servicios Generales");
		JMenuItem Engrase = new JMenuItem("Engrase");
		SGenerales.add(Engrase);
		SGenerales.addSeparator();
		JMenuItem CambioDeAceite = new JMenuItem("Cambio De Aceite");
		SGenerales.add(CambioDeAceite);
		SGenerales.addSeparator();
		JMenuItem DuchaDeGrafito = new JMenuItem("Ducha De Grafito");
		SGenerales.add(DuchaDeGrafito);
		//
		JMenu Ayuda = new JMenu("Ayuda");
		JMenuItem Indice = new JMenuItem("Indice");
		Ayuda.add(Indice);
		Ayuda.addSeparator();
		JMenuItem AcercaDe = new JMenuItem("Acerca De");
		Ayuda.add(AcercaDe);
		//
		JMenu SalirDelSistema = new JMenu("Salir Del Sistema");
		JMenuItem Salir = new JMenuItem("Salir");
		SalirDelSistema.add(Salir);
		//
		Mnu.add(Lavado);
		Mnu.add(SGenerales);
		Mnu.add(Ayuda);
		Mnu.add(SalirDelSistema);
		return Mnu;
	}
	//
	public static JPanel MyPanel(){
		JPanel Panel_Izquierdo = new JPanel();
		Panel_Izquierdo.setLayout(new BoxLayout(Panel_Izquierdo,BoxLayout.Y_AXIS));
		Panel_Izquierdo.setBackground(Color.red);
		Panel_Izquierdo.add(new JButton("1"));
		Panel_Izquierdo.add(new JButton("2"));
		Panel_Izquierdo.add(new JButton("3"));
		Panel_Izquierdo.add(new JButton("4"));
		Panel_Izquierdo.add(new JButton("5"));
		Panel_Izquierdo.setVisible(true);
		return Panel_Izquierdo;
	}
	//
	private void construyePanelSuperior(){
		panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSuperior.setBackground(Color.blue);
		panelSuperior.add(new JButton("Sup.1"));
		panelSuperior.add(new JButton("Sup.2"));
		panelSuperior.add(new JButton("Sup.3"));
		panelSuperior.add(new JButton("Sup.4"));
	}
	//
	public static void main(String[] args){	
		JFrame Ventana = new JFrame("AutoWash 1.0 - Sistema Para AutoLavados");
		Ventana.setJMenuBar(MyMenu());
		Ventana.setContentPane(MyPanel());
		Ventana.setSize(350,350);
		Ventana.setVisible(true);
		Ventana.setLocationRelativeTo(null);
		Ventana.setResizable(false);
		Ventana.getContentPane().setBackground(Color.black);
		Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
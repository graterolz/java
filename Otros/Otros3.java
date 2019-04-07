import java.awt.*;
import javax.swing.*;
public class Otros3 extends JFrame {
	private JTextArea areaTexto1, areaTexto2;
	private JButton botonCopiar;
	//
	public Otros3() {
		super( "Demostración de JTextArea" );
		Box cuadro = Box.createHorizontalBox();
		String cadena = "Ésta es una cadena de\ndemostración para\n" + 
			"ilustrar cómo copiar texto\nde un área de texto a \n" +
			"otra, utilizando un\nevento externo";
		areaTexto1 = new JTextArea( cadena, 10, 300 );
		cuadro.add( new JScrollPane( areaTexto1 ) );
		botonCopiar = new JButton( "Copiar >>>" );
		cuadro.add( botonCopiar );
		botonCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				areaTexto2.append( areaTexto1.getSelectedText() );
			}
		});
		areaTexto2 = new JTextArea( 10, 15 );
		areaTexto2.setEditable( false );
		cuadro.add( new JScrollPane( areaTexto2 ) );
		Container contenedor = getContentPane();
		contenedor.add( cuadro );
		setSize( 425, 200 );
		setVisible( true );
	}
	//
	public static void main( String args[] ) {
		Otros3 aplicacion = new Otros3();
		aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
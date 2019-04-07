import java.awt.*;
import javax.swing.*;

public class Impresora{
	Font fuente = new Font("Dialog", Font.PLAIN, 10);
	PrintJob pj;
	Graphics pagina;

	Impresora(){
		pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "<GenCoder>", null);
	}

	public void Imprimir(String Cadena){
		try{
			pagina = pj.getGraphics();
			pagina.setFont(fuente);
			pagina.setColor(Color.black);
			pagina.drawString(Cadena,60,60);
			pagina.dispose();
			pj.end();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"La Impresion ha sido Cancelada","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
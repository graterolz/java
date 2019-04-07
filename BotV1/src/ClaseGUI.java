import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class ClaseGUI extends JFrame{
	ClasePrincipal CP = new ClasePrincipal();
	ClaseEntrada CE = new ClaseEntrada();
	ClaseSalida CS = new ClaseSalida();
	public String Entrada;
	public JTextField JTextFieldInferior = new JTextField(30);
	public JTextArea JTextAreaSuperior = new JTextArea(CP.p_version,12,30);
	//
	public void Ventana(){
		JPanel JPanelSuperior = new JPanel();
		JPanel JPanelInferior = new JPanel();
		getContentPane().add(JPanelInferior, "South");
		getContentPane().add(JPanelSuperior, "North");
		JTextAreaSuperior.setLineWrap(true);
		JTextAreaSuperior.setEnabled(false);
		JTextFieldInferior.addKeyListener(new KeyAdapter(){
			public void keyTyped (KeyEvent evt){
				EntradaEvento(evt);
			}
		});
		JPanelSuperior.add(new JScrollPane(JTextAreaSuperior));
		JPanelInferior.add(JTextFieldInferior);
		setSize(500,300);
		setTitle(CP.p_version);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
	//
	public void SalidaGUI(){
		JTextAreaSuperior.setText(JTextAreaSuperior.getText() + "\n" + CP.p_bot + CS.p_salida);
	}
	//
	public void EntradaEvento(KeyEvent evt){
		if(evt.getKeyChar() == KeyEvent.VK_ENTER){
			Entrada = JTextFieldInferior.getText();
			CE.ProcesoEntrada(Entrada);
			JTextAreaSuperior.setText(JTextAreaSuperior.getText() + "\n" + CP.p_user + JTextFieldInferior.getText());
			JTextFieldInferior.setText(null);
		}
	}
}
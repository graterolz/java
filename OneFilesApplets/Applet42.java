import java.awt.*;
import java.applet.*;

public class Applet42 extends Applet {
	ClaseTabla CT = new ClaseTabla();
	ClaseGlobal CP = new ClaseGlobal();
	public String Entrada;
	//
	public void init() {
		try {
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					initComponents();
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	//
	public void SalidaGUI(String p_salida,int p_perfil){
		if (p_perfil == 0){
			jTextArea1.setText(jTextArea1.getText() + "\n" + CP.p_bot + p_salida);
		}
		else if (p_perfil == 1){
			jTextArea1.setText(jTextArea1.getText() + "\n" + CP.p_user + p_salida);	
			jTextField1.setText(null);
		}
	}
	//
	public void EntradaEvento(event.KeyEvent evt){
		if(evt.getKeyChar() == event.KeyEvent.VK_ENTER){
			Entrada = jTextField1.getText();
			SalidaGUI(Entrada,1);
			ProcesoEntrada(Entrada);
		}
	}
	//
	public void ProcesoEntrada(String p_entrada){
		int CantidadCaracteres = 0;
		int CantidadPalabras = 1;
		p_entrada = p_entrada.trim();
		p_entrada.toLowerCase();
		for (int i = 0;i < p_entrada.length();i++){
			char Caracter = p_entrada.charAt(i);
			Caracter = Character.toLowerCase(Caracter);
			if (Caracter == ' '){
				CantidadPalabras++;
			}
			CantidadCaracteres++;
		}
		if (CantidadCaracteres == 0){
			CantidadPalabras = 0;
		}
		int EmpiezaPalabra[] = new int [CantidadPalabras];
		int TerminaPalabra[] = new int [CantidadPalabras];
		String GuardaPalabras[] = new String [CantidadPalabras];
		int Indicator = 0;
		int Bandera = 0;
		for(int i = 0;i < p_entrada.length();i++){
			char Caracter = p_entrada.charAt(i);
			Caracter = Character.toLowerCase(Caracter);
			if (Caracter != ' '){
				if ((i+1) == p_entrada.length()){
					TerminaPalabra[Indicator] = i;
					Bandera = 2;
				} 
				if (Bandera == 0){
					EmpiezaPalabra[Indicator] = i;
					Bandera = 1;
				}
			}
			else{
				if (Bandera == 1){
					TerminaPalabra[Indicator] = i-1;
					Indicator = Indicator+1;
					Bandera = 0;
				}
			}
		}
		for(int i = 0;i < CantidadPalabras;i++){
			GuardaPalabras[i] = "";
			while(EmpiezaPalabra[i] <= TerminaPalabra[i]){
				GuardaPalabras[i] = GuardaPalabras[i] + p_entrada.charAt(EmpiezaPalabra[i]);
				EmpiezaPalabra[i] = EmpiezaPalabra[i]+1;
			}
		}
		CT.TablaPalabras();
		CT.TablaCombinacion();
		CT.TablaSalida();
		String GuardaLocalizador = "";
		for(int i = 0;i < CantidadPalabras;i++){
			for (int x = 0;x < CT.CantidadRegistros;x++){
				if (CT.PalabraEntrada[x].equals(GuardaPalabras[i])){
					if (GuardaLocalizador == ""){
						GuardaLocalizador = "" + CT.LocalizadorEntrada[x];
					}
					else{
						GuardaLocalizador = GuardaLocalizador + "-" + CT.LocalizadorEntrada[x];
					}
					x = CT.CantidadRegistros;
				}
			}
		}
		int Entendio = 0;
		for (int i = 0;i < CT.CantidadCombinaciones;i++){
			if(CT.CombinacionLocalizador[i].equals(GuardaLocalizador)){
				System.out.println("Entiendo.");
				Entendio = 1;
			}
			else{
				System.out.println("No Entiendo.");
			}
		}
		if (Entendio == 1){
			int CantidadRespuestaSalida = 0;
			for (int i = 0; i < CT.CantidadRespuestas;i++){
				if (CT.LocalizadorCombinacionEntrada[i].equals(GuardaLocalizador)){
					CantidadRespuestaSalida = CantidadRespuestaSalida + 1;
				}
			}
			String Respuestas[] = new String [CantidadRespuestaSalida];
			int NumeroRespuesta[] = new int [CantidadRespuestaSalida];
			int x = 0;
			while(x < CantidadRespuestaSalida){
				for (int i = 0; i < CT.CantidadRespuestas;i++){
					if (CT.LocalizadorCombinacionEntrada[i].equals(GuardaLocalizador)){
						Respuestas[x] = CT.LocalizadorCombinacionSalida[i];
						NumeroRespuesta[x] = x;
						x++;
					}
				}
			}
			int EligeRespuesta = (int) (Math.random()*CantidadRespuestaSalida);
			String CadenaRespuestaSalida = "";
			for (int i = 0;i < Respuestas[EligeRespuesta].length();i++){
				char Caracter = Respuestas[EligeRespuesta].charAt(i);
				Caracter = Character.toLowerCase(Caracter);
				if (Caracter != '-'){
					int N = Integer.parseInt("" + Respuestas[EligeRespuesta].charAt(i)); 
					CadenaRespuestaSalida = CadenaRespuestaSalida + " " + CT.PalabraEntrada[N];
				}
			}
			CadenaRespuestaSalida =	CadenaRespuestaSalida.trim();
			SalidaGUI(CadenaRespuestaSalida,0);
		}
	}
	//
	private void initComponents() {
		jDesktopPane1 = new JDesktopPane();
		jInternalFrame1 = new JInternalFrame();
		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();
		jTextField1 = new JTextField();
		setLayout(new BorderLayout());
		jInternalFrame1.setVisible(true);
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new Font("Consolas", 0, 12));
		jTextArea1.setRows(5);
		jTextArea1.setFocusable(false);
		jScrollPane1.setViewportView(jTextArea1);
		jTextArea1.getAccessibleContext().setAccessibleName("JTextAreaSuperior");
		jTextArea1.getAccessibleContext().setAccessibleDescription("");
		jTextField1.setFont(new Font("Consolas", 0, 11));
		jTextField1.addKeyListener(new event.KeyAdapter() {
			public void keyTyped(event.KeyEvent evt) {
				jTextField1KeyTyped(evt);
			}
		});
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(jPanel1Layout.createSequentialGroup()
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 0, Short.MAX_VALUE))
			.addComponent(jTextField1)
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(jPanel1Layout.createSequentialGroup()
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout jInternalFrame1Layout = new GroupLayout(jInternalFrame1.getContentPane());
		jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
		jInternalFrame1Layout.setHorizontalGroup(
			jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(jInternalFrame1Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap())
		);
		jInternalFrame1Layout.setVerticalGroup(
			jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(jInternalFrame1Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap())
		);
		jInternalFrame1.setBounds(10, 10, 340, 280);
		jDesktopPane1.add(jInternalFrame1, JLayeredPane.DEFAULT_LAYER);
		add(jDesktopPane1, BorderLayout.CENTER);
	}
	//
	private void jTextField1KeyTyped(event.KeyEvent evt) {
		EntradaEvento(evt);
	}
	//
	private JDesktopPane jDesktopPane1;
	private JInternalFrame jInternalFrame1;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JTextField jTextField1;
}
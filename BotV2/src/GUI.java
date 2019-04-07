public class GUI extends java.applet.Applet {
	//
	int IndicadorVacio = -1;
	String IdPalabraNoEntiendo[] = {
		"N1-E3",
		"N1-E4-P2-A2-P3-R2-E6",
		"N1-L1-E5",
		"N1-L1-C3",
		"N1-S1-Q2-R2"};
	int GuardaIdPalabraNoEntiendo[] = new int [IdPalabraNoEntiendo.length];
	String IdPalabraRepiteEntrada[] = {""};
	String IdSinEntrada[] = {""};
	//
	Excel E = new Excel();
	General G = new General();
	Tablas T = new Tablas();
	Utilitarios U = new Utilitarios();
	//
	public void init() {
		try {
			java.awt.EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					T.GeneraPalabras();
					T.GeneraErrores();
					AsignaGuardaSalida();
					initComponents();
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	//
	private void EntradaEvento(java.awt.event.KeyEvent evt){
		String Caracter = evt.getKeyChar() + "";
		java.util.regex.Pattern patron = java.util.regex.Pattern.compile("[^A-Za-z ]");
		java.util.regex.Matcher encaja = patron.matcher(Caracter);
		if(!encaja.find()) {
			//System.out.println("solo tiene letras y espacio!");
		}
		else {
			if(evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER){
				G.vEntradaUser = TxtEntrada.getText();
				this.SalidaGUI(G.vEntradaUser,0);
				this.EntradaCadena(G.vEntradaUser);
			}else{
				evt.consume();
			}
		}
	}
	//
	private void EntradaCadena(String pEntrada){
		pEntrada = U.FormatoEntrada(pEntrada);					//Formato a Entrada
		int CantidadPalabras = U.CantidadPalabras(pEntrada);	//Cantidad de Palabras
		int EmpiezaPalabra[] = new int [CantidadPalabras];		//Arreglo de Incio de Palabra
		int TerminaPalabra[] = new int [CantidadPalabras];		//Arreglo de Fin de Palabra
		int Indicator = 0;	//Variable de Utilidad
		int Bandera = 0;	//Variable de Utilidad
		//Asignacion de Palabras a puntos Indicadores
		for(int i = 0;i < pEntrada.length();i++){
			char Caracter = pEntrada.charAt(i);
			if (Caracter != ' '){
				if ((i+1) == pEntrada.length()){
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
		String GuardaPalabras[] = new String [CantidadPalabras];	//Arreglo para guardar Palabras
		//Uso de Indicadores para guardar Palabras
		for(int i = 0;i < CantidadPalabras;i++){
			GuardaPalabras[i] = "";
			while(EmpiezaPalabra[i] <= TerminaPalabra[i]){
				GuardaPalabras[i] = GuardaPalabras[i] + pEntrada.charAt(EmpiezaPalabra[i]);
				EmpiezaPalabra[i] = EmpiezaPalabra[i] + 1;
			}
		}
		String IdGenerado = "";		//Variable para guardar IdGenerado
		//Genera ID mediante entrada ingresada
		//int PalabraEntendida = 0;
		//Busca IdPalabra
		for(int i = 0;i < CantidadPalabras;i++){
			for (int x = 0;x < T.CantidadTotalPalabras;x++){
				if (T.Palabra[x].equals(GuardaPalabras[i])){
					if (IdGenerado.equals("")){
						IdGenerado = "" + T.IdPalabra[x];
					}
					else{
						IdGenerado = IdGenerado + "-" + T.IdPalabra[x];
					}
					x = T.CantidadTotalPalabras;
				}
				else{
					if ((x+1) == T.CantidadTotalPalabras){
						
						if (IdGenerado.equals("")){
							IdGenerado = G.vSinID;
						}
						else{
							IdGenerado = IdGenerado + "-" + G.vSinID;
						}
					}
				}
			}
		}
		//System.out.println("IdGenerado: " + IdGenerado);
		//Verifica existencia de IdGenerado en combinaciones logicas
		boolean ExisteIDGenerado = ExisteIDGenerado(IdGenerado);
		if (ExisteIDGenerado == true){
			boolean ExisteIDSalida = ExisteIDSalida(IdGenerado); 
			if (ExisteIDSalida == true){
				int CantidadSalida = CantidadSalidaExiste(IdGenerado);
				String Salida[] = new String [CantidadSalida];	//Cadena de Posible Salida
				int NumeroSalida[] = new int [CantidadSalida];	//Numero de Salida
				//Guarda Posible Salida y su Numero
				int x = 0;
				while(CantidadSalida>x){
					for (int i=0;i<T.CantidadTotalSalidas;i++){
						if (T.IdEntrada[i].equals(IdGenerado)){
							Salida[x] = T.IdSalida[i];
							NumeroSalida[x] = x;
							x++;
						}
						else{
							if(CantidadSalida == (x-1)){
								if (T.CantidadTotalSalidas == (i+1)){
									//Modulo de Error
									//G.vDescripcion = "No existe combinacion logica para: " + T.IdEntrada[i];
									//GeneraError(IdGenerado,pEntrada,G.vDescripcion);
								}
							}
						}
					}
				}
				int EligeSalida = (int) (Math.random()* CantidadSalida);	//Numero aleatorio de Salida
				String IDSalida = Salida[EligeSalida];	//Combinacion salida definitiva
				String CadenaSalida = GeneraCadenaSalida(IDSalida);		//Cadena salida definitiva
				SalidaGUI(CadenaSalida,1);	//Salida por GUI
				AsignaGuardaSalida();	//Sin Errores
			}
			else{
				//Modulo de Error
				//Programas P = new Programas();
				String CadenaSalida = NoEntiendo();	//Cadena salida definitiva
				SalidaGUI(CadenaSalida,1);	//Salida por GUI
				//G.vDescripcion = "IdGenerado sin salida: " + IdGenerado;
				//GeneraError(IdGenerado,pEntrada,G.vDescripcion);
			}
		}
		else{
			//Modulo de Error
			//Programas P = new Programas();
			String CadenaSalida = NoEntiendo();	//Cadena salida definitiva
			SalidaGUI(CadenaSalida,1);	//Salida por GUI
			//G.vDescripcion = "Palabra aun no configurada o no existe";
			//GeneraError(IdGenerado,pEntrada,G.vDescripcion);
		}
	}
	//
	private void SalidaGUI(String pSalida,int pPerfil){
		this.TxtAreaSuperior.setText(this.TxtAreaSuperior.getText() + "\n" + G.vOut[pPerfil] + "> " + pSalida + ".");
		this.TxtEntrada.setText(null);
	}
	//
	private void GeneraError(String pID,String pEntrada,String pDescripcion){
		for(int i=0;i<T.CantidadTotalErrores;i++){
			if (T.IdError[i].equals(pID) && T.EntradaError[i].equals(pEntrada)){
				i = T.CantidadTotalErrores;
			}
			else{
				if((i+1)==T.CantidadTotalErrores){
					E.EscribeExcel(G.vPestanasArchivo[3],0,T.CantidadTotalErrores,pID,"S");
					E.EscribeExcel(G.vPestanasArchivo[3],1,T.CantidadTotalErrores,pEntrada,"S");
					E.EscribeExcel(G.vPestanasArchivo[3],2,T.CantidadTotalErrores,pDescripcion,"S");
				}
			}
		}
	}
	//
	boolean ExisteIDGenerado(String pID){
		for (int i = 0;i < T.CantidadTotalEntradas;i++){
			if(T.Combinacion[i].equals(pID)){ 
				i = T.CantidadTotalEntradas;
				return true;
			}
			else{
				if ((i+1) == T.CantidadTotalEntradas){
					i = T.CantidadTotalEntradas;
					return false;
				}
			}
		}
		return false;
	}
	//
	boolean ExisteIDSalida(String pID){
		int CantidadSalida = 0;
		for (int i = 0; i < T.CantidadTotalSalidas;i++){
			if (T.IdEntrada[i].equals(pID)){
				CantidadSalida++;
			}
		}
		if (CantidadSalida != 0){
			return true;
		}else{
			return false;
		}
	}
	//
	int CantidadSalidaExiste(String pID){
		int CantidadSalida = 0;
		for (int i = 0; i < T.CantidadTotalSalidas;i++){
			if (T.IdEntrada[i].equals(pID)){
				CantidadSalida++;
			}
		}
		return CantidadSalida;
	}
	//
	String GeneraCadenaSalida(String pID){
		String CadenaSalida = "";
		int CantidadPalabraSalida = 0;
		for (int i=0;i < pID.length();i++){
			char Caracter = pID.charAt(i);
			if (Caracter == '-'){
				CantidadPalabraSalida++;
			}
		}
		CantidadPalabraSalida = CantidadPalabraSalida+1;
		//Variable donde se guardan IdPalabra
		String Numeros[] = new String[CantidadPalabraSalida];
		for (int i=0;i<CantidadPalabraSalida;i++){
			Numeros[i] = "";
		}
		//Cantidad de Palabras
		int CantidadSeparador = 0;
		//Almacena numero de palabra en Arreglo
		for(int i=0;i<pID.length();i++){
			char Caracter = pID.charAt(i);
			if (Caracter == '-'){
				CantidadSeparador++;
			}
			else{
				Numeros[CantidadSeparador] = Numeros[CantidadSeparador] + Caracter;
			}
		}
		//Busca palabra segun Numero almacenado
		for (int i=0;i<=CantidadSeparador;i++){
			for(int w=0;w<T.CantidadTotalPalabras;w++){
				if (T.IdPalabra[w].equals(Numeros[i])){
					CadenaSalida = CadenaSalida + " " + T.Palabra[w];
					w = T.CantidadTotalPalabras;
				}
			}
		}
		CadenaSalida = CadenaSalida.trim();
		return CadenaSalida;
	}
	//
	String NoEntiendo(){
		String CadenaSalida = "";
		String IdCombinacion = "";
		boolean ExistePalabra = false;
		int EligeSalida = 0;
		while(ExistePalabra == false){
			EligeSalida = (int) (Math.random()* IdPalabraNoEntiendo.length);
			ExistePalabra = GuardaSalida(EligeSalida);
		}
		//
		String Palabra = IdPalabraNoEntiendo[EligeSalida];
		for(int x=0;x<Palabra.length();x++){
			String Letra = Palabra.charAt(x) + "";
			if(Letra.equals("-")){ 
				for(int i=0;i<T.CantidadTotalPalabras;i++){
					if (IdCombinacion.equals(T.IdPalabra[i])){
						CadenaSalida = CadenaSalida + " " + T.Palabra[i];
					}
				}
				IdCombinacion = "";
			}
			else{
				IdCombinacion = IdCombinacion + Letra;
				if((x+1)==Palabra.length()){
					for(int i=0;i<T.CantidadTotalPalabras;i++){
						if (IdCombinacion.equals(T.IdPalabra[i])){
							CadenaSalida = CadenaSalida + " " + T.Palabra[i];
						}
					}
				}
			}
		}
		CadenaSalida = CadenaSalida.trim();
		return CadenaSalida;
	}
	//
	void AsignaGuardaSalida(){
		for(int i=0; i<IdPalabraNoEntiendo.length;i++){
			GuardaIdPalabraNoEntiendo[i] = IndicadorVacio;
		}
	}
	//
	boolean GuardaSalida(int pNumero){
		//Busca numero
		boolean ExisteNum = true;
		for(int i=0; i<IdPalabraNoEntiendo.length;i++){
			if (GuardaIdPalabraNoEntiendo[i] == pNumero){
				ExisteNum = false;
			}
			if ((i+1)==IdPalabraNoEntiendo.length && GuardaIdPalabraNoEntiendo[i] != IndicadorVacio){ 
				javax.swing.JOptionPane.showMessageDialog(null,"Ha sido desconectado.");
				System.exit(0);
			}
		}
		//
		if (ExisteNum == true){
			for(int i=0; i<IdPalabraNoEntiendo.length;i++){
				if (GuardaIdPalabraNoEntiendo[i] == IndicadorVacio){
					GuardaIdPalabraNoEntiendo[i] = pNumero;
					i = IdPalabraNoEntiendo.length;
				}
			}
		}
		return ExisteNum;
	}
	//
	/*
	public static void main(String[] args) {
		GUI G = new GUI();
	}
	*/
	//
	private void initComponents() {
		VentanaChat = new javax.swing.JFrame();
		jScrollPane1 = new javax.swing.JScrollPane();
		TxtAreaSuperior = new javax.swing.JTextArea();
		BtSalir = new java.awt.Button();
		TxtEntrada = new javax.swing.JTextField();
		BarraMenu = new javax.swing.JMenuBar();
		Menu_1 = new javax.swing.JMenu();
		Separador_1 = new javax.swing.JPopupMenu.Separator();
		MenuItem_MI = new javax.swing.JMenuItem();
		Separador_2 = new javax.swing.JPopupMenu.Separator();
		VentanaAcerca = new javax.swing.JDialog(VentanaChat);
		BtCerrar = new java.awt.Button();
		jLabel1 = new javax.swing.JLabel();
		Panel_1 = new javax.swing.JPanel();
		BtEntrar = new java.awt.Button();
		TxtAreaSuperior.setEditable(false);
		TxtAreaSuperior.setColumns(20);
		TxtAreaSuperior.setFont(new java.awt.Font("Consolas", 0, 12));
		TxtAreaSuperior.setLineWrap(true);
		TxtAreaSuperior.setRows(5);
		TxtAreaSuperior.setFocusable(false);
		jScrollPane1.setViewportView(TxtAreaSuperior);
		BtSalir.setFont(new java.awt.Font("Consolas", 0, 12));
		BtSalir.setLabel("¡Salir!");
		BtSalir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtSalirActionPerformed(evt);
			}
		});
		TxtEntrada.setFont(new java.awt.Font("Consolas", 0, 12)); 
		TxtEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		TxtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				TxtEntradaKeyTyped(evt);
			}
		});
		Menu_1.setText("Acerca de");
		Menu_1.add(Separador_1);
		MenuItem_MI.setText("Youbrain");
		MenuItem_MI.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				MenuItem_MIActionPerformed(evt);
			}
		});
		Menu_1.add(MenuItem_MI);
		Menu_1.add(Separador_2);
		BarraMenu.add(Menu_1);
		VentanaChat.setJMenuBar(BarraMenu);
		javax.swing.GroupLayout VentanaChatLayout = new javax.swing.GroupLayout(VentanaChat.getContentPane());
		VentanaChat.getContentPane().setLayout(VentanaChatLayout);
		VentanaChatLayout.setHorizontalGroup(
			VentanaChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(VentanaChatLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(VentanaChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGroup(VentanaChatLayout.createSequentialGroup()
						.addComponent(TxtEntrada)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(BtSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap())
		);
		VentanaChatLayout.setVerticalGroup(
			VentanaChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(VentanaChatLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(VentanaChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
					.addComponent(BtSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(TxtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		BtCerrar.setFont(new java.awt.Font("Consolas", 0, 12)); 
		BtCerrar.setLabel("Cerrar");
		BtCerrar.setName(""); 
		BtCerrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtCerrarActionPerformed(evt);
			}
		});
		jLabel1.setFont(new java.awt.Font("Consolas", 0, 10)); 
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel1.setText("jLabel1");
		jLabel1.setToolTipText("");
		jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		jLabel1.setAutoscrolls(true);
		javax.swing.GroupLayout VentanaAcercaLayout = new javax.swing.GroupLayout(VentanaAcerca.getContentPane());
		VentanaAcerca.getContentPane().setLayout(VentanaAcercaLayout);
		VentanaAcercaLayout.setHorizontalGroup(
			VentanaAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(VentanaAcercaLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(BtCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap())
		);
		VentanaAcercaLayout.setVerticalGroup(
			VentanaAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(VentanaAcercaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(VentanaAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(VentanaAcercaLayout.createSequentialGroup()
						.addGap(0, 255, Short.MAX_VALUE)
						.addComponent(BtCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap())
		);
		VentanaAcerca.getAccessibleContext().setAccessibleDescription("");
		BtEntrar.setFont(new java.awt.Font("Consolas", 0, 12)); 
		BtEntrar.setLabel("¡Entrar!");
		BtEntrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BtEntrarActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout Panel_1Layout = new javax.swing.GroupLayout(Panel_1);
		Panel_1.setLayout(Panel_1Layout);
		Panel_1Layout.setHorizontalGroup(
			Panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(Panel_1Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(BtEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
				.addContainerGap())
		);
		Panel_1Layout.setVerticalGroup(
			Panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(Panel_1Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(BtEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
				.addContainerGap())
		);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(Panel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(Panel_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
	}
	//
	private void BtEntrarActionPerformed(java.awt.event.ActionEvent evt) {
		VentanaChat.setUndecorated(true);
		VentanaChat.show();
		VentanaChat.setBounds(20,20,300,300);
		VentanaChat.pack();
		VentanaChat.setLocationRelativeTo(null);
		TxtAreaSuperior.setText("");
		TxtEntrada.setText("");
	}
	//
	private void BtSalirActionPerformed(java.awt.event.ActionEvent evt) {
		this.VentanaChat.dispose();
	}
	//
	private void TxtEntradaKeyTyped(java.awt.event.KeyEvent evt) {
		String Caracter = evt.getKeyChar() + "";
		java.util.regex.Pattern patron = java.util.regex.Pattern.compile("[^A-Za-z ]");
		java.util.regex.Matcher encaja = patron.matcher(Caracter);
		if(!encaja.find()) {
		}
		else {
			if(evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER){
				this.EntradaEvento(evt);
			}
			evt.consume();
		}
	}
	//
	private void MenuItem_MIActionPerformed(java.awt.event.ActionEvent evt) {
		VentanaAcerca.setUndecorated(true);
		VentanaAcerca.show();
		VentanaAcerca.setBounds(20,20,300,300);
		VentanaAcerca.pack();
		VentanaAcerca.setLocationRelativeTo(null); 
		String AcercaDe = 
			"<html>"+
				"Youbrain,<br> Es una aplicacion nacida del intelecto de Emilio J.Gz Graterol<br>" +
				"Un chico de nacionalidad Venezolano"+
			"</html>";
		jLabel1.setText(AcercaDe);
	}
	//
	private void BtCerrarActionPerformed(java.awt.event.ActionEvent evt) {
		this.VentanaAcerca.dispose();
	}
	//
	private javax.swing.JMenuBar BarraMenu;
	private java.awt.Button BtCerrar;
	private java.awt.Button BtEntrar;
	private java.awt.Button BtSalir;
	private javax.swing.JMenuItem MenuItem_MI;
	private javax.swing.JMenu Menu_1;
	private javax.swing.JPanel Panel_1;
	private javax.swing.JPopupMenu.Separator Separador_1;
	private javax.swing.JPopupMenu.Separator Separador_2;
	private javax.swing.JTextArea TxtAreaSuperior;
	private javax.swing.JTextField TxtEntrada;
	private javax.swing.JDialog VentanaAcerca;
	private javax.swing.JFrame VentanaChat;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
}
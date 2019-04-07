import java.io.*;

public class ClaseEntrada{
	//ClasePrincipal CP = new ClasePrincipal();	
	ClaseTabla CT = new ClaseTabla();
	//
	public void ProcesoEntrada(String p_entrada){
		//Entrada
		int CantidadCaracteres = 0;
		int CantidadPalabras = 1;
		p_entrada = p_entrada.trim();
		p_entrada.toLowerCase();
		System.out.println("Cadena Entrada: " +  p_entrada);
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
		//System.out.println("Cantidad Caracteres: " + CantidadCaracteres);
		//System.out.println("Cantidad Palabras: " + CantidadPalabras);
		int EmpiezaPalabra[] = new int [CantidadPalabras];
		int TerminaPalabra[] = new int [CantidadPalabras];
		String GuardaPalabras[] = new String [CantidadPalabras];
		//
		int Indicator = 0;
		int Bandera = 0;
		//
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
		//Proceso
		CT.TablaPalabras();
		CT.TablaCombinacion();
		CT.TablaSalida();
		String GuardaLocalizador = "";
		for(int i = 0;i < CantidadPalabras;i++){
			for (int x = 0;x < CT.CantidadRegistros;x++){
				if (CT.PalabraEntrada[x].equals(GuardaPalabras[i])){
					//System.out.println("Si esta: " + GuardaPalabras[i]);
					if (GuardaLocalizador == ""){
						GuardaLocalizador = "" + CT.LocalizadorEntrada[x];
					}
					else{
						GuardaLocalizador = GuardaLocalizador + "-" + CT.LocalizadorEntrada[x];
					}
					x = CT.CantidadRegistros;
				}
				/*else{
					System.out.println("No esta: " + GuardaPalabras[i]);
				}*/
			}
		}
		//Busca Localizador
		int Entendio = 0;
		for (int i = 0;i < CT.CantidadCombinaciones;i++){
			if(CT.CombinacionLocalizador[i].equals(GuardaLocalizador)){
				System.out.println("Entiendo.");
				Entendio = 1;
			}
		}
		//Busca Salida
		if (Entendio == 1){
			int CantidadRespuestaSalida = 0;
			for (int i = 0; i < CT.CantidadRespuestas;i++){
				if (CT.LocalizadorCombinacionEntrada[i].equals(GuardaLocalizador)){
					CantidadRespuestaSalida = CantidadRespuestaSalida + 1;
				}
			}
			System.out.println("Encontrado: "+ CantidadRespuestaSalida);
			String Respuestas[] = new String [CantidadRespuestaSalida];
			int NumeroRespuesta[] = new int [CantidadRespuestaSalida];
			int x=0;
			while(x < CantidadRespuestaSalida){
				for (int i = 0; i < CT.CantidadRespuestas;i++){
					if (CT.LocalizadorCombinacionEntrada[i].equals(GuardaLocalizador)){
						Respuestas[x] = CT.LocalizadorCombinacionSalida[i];
						NumeroRespuesta[x] = x;
						System.out.println("Posibles Respuestas: "+ x + ": "+Respuestas[x]);
						x++;
					}
				}
			}
		}
		else{
			//Crear Modulo para nuevas palabras.
		}
	}
}
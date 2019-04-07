public class ClaseTabla{
	int CantidadRegistros = 8;
	public String PalabraEntrada[] = new String [CantidadRegistros];
	public int LocalizadorEntrada[] = new int[CantidadRegistros];
	//
	public void TablaPalabras(){
		PalabraEntrada[0] = "hola";
		LocalizadorEntrada[0]= 0;
		PalabraEntrada[1] = "como";
		LocalizadorEntrada[1]= 1;
		PalabraEntrada[2] = "estas";
		LocalizadorEntrada[2]= 2;
		PalabraEntrada[3] = "tu";
		LocalizadorEntrada[3]= 3;
		PalabraEntrada[4] = "estoy";
		LocalizadorEntrada[4]= 4;
		PalabraEntrada[5] = "bien";
		LocalizadorEntrada[5]= 5;
		PalabraEntrada[6] = "mal";
		LocalizadorEntrada[6] = 6;
		PalabraEntrada[7] = "normal";
		LocalizadorEntrada[7]= 7;
	}
	//
	int CantidadCombinaciones = 6;
	public String CombinacionLocalizador[] = new String [CantidadCombinaciones];
	//
	public void TablaCombinacion(){
		CombinacionLocalizador[0] = "0";
		CombinacionLocalizador[1] = "0-1-2";
		CombinacionLocalizador[2] = "0-1-2-3";
		CombinacionLocalizador[3] = "1-2";
		CombinacionLocalizador[4] = "1-2-3";
		CombinacionLocalizador[5] = "3-1-2";
	}
	//
	int CantidadRespuestas = 9;
	public String LocalizadorCombinacionEntrada[] = new String [CantidadRespuestas];
	public String LocalizadorCombinacionSalida[] = new String [CantidadRespuestas];
	//
	public void TablaSalida(){
		//Pregunta 1
		LocalizadorCombinacionEntrada[0] = "0";
		LocalizadorCombinacionSalida[0] = "0-1-2";
		LocalizadorCombinacionEntrada[1] = "0";
		LocalizadorCombinacionSalida[1] = "1-2";
		LocalizadorCombinacionEntrada[2] = "0";
		LocalizadorCombinacionSalida[2] = "3-1-2";
		//Pregunta 2
		LocalizadorCombinacionEntrada[3] = "1-2";
		LocalizadorCombinacionSalida[3] = "4-5";
		LocalizadorCombinacionEntrada[4] = "1-2";
		LocalizadorCombinacionSalida[4] = "4-6";
		LocalizadorCombinacionEntrada[5] = "1-2-*";	// Prueba
		LocalizadorCombinacionSalida[5] = "4-7";
		//Pregunta 3
		LocalizadorCombinacionEntrada[6] = "1-2-3";
		LocalizadorCombinacionSalida[6] = "4-5";
		LocalizadorCombinacionEntrada[7] = "1-2-3";
		LocalizadorCombinacionSalida[7] = "4-6";
		LocalizadorCombinacionEntrada[8] = "1-2-3";
		LocalizadorCombinacionSalida[8] = "4-7";
	}
}
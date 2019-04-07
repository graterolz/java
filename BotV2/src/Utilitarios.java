public class Utilitarios {
	//
	public String FormatoEntrada(String pCadena){
		pCadena = pCadena.trim();
		pCadena = pCadena.toLowerCase();
		// Eliminar acentos
		return pCadena;
	}
	//
	public int CantidadLetras(String pCadena){
		int vCantidadCaracteres = 0;
		
		for (int i = 0;i < pCadena.length();i++){
			vCantidadCaracteres++;
		}
		return vCantidadCaracteres;
	}
	//
	public int CantidadPalabras(String pCadena){
		int vCantidadCaracteres = 0;
		int vCantidadPalabras = 1;
		for (int i = 0;i < pCadena.length();i++){
			char Caracter = pCadena.charAt(i);
			if (Caracter == ' '){
				vCantidadPalabras++;
			}
			vCantidadCaracteres++;
		}
		if (vCantidadCaracteres == 0){
			vCantidadPalabras = 0;
		}
		return vCantidadPalabras;
	}
	//
	/*
	public static void main(String[] args) {
		Utilitarios U = new Utilitarios();
	}
	*/
}
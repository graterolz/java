public class ClaseSalida{
	ClasePrincipal CP = new ClasePrincipal();
	public String p_salida = "Respuesta";
	//
	void SalidaBOT(String p_cadena){
		int CantidadCaracteres = 0;
		char Caracter;
		for (int Cuenta = 0;Cuenta < p_cadena.length();Cuenta++){
			Caracter = p_cadena.charAt(Cuenta);
			Caracter = Character.toLowerCase(Caracter);
			CantidadCaracteres++;
		}
		//System.out.println(CantidadCaracteres);
		/*try{
			Thread.currentThread().sleep(1000);
		}
		catch(InterruptedException ie){
			System.out.println(CP.p_error);
		}*/
	}
}
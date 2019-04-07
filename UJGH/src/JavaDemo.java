import java.io.*;
public class JavaDemo {
	//
	public void J001_HolaMundo(){
		System.out.println("Hola Mundo!!!");
	}
	//
	public void J002_ImprimeCadena() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Ingresa cadena de caracteres: ");
		String mensaje = EntradaTeclado.readLine();
		System.out.println("La cadena de caracteres es: " + mensaje);
	}
	//
	public void J003_CantidadLetrasCadena() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Ingresa cadena de caracteres: ");
		String mensaje = EntradaTeclado.readLine();
		System.out.println("La cadena de caracteres es: " + mensaje.length());
	}
	//
	public void J004_Suma2Numeros() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int numero1,numero2;
		System.out.print("Ingrese primer numero: ");
		numero1 = Integer.parseInt(EntradaTeclado.readLine());
		System.out.print("Ingrese segundo numero: ");
		numero2 = Integer.parseInt(EntradaTeclado.readLine());
		int suma = numero1 + numero2;
		System.out.print("La suma es: " + suma);
	}	
	//
	public void J005_Resta2Numeros() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int numero1,numero2;
		System.out.print("Ingrese primer numero: ");
		numero1 = Integer.parseInt(EntradaTeclado.readLine());
		System.out.print("Ingrese segundo numero: ");
		numero2 = Integer.parseInt(EntradaTeclado.readLine());
		int resta = numero1 - numero2;
		System.out.print("La resta es: " + resta);
	}
	//
	public static void main(String args[]){
		JavaDemo4 J;
		J = new JavaDemo4();
		//
		try {
			//J.J001_HolaMundo();
			//J.J002_ImprimeCadena();
			//J.J003_CantidadLetrasCadena();
			//J.J004_Suma2Numeros();
			//J.J005_Resta2Numeros();
			//J.J006_Multiplicacion2Numeros();
			//J.J007_Division2Numeros();
			//J.J008_PotenciaNumero();
			//J.J009_RaizCuadrada();
			//J.J010_NumeroMayor();
			//J.J011_NumerosOrden();
			//J.J012_ContarNumeros();
			//J.J013_SegundosMinutos();
			//J.J014_AnioBisiesto();
			//J.J015_FechaHoraActual();
			//J.J016_TablaMultiplicarDel1Al9();
			//J.J017_CadenaMinuscula();
			//J.J018_CadenaMayuscula();
			//J.J019_PromedioDeNNumeros();
			//J.J020_ShowMessageDialog();
			//J.J021_ShowMessageCadena();
			//J.J022_BarraProceso();
			J.J023_InformacionSO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
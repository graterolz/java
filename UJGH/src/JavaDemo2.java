import java.io.*;
public class JavaDemo2 {
	//
	public void J006_Multiplicacion2Numeros() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int numero1,numero2;
		System.out.print("Ingrese primer numero: ");
		numero1 = Integer.parseInt(EntradaTeclado.readLine());
		System.out.print("Ingrese segundo numero: ");
		numero2 = Integer.parseInt(EntradaTeclado.readLine());
		int multipli = numero1 * numero2;
		System.out.print("La multiplicacion es: " + multipli);
	}
	//
	public void J007_Division2Numeros() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int numero1,numero2;
		System.out.print("Ingrese dividendo (X): ");
		numero1 = Integer.parseInt(EntradaTeclado.readLine());
		System.out.print("Ingrese divisor (Y): ");
		numero2 = Integer.parseInt(EntradaTeclado.readLine());
		if (numero2!=0){
			int division = numero1 / numero2;
			int residuo = numero1 % numero2;
			System.out.print("La division (X/Y) es: " + division + ", Residuo: " + residuo);
		}
		else{
			System.out.print("El divisor no puede ser 0.");
		}
	}
	//
	public void J008_PotenciaNumero() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int base,exponente;
		System.out.print("Ingrese valor de la base: ");
		base = Integer.parseInt(EntradaTeclado.readLine());
		System.out.print("Ingrese divisor (Y): ");
		exponente = Integer.parseInt(EntradaTeclado.readLine());
		double potencia = Math.pow(base,exponente);
		System.out.print("La Potencia es: " + potencia);
	}
	//
	public void J009_RaizCuadrada() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int numero;
		System.out.print("Ingrese numero: ");
		numero = Integer.parseInt(EntradaTeclado.readLine());
		if (numero>-1){
			double raiz = Math.sqrt(numero);
			System.out.print("La Raiz cuadrada es: " + raiz);
		}
		else{
			System.out.print("La raiz cuadrada debe ser mayor igual a cero (0).");
		}
	}
	//
	public void J010_NumeroMayor() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int numero1,numero2;
		System.out.print("Ingrese primer numero: ");
		numero1 = Integer.parseInt(EntradaTeclado.readLine());
		System.out.print("Ingrese segundo numero: ");
		numero2 = Integer.parseInt(EntradaTeclado.readLine());
		if(numero1>numero2){
			System.out.print("Es mayor el primer numero: " + numero1);
		}
		else if (numero1<numero2){
			System.out.print("Es mayor el segundo numero: " + numero2);
		}
		else{
			System.out.print("Ninguno, Son iguales los dos numeros.");
		}
	}
}
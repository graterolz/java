import java.io.*;
class Class39{
	static int obtenerSuma(int a,int b){
		return (a+b);
	}
	//
	static int obtenerResta(int a,int b){
		return (a-b);
	}
	//
	static int obtenerProducto(int a,int b){
		return (a*b);
	}
	//
	static int obtenerCociente(int a,int b){
		return (a/b);
	}
	//
	static int obtenerModulo(int a,int b){
		return(a%b);
	}
	//
	public static void main(String[] args){
		InputStreamReader irs = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (irs);
		try{
			System.out.print("Ingrese Numero: ");
			int Numero_1 = Integer.parseInt(br.readLine());
			System.out.print("Ingrese Numero: ");
			int Numero_2 = Integer.parseInt(br.readLine());
			System.out.println("********************");
			System.out.println("*La Suma Es: "+obtenerSuma(Numero_1,Numero_2));
			System.out.println("*La Resta Es: "+obtenerResta(Numero_1,Numero_2));
			System.out.println("*El Producto Es: "+obtenerProducto(Numero_1,Numero_2));
			System.out.println("*El Cociente Es: "+obtenerCociente(Numero_1,Numero_2));
			System.out.println("*El Modulo Es: "+obtenerModulo(Numero_1,Numero_2));
			System.out.println("********************");
		}
		catch(ArithmeticException ae){
			System.out.println("*El Cociente Es: INDETERMINADO.");
			System.out.println("*El Modulo Es: INDETERMINADO.");
			System.out.println("********************");
		}
		catch(NumberFormatException nfe){
			System.out.println("*Lo que Ha Ingresado NO es un Numero ENTERO, VERIFIQUE.");
		}        
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
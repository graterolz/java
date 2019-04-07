import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class JavaNoTest11 {
	//
	public void Program201(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Cantidad de numeros a ingresar: ");
		int n = sc.nextInt();
		int contador = 0;
		for (int i = 0; i < n; i++) {
			System.out.print("Numero "+(i+1)+": ");
			int numero = sc.nextInt();
			if (numero == 0) {
				contador ++;
			}
		}
		System.out.println("La cantidad de ceros ingresados fueron: "+contador);
	}
	//
	public void Program202(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Cantidad de numeros a ingresar: ");
		int n = sc.nextInt();
		int[] arreglo = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Numero "+(i+1)+": ");
			arreglo[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			int numero = arreglo[i];
			int cubo = numero * numero * numero;
			System.out.println("El cubo de "+arreglo[i]+" es: "+cubo);
		}
	}
	//
	public void Program203(){
		Scanner sc = new Scanner(System.in);
		int pares = 0;
		int impares = 0;
		for (int i = 0; i <= 270; i++) {
			if (i % 2 == 0) {
				pares += i;
			}else{
				impares += i;
			}
		}
		System.out.println("La suma de los numeros pares del 0 al 270 es: "+pares);
		System.out.println("La suma de los numeros impares del 0 al 270 es: "+impares);
	}
	//
	public void Program204(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Matricula del estudiante: ");
		String matricula = sc.nextLine();
		System.out.print("Nota 1: ");
		int n1 = sc.nextInt();
		System.out.print("Nota 2: ");
		int n2 = sc.nextInt();
		System.out.print("Nota 3: ");
		int n3 = sc.nextInt();
		System.out.print("Nota 4: ");
		int n4 = sc.nextInt();
		System.out.print("Nota 5: ");
		int n5 = sc.nextInt();
		float total = n1 + n2 + n3 + n4 + n5;
		float promedio = total / 5;
		System.out.println("Matricula: "+matricula);
		System.out.println("Promedio: "+promedio);
	}
	//
	public void Program205(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Cantidad de numeros a ingresar: ");
		int n = sc.nextInt();
		long[] arreglo = new long[n];
		long[] arreglo2 = new long[n];
		long total = 0;
		for (int i = 0; i < n; i++) {
			System.out.print("Numero "+(i+1)+": ");    
			arreglo[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			long acumulador = 1;
			long numero = arreglo[i];
			for (int j = 1; j <= (i+1); j++) {
				acumulador *= numero;
				System.out.println("Acumulado: "+acumulador);
			}
			arreglo2[i] = acumulador;
			total += arreglo2[i];
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arreglo[i]+"^"+(i+1)+": "+arreglo2[i]);
		}
		System.out.println("Total: "+total);
	}
	//
	public void Program206(){
		Scanner sc = new Scanner(System.in);
		int[] arreglo = new int[3];
		int mayor = 0;
		for (int i = 0; i < 3; i++) {
			System.out.print("Numero "+(i+1)+": ");    
			arreglo[i] = sc.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			if (arreglo[i] > mayor) {
				mayor = arreglo[i];
			}
		}
		System.out.println("Numero mas alto ingresado: "+mayor);
	}
	//
	public void Program207(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Numero: ");
		int n = sc.nextInt();
		int cuadrado = n * n;
		int cubo = n * n * n;
		System.out.println("Cuadrado: "+cuadrado);
		System.out.println("Cubo: "+cubo);
	}
	//
	public void Program208(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Base: ");
		int base = sc.nextInt();
		System.out.print("Altura: ");
		int altura = sc.nextInt();
		int superficie = base * altura;
		int perimetro = 2 * ( base + altura );
		System.out.println("Superficie: "+superficie);
		System.out.println("Perimetro: "+perimetro);
	}
	//
	public void Program209(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Costo del articulo: ");
		int costo = sc.nextInt();
		System.out.print("Dinero recibido: ");
		int dinero = sc.nextInt();
		int cambio = dinero - costo;
		System.out.println("Cambio: "+cambio);
	}
	//
	public void Program210(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Base: ");
		int base = sc.nextInt();
		System.out.print("Altura: ");
		int altura = sc.nextInt();
		float superficie = (base * altura) / 2;
		System.out.println("Superficie: "+superficie);
	}
	//
	public void Program211() {
		boolean b;
		b = false;
		System.out.println("b es "+b);
		b = true;
		System.out.println("b es "+b);
		if (b)
			System.out.println("Esto se ejecuta");
		b = false;
		if (b)
			System.out.println("Esto no se ejecuta");
		System.out.println("10>9 "+(10>9));
	}
	//
	public void Program212() {
		byte b;
		int i=257;
		double d=323.142;
		System.out.println("\n Conversión: int a byte");
		b = (byte) i;
		System.out.println("i y b "+ i + " "+ b);
		System.out.println("\n Conversión: double a int"); 
		i = (int) d;
		System.out.println("d y i "+ d + " "+ i);
		System.out.println("\nConversión: double a byte"); 
		b = (byte) d;
		System.out.println("d y b "+ d + " "+ b);
	}
	//
	public void Program213() {
		JFrame ventana = new JFrame("Mi primera ventana");
		JLabel jl1, jl2, jl3, jl4;
		JButton jb1,jb2;
		jl1 = new JLabel("Hola Mundo");
		jl2 = new JLabel("Mi nombre es: Wilman");
		jl3 = new JLabel("Estoy Feliz"); 
		jl4 = new JLabel("Bienvenidos");
		jb1 = new JButton("Aceptar"); 
		jb2 = new JButton("Cancelar");
		FlowLayout flowLayout= new FlowLayout();
		ventana.getContentPane().setLayout(flowLayout);
		ventana.getContentPane().add(jl1);
		ventana.getContentPane().add(jl2);
		ventana.getContentPane().add(jl3);
		ventana.getContentPane().add(jl4);
		ventana.getContentPane().add(jb1);
		ventana.getContentPane().add(jb2);
		ventana.setVisible(true);
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//
	//220
}
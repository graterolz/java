import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class JavaNoTest10 {
	//
	public void Program181() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Radio: ");
		int radio = sc.nextInt();
		System.out.print("Altura: ");
		int altura = sc.nextInt();
		float area = (float)(2 * 3.14 * radio * altura);
		float volumen = (float)(3.14 * (radio * radio) * altura);
		System.out.println("Area: "+area);
		System.out.println("Volumen: "+volumen);
	}
	//
	public void Program182() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dias: ");
		int dias = sc.nextInt();
		int segundos = 60;
		int minutos = 60;
		int horas = segundos * minutos;
		int horasDias = 24 * horas;
		long segundosDias = dias * horasDias;
		System.out.println("Cantidad de segundos en "+dias+" son: "+segundosDias);		
	}
	//
	public void Program183() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Lado 1: ");
		int lado1 = sc.nextInt();
		System.out.print("Lado 2: ");
		int lado2 = sc.nextInt();
		System.out.print("Lado 3: ");
		int lado3 = sc.nextInt();
		float s1 = (float)(lado1 + lado2 + lado3)/2;
		float s2 = (float)(s1*(s1-lado1)*(s1-lado2)*(s1-lado3));
		if (s2 > 0) {
			float area = (float)Math.sqrt(s2);
			System.out.println("Area: "+area);
		}
	}
	//
	public void Program184(){
		Scanner sc = new Scanner(System.in);
		System.out.print("x1: ");
		int x1 = sc.nextInt();
		System.out.print("x2: ");
		int x2 = sc.nextInt();
		System.out.print("y1: ");
		int y1 = sc.nextInt();
		System.out.print("y2: ");
		int y2 = sc.nextInt();
		int p1 = x1 - x2;
		int p11 = p1 * p1;
		int p2 = y1-y2;
		int p22 = p2 * p2;
		float distancia = (float)(Math.sqrt(p11+p22));
		System.out.println("Distancia entre puntos: "+distancia);
	}
	//
	public void Program185(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre del dinosaurio: ");
		String nombre = sc.nextLine();
		System.out.print("Peso(libras): ");
		int peso = sc.nextInt();
		System.out.print("Longitud(pies): ");
		int longitud = sc.nextInt();
		int pesoKg = peso * 1000;
		float longitudMt = (float) (longitud * 0.3047);
		System.out.println("Peso(kg): "+pesoKg);
		System.out.println("Longitud(mt): "+longitudMt);
	}
	//
	public void Program186(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Galones surtidos: ");
		int galon = sc.nextInt();
		float galonLt = (float)(galon * 3.785);
		float precio = (float) (galonLt * 4.50);
		System.out.println("Precio en litros a cobrar: "+precio);
	}
	//
	public void Program187(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Nota: ");
		int nota = sc.nextInt();
		if (nota > 8) {
			System.out.println("Aprobado");
		}
	}
	//
	public void Program188(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Sueldo: ");
		int sueldo = sc.nextInt();
		float nsueldo;
		if (sueldo < 1000) {
			nsueldo = (float)((sueldo * 0.15) + sueldo);
		}else{
			nsueldo = sueldo;
		}
		System.out.println("Sueldo del trabajador: "+nsueldo);
	}
	//
	public void Program189(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Nota:");
		int nota = sc.nextInt();
		if (nota > 8) {
			System.out.println("Aprobado");
		}else{
			System.out.println("Reprobado");
		}
	}
	//
	public void Program190(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Sueldo: ");
		int sueldo = sc.nextInt();
		float nsueldo;
		if (sueldo < 1000) {
			nsueldo = (float)((sueldo * 0.15) + sueldo);
		}else{
			nsueldo = (float)((sueldo * 0.12) + sueldo);
		}
		System.out.println("Sueldo del trabajador: "+nsueldo);
	}
	//
	public void Program191(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Categoria: ");
		int categoria = sc.nextInt();
		System.out.print("Sueldo: ");
		int sueldo = sc.nextInt();
		float nsueldo = 0;
		if (categoria == 1) {
			nsueldo = (float)((sueldo * 0.15) + sueldo);
		}
		if (categoria == 2) {
			nsueldo = (float)((sueldo * 0.10) + sueldo);
		}
		if (categoria == 3) {
			nsueldo = (float)((sueldo * 0.08) + sueldo);
		}
		if (categoria == 4) {
			nsueldo = (float)((sueldo * 0.07) + sueldo);
		}
		System.out.println("Sueldo del trabajador: "+nsueldo);
	}
	//
	public void Program192(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Cantidad de sonidos del grillo: ");
		int sonido = sc.nextInt();
		float temperatura = (float)((sonido / 4) + 40);
		System.out.println("Temperatura: "+temperatura);
	}
	//
	public void Program193(){
		Scanner sc = new Scanner(System.in);
		System.out.print("A: ");
		int a = sc.nextInt();
		System.out.print("B: ");
		int b = sc.nextInt();
		int c = a + b;
		int d = ( c * c ) / 3;
		System.out.println("Resultado: "+d);
	}
	//
	public void Program194(){
		Scanner sc = new Scanner(System.in);
		System.out.print("P: ");
		int p = sc.nextInt();
		System.out.print("Q: ");
		int q = sc.nextInt();
		int pCuadrado = p * p;
		int pCubo = p * p * p;
		int qCuarta = q * q * q * q;
		int ecuacion = (pCubo + qCuarta) - (2 * pCuadrado);
		if (ecuacion < 480) {
			System.out.println("La expresion satisface la ecuacion");
		}else{
			System.out.println("La expresion no satisface la ecuacion");
		}
	}
	//
	public void Program195(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ecuacion: Ax^2+Bx+C");
		System.out.print("A:");
		int a = sc.nextInt();
		System.out.print("B:");
		int b = sc.nextInt();
		System.out.print("C:");
		int c = sc.nextInt();
		float x1 = 0, x2 = 0; 
		int bCuadrado = b * b;
		float raiz = (float)(Math.sqrt(bCuadrado - (4 * a * c)));
		if (raiz > 0) {
			x1 = -b + raiz;
			x2 = -b - raiz;
			System.out.println("x1: "+x1);
			System.out.println("x2: "+x2);
		}else{
			System.out.println("No se pudo calcular la ecuacion de segundo grado");
		}
	}
	//
	public void Program196(){
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
		if (promedio >= 6) {
			System.out.println("Estudiante Aprobado");
		}else{
			System.out.println("Estudiante Reprobado");
		}
	}
	//
	public void Program197(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Numero: ");
		int n = sc.nextInt();
		if (n < 0 ) {
			System.out.println("El numero es negativo");
		}else if(n > 0){
			System.out.println("El numero es positivo");
		}else{
			System.out.println("El numero es nulo");
		}
	}
	//
	public void Program198(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Numero: ");
		int n = sc.nextInt();
		if (n == 0) {
			System.out.println("Numero nulo");
		}else if (n % 2 == 0) {
			System.out.println("Numero par");
		}else{
			System.out.println("Numero impar");
		}
	}
	//
	public void Program199(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Sueldo 1: ");
		int s1 = sc.nextInt();
		System.out.print("Sueldo 2: ");
		int s2 = sc.nextInt();
		System.out.print("Sueldo 3: ");
		int s3 = sc.nextInt();
		System.out.print("Sueldo 4: ");
		int s4 = sc.nextInt();
		System.out.print("Sueldo 5: ");
		int s5 = sc.nextInt();
		System.out.print("Sueldo 6: ");
		int s6 = sc.nextInt();
		System.out.print("Sueldo 7: ");
		int s7 = sc.nextInt();
		System.out.print("Sueldo 8: ");
		int s8 = sc.nextInt();
		System.out.print("Sueldo 9: ");
		int s9 = sc.nextInt();
		System.out.print("Sueldo 10: ");
		int s10 = sc.nextInt();
		int total = s1+s2+s3+s4+s5+s6+s7+s8+s9+s10;
		System.out.println("Total de la nomina: "+total);
	}
	//
	public void Program200(){
		Scanner sc = new Scanner(System.in);
		int[] arreglo = new int[10];
		int total = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("Sueldo "+(i+11)+": ");
			arreglo[i] = sc.nextInt();
			total += arreglo[i];
		}
		System.out.println("Total de la nomina: "+total);
	}
}
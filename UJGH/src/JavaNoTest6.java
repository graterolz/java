import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class JavaNoTest6 {
	//
	public void Program101() {
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese valor de a: ");
		a = sc.nextInt();
		System.out.print("Ingrese valor de b: ");
		b = sc.nextInt();
		double c = (a+b)^2/3;
		System.out.println("El resultado es: "+c);
	}
	//
	public void Program102() throws IOException {
		int P,Q;
		double X;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese valor de P: ");
		P = Integer.parseInt(br.readLine());
		System.out.print("Ingrese valor de Q: ");
		Q = Integer.parseInt(br.readLine());
		X = Math.pow(P,3)+Math.pow(Q,4)-2*Math.pow(P,2);
		if (X<680)
			System.out.println("P y Q satisfacen la ecuación");
		else
			System.out.println("P y Q no satisfacen la ecuación");
	}
	//
	public void Program103() {
		Scanner r = new Scanner(System.in);
		double a,b,c;
		System.out.print("Ingrese valor de a: ");
		a = r.nextDouble();
		System.out.print("Ingrese valor de b: ");
		b = r.nextDouble();
		System.out.print("Ingrese valor de c: ");
		c = r.nextDouble();
		double d = Math.sqrt(Math.pow(b,2)-4*a*c);
		if(d<=0)
			System.out.println("Raices Imaginarias");
		else {
			double x1 = (-b+d)/(2*a);
			double x2 = (-b-d)/(2*a);
			System.out.println("x1 = "+x1);
			System.out.println("x2 = "+x2);
		}
	}
	//
	public void Program104() {
		Scanner r = new Scanner(System.in);
		int A;
		System.out.print("Ingrese un numero: ");
		A = r.nextInt();
		if(A==0)
			System.out.println(A+" es un numero nulo");
		else if (A>0)
			System.out.println(A+" es un numero positivo");
		else
			System.out.println(A+" es un numero negativo");
	}
	//
	public void Program105() {
		int a;
		Scanner r = new Scanner(System.in);
		System.out.print("Ingrese un numero: ");
		a = r.nextInt();
		if(a==0)
			System.out.println(a+" es un numero nulo.");
		else if(a%2==0)
			System.out.println(a+" es un numero par.");
		else
			System.out.println(a+" es un numero impar.");
	}
	//
	public void Program106() {
		Scanner d = new Scanner(System.in);
		System.out.print("Ingrese capital: ");
		double cap = d.nextDouble();
		System.out.print("Ingrese interes: ");
		double tasa = d.nextDouble();
		double m_int = 0;
		int meses=0;
		do {
			m_int+= cap*(tasa/100/12);
			meses++;
		} while (m_int <= (cap*2));
		System.out.println("Anios: "+(meses/12)+" años");
		System.out.println("Intereses: "+m_int);
	}
	//
	public void Program107() throws IOException {
		int nota; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese nota de Alumno: ");
		nota = Integer.parseInt(br.readLine());
		if (nota>8)
			System.out.println("Aprobado");
	}
	//
	public void Program108() throws IOException {
		double sueldo,nsueldo; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese Sueldo de Trabajador: ");
		sueldo = Double.parseDouble(br.readLine());
		if (sueldo<1000) {
			nsueldo=sueldo+sueldo*0.15;
			System.out.println("El sueldo es: "+nsueldo);
		}
	}
	//
	public void Program109() throws IOException {
		int nota;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese nota de Alumno: ");
		nota = Integer.parseInt(br.readLine());
		if (nota>8)
			System.out.println("Aprobado");
		else
			System.out.println("Reprobado");
	}
	//
	public void Program110() throws IOException {
		double sueldo,nsueldo;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese Sueldo de Trabajador: ");
		sueldo = Double.parseDouble(br.readLine());
		if (sueldo<1000)
			nsueldo=sueldo+sueldo*0.15;
		else
			nsueldo=sueldo+sueldo*0.12;
		System.out.println("El sueldo es: "+nsueldo);
	}
	//
	public void Program111() throws IOException {
		double sueldo,nsueldo; 
		int cat;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese Sueldo de Trabajador: ");
		sueldo = Double.parseDouble(br.readLine());
		System.out.print("Categoria de Trabajador: ");
		cat = Integer.parseInt(br.readLine());
		switch(cat) {
			case 1: nsueldo=sueldo+sueldo*0.15; break;
			case 2: nsueldo=sueldo+sueldo*0.10; break;
			case 3: nsueldo=sueldo+sueldo*0.08; break;
			case 4: nsueldo=sueldo+sueldo*0.07; break;
			default: System.out.println("No ingreso categoria correcta..."); 
			nsueldo=sueldo;
		}
		System.out.println("El sueldo es: "+nsueldo);
	}
	//
	public void Program112() throws IOException {
		int N; 
		double t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese Numero de sonidos emitidos por el grillo: ");
		N = Integer.parseInt(br.readLine());
		t = N/4+40;
		System.out.println("La Temperatura es: "+t+" °F"); 
	}
	//
	public void Program113() {
		int cant;
		double precio;
		Scanner d=new Scanner(System.in);
		System.out.print("Ingrese el precio de producto: ");
		precio=d.nextDouble();
		System.out.print("Ingrese la cantidad: ");
		cant=d.nextInt();
		double preciot=(precio*cant)+(precio*cant)*0.12;
		if (preciot>100) {
			double ofer=preciot-(preciot*0.07);
			System.out.println("El descuento es: "+ofer);
		}
		else
			System.out.println("El Precio total es: "+preciot);
	}
	//
	public void Program114() throws IOException {
		int i,N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese Valor de N: ");
		N = Integer.parseInt(br.readLine());
		if (N<=4)
			System.out.println("Error: N<=4 !!!");
		else {
			for(i=4;i<=N;i++) {
				if(i%4==0)
					System.out.println(i+" es multiplo de 4");
			}
		}
	}
	//
	public void Program115() throws IOException {
		int i,N;
		double sueldo,retencion,tot_sue=0,tot_ret=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese Cantidad de Empleados: ");
		N = Integer.parseInt(br.readLine());
		for(i=1;i<=N;i++) {
			System.out.print("Sueldo de Empleado No. "+i);
			sueldo = Double.parseDouble(br.readLine());
			tot_sue+=sueldo; 
			if(sueldo<=1500)
				retencion=0;
			else if ((sueldo>1500)&&(sueldo<=3000))
				retencion=sueldo*5.25/100;
			else
				retencion=sueldo*7.45/100;
			tot_ret+=retencion;
		}
		System.out.println("Total Sueldo = "+tot_sue);
		System.out.println("Total Retencion = "+tot_ret);
	}
	//
	public void Program116() {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese valor de num: ");
		num = sc.nextInt();
		int Cuadrado = num*num; 
		int Cubo = num*num*num;
		System.out.println("Cuadrado: "+Cuadrado);
		System.out.println("Cubo: "+Cubo);
	}
	//
	public void Program117(){
		Scanner r = new Scanner(System.in);
		int a,b,y=0;
		double res;
		System.out.print("Ingrese valor de n: ");
		int n = r.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.print("Ingrese valor de A: ");
			a = r.nextInt();
			System.out.print("Ingrese valor de B: ");
			b = r.nextInt();
			res = Math.pow(a,2)-Math.pow(b,2);
			if(res>0)
				y+=(a+b);
			else if (res==0)
				y+=(a-2*b);
			else 
				y+=(a+b-5);
		}
		System.out.println("El valor de y es igual a: "+y);
	}
	//
	public void Program118() {
		Scanner d = new Scanner(System.in);
		int suma_p=0,suma_i=0,cont_p=0,cont_i=0;
		for(int i=1;i<=10;i++) {
			System.out.print("Ingrese el valor No. "+i+": ");
			int n=d.nextInt();
			if(n%2==0) {
				suma_p+=n;
				cont_p++;
			}
			else {
				suma_i+=n;
				cont_i++;
			}
		}
		System.out.println("Suma de Numeros Pares: "+suma_p);
		System.out.println("Total de Numeros Pares: "+cont_p);
		double prom_i = suma_i/cont_i;
		System.out.println("Meda Aritmetica Numeros Impares: "+prom_i);
	}
	//
	public void Program119() {
		Scanner d=new Scanner (System.in);
		System.out.print("Ingrese Valor No. 1: ");
		int a=d.nextInt();
		System.out.print("Ingrese Valor No. 2: ");
		int b=d.nextInt();
		System.out.print("Ingrese Valor No. 3: ");
		int c=d.nextInt();
		if ((a>b&&a<c)||(a>c&&a<b))
			System.out.println("El central es:" +a);
		else if ((b>a&&b<c)||(b>c&&b<a))
			System.out.println("El central es:" +b);
		else
			System.out.println("El central es:" +c);
	}
	//
	public void Program120() {
		Scanner d = new Scanner(System.in);
		int sueldo,total=0,n;
		for(n=1;n<=10;n++) {
			System.out.print("Ingrese sueldo de Trabajador No. "+n+": ");
			sueldo=d.nextInt();
			total+=sueldo;
		}
		System.out.println("Total Nomina: "+total);
	}
}
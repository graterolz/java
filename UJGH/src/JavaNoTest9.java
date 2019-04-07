import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class JavaNoTest9 {
	//
	public void Program161() {
		double a=3.0,b=4.0;
		double c = Math.sqrt(a*a+b*b);
		System.out.print("La Hipotenusa es: ");
		System.out.println(c);
	}
	//
	public void Program162() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,i,j,aux;
		System.out.print("Ingrese la cantidad de numeros: ");
		n = Integer.parseInt(br.readLine());
		int x[] = new int [n];
		for(i=0;i<n;i++) {
			System.out.print("Introduce valor de elemento No. ["+(i+1)+"]: ");
			x[i] = Integer.parseInt(br.readLine());
		}
		for(i=0;i<n;i++) {
			for(j=0;j<n-1;j++) {
				if(x[j]>x[j+1]) {
					aux=x[j];
					x[j]=x[j+1];
					x[j+1]=aux;
				}
			}
		}
		System.out.println("El mayor elemento es: "+x[n-1]);
	}
	//
	public void Program163() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,i,j,aux,imin;
		System.out.print("Ingrese la cantidad de numeros: ");
		n = Integer.parseInt(br.readLine());
		int x[] = new int [n];
		for(i=0;i<n;i++) {
			System.out.print("Introduce valor de elemento No. ["+(i+1)+"]: ");
			x[i] = Integer.parseInt(br.readLine());
		}
		i=0;
		for(i=0;i<n;i++) {
			imin= i;
			j=i+1;
			for(j=0;j<n;j++) {
				if(x[i]<x[imin]) {
					imin=j;
					j+=1;
					aux=x[j];
					x[j]=x[imin];
					x[imin]=aux;
				}
			}
		}
		for(i=0;i<n;i++)
			System.out.println("Elemento No. ["+(i+1)+"]: "+x[i]);
	}
	//
	public void Program164() {
		int x,y,z;
		Scanner reader = new Scanner(System.in);
		System.out.print("Valor de x: ");
		x = reader.nextInt();
		System.out.print("Valor de y: ");
		y = reader.nextInt();
		z=x;
		x=y;
		y=z;
		System.out.println("Valor de x: "+x);
		System.out.println("Valor de y: "+y);
	}
	//
	public void Program165() {
		Scanner reader = new Scanner(System.in);
		int n,i,j,aux;
		System.out.print("Ingrese la cantidad de numeros: ");
		n = reader.nextInt();
		int x[] = new int [n];
		for(i=0;i<n;i++) {
			System.out.print("Introduce valor de elemento No. ["+(i+1)+"]: ");
			x[i] = reader.nextInt();
		}
		for(i=0;i<n;i++) {
			for(j=0;j<n-1;j++) {
				if(x[j]>x[j+1]) {
					aux=x[j];
					x[j]=x[j+1];
					x[j+1]=aux;
				}
			}
		}
		for(i=0;i<n;i++)
			System.out.println("Elemento No. ["+(i+1)+"]: "+x[i]);
	}
	//
	public void Program166() {
		Scanner reader = new Scanner(System.in);
		int n,i,spar=0,simp=0,c_imp=0;
		System.out.print("Ingrese cantidad de Numeros: ");
		n = reader.nextInt();
		int a[] = new int[n];
		for(i=0;i<=n-1;i++) {
			System.out.print("Introduce valor de elemento No. "+(i+1)+": ");
			a[i] = reader.nextInt();
			if(a[i]%2==0)
				spar+=a[i];
			else {
				simp+=a[i];
				c_imp++;
			}
		}
		System.out.println("La sumatoria de los pares es igual a: "+spar);
		System.out.println("La sumatoria de los impares es igual a: "+simp);
		System.out.println("El promedio de los impares es igual a: "+(simp/c_imp));
	}
	//
	public void Program167() {
		Scanner r = new Scanner(System.in);
		int N;
		System.out.print("Ingrese valor de N: ");
		N = r.nextInt();
		int a[] = new int[N];
		int b[] = new int[N];
		int c[] = new int[N];
		for(int i=0;i<N;i++) {
			System.out.print("Elemento No. "+(i+1)+" de Arreglo a: ");
			a[i] = r.nextInt();
			System.out.print("Elemento No. "+(i+1)+" de Arreglo b: ");
			b[i] = r.nextInt();
		}
		int suma=0;
		for(int j=0;j<N;j++) {
			c[j] = a[j]*b[j];
			System.out.println("Elemento No. "+(j+1)+" de Arreglo c: "+c[j]);
			suma+=c[j];
		}
		System.out.println("La sumatoria es: "+suma);
	}
	//
	public void Program168() throws IOException {
		Scanner reader = new Scanner(System.in);
		int a[] = new int[10];
		int m,i,suma=0;
		for(i=0;i<=9;i++) {
			System.out.print("Introduce valor de elemento No. "+(i+1)+": ");
			a[i] = reader.nextInt();
			suma+=a[i];
		}
		System.out.println("La sumatoria es igual a: "+suma);
	}
	//
	public void Program169() throws IOException {
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca un numero entero y positivo: ");
		int a = Integer.parseInt(in.readLine());
		if (a%2==0)
			System.out.println("El numero es par");
		else
			System.out.println("El numero es impar");
	}
	//
	public void Program170() throws IOException {
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(System.in));
		double m = 1, aux = 0, n = 0, o = 0;
		System.out.println("La edad 0 indica el final del ingreso de edades: ");
		while (m!=0) {
			System.out.print("Ingrese una edad: ");
			m = Integer.parseInt(in.readLine());
			n++;
			aux = aux + m;
			if (m>50)
				o++;
		}
		double s = (o*100) / (n-1);
		double aux2 = aux / (n-1);
		System.out.println("El promedio es: "+aux2);
		System.out.println("El porcentaje de personas mayoes a los 50 años es de: "+2);
	}
	//
	public void Program171() {
		int a=3,b=4;
		double c=Math.pow(a+b,2)/3;
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		System.out.println("c= "+c);
	}
	//
	public void Program172(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Nota: ");
		int nota = sc.nextInt();
		if (nota > 8) {
			System.out.println("Aprobado");
		}
	}
	//
	public void Program173() {
		int a=1,b=2,c=3,d=4;
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		System.out.println("c= "+c);
		System.out.println("d= "+d);
		System.out.println("Orden Inverso");
		System.out.println("d= "+d);
		System.out.println("c= "+c);
		System.out.println("b= "+b);
		System.out.println("a= "+a);
	}
	//
	public void Program174() {
		double vinicial=16/2,rtiempo=2-2*0.35,vfinal=16/rtiempo;
		double tfinal=2-rtiempo;
		System.out.println("Velocidad inicial: "+vinicial);
		System.out.println("Velocidad final: "+vfinal);
		System.out.println("Reducción de Tiempo alcanzada: "+tfinal);
	}
	//
	public void Program175() throws IOException {
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese cantidad de numeros a leer: ");
		int n = Integer.parseInt(in.readLine());
		int pos=0,neg=0;
		for(int i=1;i<=n;i++) {
			System.out.print("Ingrese valor No. "+i+": ");
			int num = Integer.parseInt(in.readLine());
			if (num>=0)
				pos++;
			else
				neg++;
		}
		System.out.println("Total de numeros positivos: "+pos);
		System.out.println("Total de numeros negativos: "+neg);
	}
	//
	public void Program176() throws IOException {
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Introduzca valor de x: ");
		int x = Integer.parseInt(in.readLine());
		System.out.print("Introduzca valor de y: ");
		int y = Integer.parseInt(in.readLine());
		int aux;
		aux = x;
		x = y;
		y = aux;
		System.out.println("Ahora x vale "+x);
		System.out.println("Ahora y vale "+y);
	}
	//
	public void Program177() throws IOException {
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese valor de hora: ");
		int h = Integer.parseInt(in.readLine());
		System.out.print("Ingrese valor de minutos: ");
		int m = Integer.parseInt(in.readLine());
		System.out.print("Ingrese valor de segundos: ");
		int s = Integer.parseInt(in.readLine());
		int seg = h * 3600 + m * 60 + s;
		System.out.println("Total de segundos: "+seg);
	}
	//
	public void Program178() throws IOException {
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese valor de n: ");
		int n = Integer.parseInt(in.readLine());
		System.out.print("Ingrese valor de m: ");
		int m = Integer.parseInt(in.readLine());
		if(n%m==0)
			System.out.println(n+" es multiplo de "+m);
		else
			System.out.println(n+" no es multiplo de "+m);
	}
	//
	public void Program179() throws IOException {
		int num;
		double cua,cubo;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Ingrese un numero: ");
		num = Integer.parseInt(br.readLine());
		cua = Math.pow(num,2);
		cubo = Math.pow(num,3);
		System.out.println("Cuadrado de "+num +" es: "+cua);
		System.out.println("Cubo de "+num +" es: "+cubo);
	}
	//
	public void Program180() throws IOException {
		int b,h;
		double s,p;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Valor de base: ");
		b = Integer.parseInt(br.readLine());
		System.out.print("Valor de altura: ");
		h = Integer.parseInt(br.readLine());
		s=b*h;
		p=2*(b+h);
		System.out.println("Superficie = "+s);
		System.out.println("Perimetro = "+p);
	}
}
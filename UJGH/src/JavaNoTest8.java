import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class JavaNoTest8 {
	//
	public void Program141() {
		Scanner r = new Scanner(System.in);
		int fact=1;
		System.out.print("Ingrese valor de n: ");
		int n=r.nextInt();
		for(int i=1;i<=n;i++)
			fact= fact*i;
		System.out.println("El factorial de "+n+" es igual a: "+fact);  
	}
	//
	public void Program142() {
		Scanner d = new Scanner(System.in);
		System.out.print("Ingrese el numero para realizar la operacion: ");
		int num = d.nextInt();
		for (int i=0; i<num; i++) 
			System.out.print("*");
		System.out.println("");
		for (int i = 0; i < num-2; i++) {
			System.out.print("*");
			for (int j = 0; j < num-2; j++)
				System.out.print(" ");
			System.out.println("*");
		}
		for (int i = 0; i < num; i++) 
			System.out.print("*");
	}
	//
	public void Program143() {
		Scanner d = new Scanner(System.in);  
		System.out.print("Ingrese el numero de la serie: ");
		int ciclos = d.nextInt(); 
		System.out.println("");
		int valor1 = 0;
		int valor2 = 1;
		int valor3;
		for(int k=1;k<=ciclos; k++) {
			valor3 = valor1 + valor2;
			System.out.println(valor1+" + "+valor2+" = "+valor3);
			valor1 = valor2;
			valor2 = valor3;
		}
	}
	//
	public void Program144() {
		Scanner r = new Scanner(System.in);
		int N,nota;
		double suma=0,prom;
		System.out.print("Ingrese cantidad de alumnos: ");
		N = r.nextInt();
		for(int i=1;i<=N;i++) {
			System.out.print("Ingrese Nota de Alumno No. "+i+": ");
			nota = r.nextInt();
			suma = suma + nota;
		}
		prom = suma / N;
		System.out.println("El promedio es: "+prom);
	}
	//
	public void Program145() {
		Scanner d = new Scanner(System.in);
		System.out.print("Ingrese La Hipotenusa: ");
		float hipotenusa = d.nextFloat();
		System.out.println("");
		System.out.print("Ingrese el Valor del lado: ");
		float lado = d.nextFloat();
		System.out.println("");
		double faltante = Math.sqrt(Math.pow(hipotenusa, 2)-Math.pow(lado, 2));
		System.out.println("El lado faltante es de: "+faltante);
	}
	//
	public void Program146() {
		Scanner d = new Scanner(System.in);
		double costo;
		System.out.print("Ingrese duracion de la llamada: ");
		int minutos = d.nextInt();
		if(minutos<=3)
			costo = 100;
		else
			if((minutos>3)&&(minutos<10))
				costo = 100 + (minutos-3)*50;
			else
				costo = (100 + (minutos-3)*50)*0.80;
			System.out.println("Costo = "+costo);  
	}
	//
	public void Program147() {
		Scanner r = new Scanner(System.in);
		double ht,vh,sueldo;
		System.out.print("Ingrese cantidad de horas trabajadas: ");
		ht = r.nextDouble();
		System.out.print("Ingrese valor de la hora: ");
		vh = r.nextDouble();
		sueldo = ht*vh;
		System.out.println("Sueldo Diario: "+sueldo);
	}
	//
	public void Program148() {
		Scanner r = new Scanner(System.in);
		int num;
		boolean flag= false;
		while(flag=false) {
			System.out.print("Ingrese un numero: ");
			num = r.nextInt();
			if(num==0)
				System.out.println("Error: debe ingresar un numeor distinto de cero !!!");
			if(num==-99) {
				flag=true;
				break;
			}
		}
	}
	//
	public void Program149() {
		Scanner r = new Scanner(System.in);
		String psuave;
		int n,npag;
		double precio,total=0;
		System.out.print("Ingrese cantidad de libros: ");
		n = r.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.print("Libro de portada suave: ");
			psuave = r.next();
			System.out.print("Cantidad de paginas: ");
			npag = r.nextInt();
			if(psuave=="S")
				precio=5.50;
			else
				precio=10.70;
			if(npag>=500)
				precio=precio-precio*0.25;
			else
				precio=precio+npag*0.125;
			total+=precio;  
		}
		System.out.println("Total importe libros: "+total);
	}
	//
	public void Program150() {
		double npro,pvp,ptot;
		Scanner r = new Scanner (System.in);
		System.out.print("Cantidad de productos: ");
		npro= r.nextDouble();
		System.out.print("Precio de Venta: ");
		pvp= r.nextDouble();
		ptot=(pvp*npro)+(pvp*npro*0.12);
		if (ptot>100)
			ptot= ptot-ptot*0.07;
		System.out.println("Precio Total: " +ptot);
	}
	//
	public void Program151() {
		Scanner r = new Scanner(System.in);
		int n;
		System.out.print("Ingrese el valor de n: ");
		n = r.nextInt();
		for(int i=4;i<=n;i++) {
			if(i%4==0) 
				System.out.println("El numero "+i+" es multiplo de 4");
		}
	}
	//
	public void Program152() {
		int n,i;
		double s,ret,sn,st=0,tr=0;
		Scanner r = new Scanner (System.in);
		System.out.print("Ingrese cantidad de trabajadores: ");
		n = r.nextInt();
		for(i=1;i<=n;i++) {
			System.out.print("Ingrese el Salario No. "+i+": ");
			s = r.nextDouble();
			if(s<=1500)
				ret=0;
			else if ((s>1500)&&(s<3000))
				ret=s*0.0525;
			else
				ret=s*0.0745;
			sn=s-ret;
			tr+=ret;
			st+=sn;
		}
		System.out.println("Total Retenciones: "+tr);
		System.out.println("Salario Total: "+st);
	}
	//
	public void Program153() {
		int n,sp=0,si=0,np=0,ni=0;
		Scanner r = new Scanner(System.in);
		for(int i=1;i<=10;i++) {
			System.out.print("Ingrese el valor No. "+i+": ");
			n = r.nextInt();
			if(n%2==0) {
				sp+=n;
				np++;
			}
			else {
				si+=n;
				ni++;
			}
		}
		System.out.println("Cantidad de numeros pares: "+np);
		System.out.println("Suma de numeros pares: "+sp);
		System.out.println("Promedio de numeros impares: "+(si/ni));
	}
	//
	public void Program154() {
		Scanner r = new Scanner(System.in);
		int n,m,nota,suma=0,tot=0;
		System.out.print("Ingrese cantidad de estudiantes: ");
		n = r.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.print("Ingrese cantidad de notas de Estudiante No. "+i+": ");
			m = r.nextInt();
			suma=0;
			for(int j=1;j<=m;j++) {
				System.out.print("Ingrese Nota No. "+j+": ");
				nota = r.nextInt();
				suma+=nota;
			}
			tot+=(suma/m);
			System.out.println("Promedio de Estudiante No. "+i+": "+(suma/m));
		}
		System.out.println("Promedio general: "+(tot/n));
	}
	//
	public void Program155() {
		Scanner r = new Scanner(System.in);
		int dias;
		double d,p;
		System.out.print("Ingrese distancia a recorrer: ");
		d = r.nextDouble();
		System.out.print("Ingrese cantidad de dias: ");
		dias = r.nextInt();
		p=d*0.75;
		if((d>800)&&(dias>7))
			p=p-p*0.30;
		System.out.println("Costo del pasaje: "+p);  
	}
	//
	public void Program156() {
		int nota,n,tapr=0,trep=0,sapr=0,srep=0,suma=0;
		Scanner r = new Scanner (System.in);
		System.out.print("Numero de Estudiantes: ");
		n=r.nextInt();
		for (int i=1;i<=n;i++) {
			System.out.print("Ingrese nota de Estudiante No. "+i+": ");
			nota= r.nextInt();
			if(nota<10) {
				trep++;
				srep+=nota;
			}
			else {
				tapr++;
				sapr+=nota;
			}
			suma+=nota; 
		}
		System.out.println("El promedio es: " +(suma/n));
		System.out.println("Estudiantes reprobados: " +trep);
		System.out.println("Promedio reprobados: " +(srep/trep));
		System.out.println("Estudiantes aprobados: " +tapr);
		System.out.println("Promedio reprobados: " +(sapr/tapr));
	}
	//
	public void Program157() {
		Scanner r = new Scanner(System.in);
		double c=5000,i=0.06;
		int a=0;
		System.out.println("Capital invertido: "+c);
		while (c<1000000) {
			c=c+c*i;
			a++;
			System.out.println("Monto al año No. "+a+": "+c);
		}
		System.out.println("Total obtenido: "+c);
		System.out.println("Cantidad de años: "+a);
	}
	//
	public void Program158() {
		double pi,r,a;
		r = 10.8;
		pi = 3.1416;
		a = pi * r * r;
		System.out.println("El área del círculo es "+a);
	}
	//
	public void Program159() {
		double pi=3.1416,r=10.8,a;
		a = pi *Math.pow( r,2);
		System.out.println("El área del círculo es "+a);
	}
	//
	public void Program160() {
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
		System.out.println("10>9"+(10>9));
	}
}
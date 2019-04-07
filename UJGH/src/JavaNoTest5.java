import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class JavaNoTest5 {
	//
	public void Program81() {
		int velocidadluz;
		long dias,segundos,distancia;
		velocidadluz = 18600;
		dias = 1000;
		segundos = 1000 * 24 * 60 * 60;
		distancia = velocidadluz * segundos;
		System.out.println("En "+dias);
		System.out.print("dias la luz recorrerá aprox ");
		System.out.println(distancia+" millas");
	}
	//
	public void Program82() throws IOException {
		int cod,i,n,n_hijos;
		float sb,ret,s_ret=0;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Ingrese Cantidad de Trabajadores: ");
		n = Integer.parseInt(br.readLine());
		for(i=1;i<=n;i++) {
			System.out.print("Ingrese Código de Trabajador No. "+i+": ");
			cod = Integer.parseInt(br.readLine());
			System.out.print("Ingrese Salario Base de Trabajador No. "+i+": ");
			sb = Float.parseFloat(br.readLine());
			System.out.print("Ingrese No. de Hijos de Trabajador No. "+i+": ");
			n_hijos = Integer.parseInt(br.readLine());
			if(n_hijos<2){
				ret = sb/5;
			}
			else{
				ret = sb/5 - 40 * (n_hijos-2);
			}
			s_ret+=ret;
			System.out.println("Retencion de Trabajador No. "+i+": "+ret);
		}
		System.out.println("Retencion Mensual Acumulada: "+s_ret);
	}
	//
	public void Program83() throws IOException {
		double c,f;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Temperatura en Centigrados: ");
		c = Integer.parseInt(br.readLine());
		f=32+1.8*c;
		System.out.println("Temperatura en Fahrenheit: "+f);
	}
	//
	public void Program84() {
		int i,suma=0,cuenta=0;
		for(i=1;i<=300;i++) {
			if(i%2==0) {
				suma+=i;
				cuenta+=1;
			}
		}
		System.out.println("Suma = "+suma);
		System.out.println("Cuenta = "+cuenta);
	}
	//
	public void Program85() {
		int i,suma=0,cuenta=0;
		for(i=1;i<=300;i++) {
			if(i%2==0) {
				suma+=i;
				cuenta+=1;
			}
		}
		System.out.println("Suma = "+suma);
		System.out.println("Cuenta = "+cuenta);
	}
	//
	public void Program86() {
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
	public void Program87() {
		double a=3.0,b=4.0;
		double c = Math.sqrt(a*a+b*b);
		System.out.print("La Hipotenusa es: ");
		System.out.println(c);
	}
	//
	public void Program88() {
		double pi,r,a;
		r = 10.8;
		pi = 3.1416;
		a = pi *Math.pow(r,2);
		System.out.println("El área del círculo es "+a);
	}
	//
	public void Program89() {
		int x;
		for(x=0;x<3;x++) {
			int y=-1;
			System.out.println("y es: "+y);
			y=100;
			System.out.println("y es ahora: "+y); 
		}
	}
	//
	public void Program90() {
		int x=2,y=2,z;
		z=x*y+10+4/2-2*4+2;
		System.out.print("El resultado es: ");
		System.out.println(z);
	}
	//
	public void Program91() {
		boolean w,x=true,y=true,z=false;
		w=x && y || x && z || y && z;
		System.out.print("El resultado es: ");
		System.out.println(w);
	}
	//
	public void Program92() {
		int k;
		for(k=5;k>0;k--)
			System.out.print(k);
		System.out.print(k);
		int a=7,b=3;
		System.out.print((++a)*b);
	}
	//
	public void Program93() {
		final double pi = 3.141516;
		Scanner d = new Scanner(System.in);
		int r,a;
		double v,s;
		System.out.print("Ingrese valor de radio: ");
		r = d.nextInt();
		System.out.print("Ingrese valor de altura: ");
		a = d.nextInt();
		v = pi*Math.pow(r,2)*a;
		s = 2*pi*r*a;
		System.out.println("El volumen es: "+v);
		System.out.println("El area es: "+s);
	}
	//
	public void Program94() {
		Scanner r = new Scanner(System.in);
		int ntrab,nhijos;
		double sueldo,ret,sret=0;
		String codigo;
		System.out.print("Numero de trabajadores: ");
		ntrab = r.nextInt();
		for(int i=1;i<=ntrab;i++) {
			System.out.println("Trabajador No. "+i);
			System.out.print("Salario base: ");
			sueldo = r.nextDouble();
			System.out.print("Numero de hijos: ");
			nhijos = r.nextInt();
			System.out.print("Codigo del Trabajador: ");
			codigo = r.next();
			if(nhijos<=1)
				ret=sueldo/5;
			else
				ret=sueldo/5-40*(nhijos-2);
			sret+=ret;
			System.out.println("Codigo del Trabajador No. "+i+": "+codigo);
			System.out.println("Numero de hijos: "+nhijos);
			System.out.println("Retencion: "+ret);
			System.out.println("Sueldo mensual: "+(sueldo*30));
			System.out.println("Retencion mensual: "+(ret*30));
		}
		System.out.println("Retencion acumulada: "+sret);
	}
	//
	public void Program95() {
		Scanner r = new Scanner(System.in);
		int suma=0;
		for(int i=1;i<=100;i++) {
			if(i%2!=0)
				suma++;
		}
		System.out.println("Existen "+suma+" numeros impares");
	}
	//
	public void Program96() {
		Scanner r = new Scanner(System.in);
		double jornal=0;
		System.out.print("Cantidad de Horas Extras Diurnas: ");
		int hed = r.nextInt();
		System.out.print("Cantidad de Horas Extras Nocturnas: ");
		int hen = r.nextInt();
		System.out.print("Tipo de Jornada Lunes a Sabado (1) - Domingo (2): ");
		int dia = r.nextInt();
		if(dia==2)
			jornal = hed*(50+20)+hen*(80+30);
		else if(dia==1) 
			jornal = hed*50+hen*80;
		else
			System.out.println("Error: jornada erronea...");
		System.out.println("Jornal = "+jornal);
	}
	//
	public void Program97() {
		Scanner r = new Scanner(System.in);
		boolean flag=true;
		System.out.print("Ingrese un numero: ");
		int n = r.nextInt();
		for(int i=2;i<=n-1;i++) {
			if(n%i==0)
				flag = false;
		}
		if(flag)
			System.out.println("El numero "+n+" es primo");
		else
			System.out.println("El numero "+n+" no es primo");
	}
	//
	public void Program98() {
		Scanner d = new Scanner(System.in);
		int l1,l2,l3;
		double a,s;
		System.out.print("Ingrese valor de lado 1: ");
		l1 = d.nextInt();
		System.out.print("Ingrese valor de lado 2: ");
		l2 = d.nextInt();
		System.out.print("Ingrese valor de lado 3: ");
		l3 = d.nextInt();
		s = (l1+l2+l3)/2;
		a = Math.sqrt(s*(s-l1)*(s-l2)*(s-l3));;
		System.out.println("El area es: "+a);
	}
	//
	public void Program99() {
		Scanner r = new Scanner(System.in);
		int num;
		boolean flag=true; 
		System.out.print("Ingrese un numero: ");
		num = r.nextInt();
		for(int i=2;i<=num-1;i++) {
			if(num%i==0) {
				flag=false;
				break;
			}
		}
		if(flag==true)
			System.out.println("El numero "+num+ " es primo y no es compuesto");
		else
			System.out.println("El numero "+num+ " no es primo y es compuesto");
	}
	//
	public void Program100() {
		Scanner r = new Scanner(System.in);
		double costo;
		System.out.print("Duracion de la llamada: ");
		int minutos = r.nextInt();
		if((minutos>=1)&&(minutos<=3))
			costo=150;
		else if((minutos>3)&&(minutos<=5))
			costo=150+50;
		else
			costo=150+50+(minutos-5)*30;
		System.out.println("Costo de la llamada: "+costo);
	}
}
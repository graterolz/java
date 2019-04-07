import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
public class JavaNoTest3 {
	//
	public void Program41() throws IOException {
		int i,n,num,npos=0,nneg=0;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Cantidad de numeros a ingresar: ");
		n = Integer.parseInt(br.readLine());
		for(i=1;i<=n;i++) {
			System.out.print("Ingrese un numero: ");
			num = Integer.parseInt(br.readLine());
			if(num>0){
				npos++;
			}
			else{
				nneg++;
			}
		}
		System.out.println("Cantidad de numeros positivos: "+npos);
		System.out.println("Cantidad de numeros negativos: "+nneg);
	}
	//
	public void Program42() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese monto inicial: ");
		double mi = Double.parseDouble(br.readLine());
		mi+=(mi*0.0125);
		System.out.println("Mes No. 1: "+mi);
		for(int i=2;i<=12;i++) {
			mi+=250+(mi+250)*0.0125;
			System.out.println("Mes No. "+i+": "+mi);
		}
	}
	//
	public void Program43() throws IOException {
		int min,costo=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese duración de la llamada: ");
		min = Integer.parseInt(br.readLine());
		if (min<=3)
			costo+=300;
		else if ((min>3)&&(min<=10))
			costo+=(300+(min-3)*50);
		else
			costo+=(300+(min-3)*50)*0.8;
		System.out.println("El costo es: "+costo);
	}
	//
	public void Program44() throws IOException {
		BufferedReader in;
		in=new BufferedReader(new InputStreamReader(System.in));
		double m=1,aux=0,n=0,o=0;
		System.out.println("La edad 0 indica el final de ingreso de edades");
		while(m!=0) {
			System.out.print("Ingrese una edad: ");
			m=Integer.parseInt(in.readLine());
			n++;
			aux=aux+m;
			if(m>50) {
				o++;
			}
		}
	}	
	//
	public void Program45() {
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
	public void Program46() throws IOException {
		int x,y,z;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Valor de x: ");
		x = Integer.parseInt(br.readLine());
		System.out.print("Valor de y: ");
		y = Integer.parseInt(br.readLine());
		z=x;
		x=y;
		y=z;
		System.out.println("Valor de x: "+x);
		System.out.println("Valor de y: "+y);
	}
	//
	public void Program47() throws IOException {
		double x,n,p;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Ingrese valor de x: ");
		x = Integer.parseInt(br.readLine());
		System.out.println("Ingrese valor de n: ");
		n = Integer.parseInt(br.readLine());
		p = Math.pow(x,n);
		System.out.print("La potencia es: "+p);
	}
	//
	public void Program48() {
		Scanner reader = new Scanner(System.in);
		System.out.print("Ingrese Lado No. 1: ");
		int Lado1 = reader.nextInt();
		System.out.print("Ingrese Lado No. 2: ");
		int Lado2 = reader.nextInt();
		System.out.print("Ingrese Lado No. 3: ");
		int Lado3 = reader.nextInt();
		double S = (Lado1+Lado2+Lado3)/2;
		double A = Math.sqrt(S*(S-Lado1)*(S-Lado2)*(S-Lado3));
		System.out.println("El Area es: "+A);
	}
	//
	public void Program49() {
		int Mat1[][] = {
			{1,1,1},
			{1,1,1},
			{1,1,1} 
		};
		int Mat2[][] = {
			{1,1,1},
			{1,1,1},
			{1,1,1} 
		};
		int i,j;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++){
				System.out.print(Mat1[i][j]+Mat2[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	//
	public void Program50() {
		int i=100;
		int j,pares=0,impares=0;
		for(j=1;j<=i;j++) {
			if (j%2==0)
				pares++;
			else
				impares++;
		}
		System.out.println("Pares: "+pares);
		System.out.println("Impares: "+impares);
	}
	//
	public void Program51() {
		int i=7;
		int j;
		boolean primos=true;
		for(j=2;j<i;j++) {
			if (i%j==0) {
				primos=false;
				break;
			}
		}
		if (primos){
			System.out.println(i+" Es Primo");
		}
		else{
			System.out.println(i+" No Es Primo");
		}
	}
	//
	public void Program52() throws IOException {
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
	public void Program53() {
		int dias_del_mes[];
		dias_del_mes = new int[12];
		dias_del_mes[0] = 31;
		dias_del_mes[1] = 28;
		dias_del_mes[2] = 31;
		dias_del_mes[3] = 30;
		dias_del_mes[4] = 31;
		dias_del_mes[5] = 30;
		dias_del_mes[6] = 31;
		dias_del_mes[7] = 31;
		dias_del_mes[8] = 30;
		dias_del_mes[9] = 31;
		dias_del_mes[10] = 30;
		dias_del_mes[11] = 31;
		System.out.print("Abril tiene "); 
		System.out.println(+dias_del_mes[3]+" dias");
	}
	//
	public void Program54() {
		int numeros[]={31,28,31,30,31,30,31,31,30,31,30,31};
		int i,j,suma=0,minimo,maximo;
		double promedio;
		minimo = numeros[0];
		maximo = numeros[0];
		for(i=0;i<12;i++) {
			suma = suma + numeros[i];
			if (maximo<numeros[i]){
				maximo = numeros[i];
			}
			if (minimo>numeros[i]){
				minimo = numeros[i];
			}
		}
		promedio = suma / 12;
		System.out.println("Promedio = "+promedio); 
		System.out.println("Minimo = "+minimo);
		System.out.println("Maximo = "+maximo);
	}
	//
	public void Program55() throws IOException {
		int x,y;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Valor de x: ");
		x = Integer.parseInt(br.readLine());
		System.out.print("Valor de y: ");
		y = Integer.parseInt(br.readLine());
		if(x%y==0){
			System.out.println(x+" es multiplo de "+y);
		}
		else{
			System.out.println(x+" no es multiplo de "+y);
		}
	}
	//
	public void Program56() {
		Scanner reader = new Scanner(System.in);
		int m,n,i;
		long prod=1;
		System.out.print("Ingrese cantidad de Numeros: ");
		n = reader.nextInt();
		int a[] = new int[n];
		for(i=0;i<=n-1;i++) {
			System.out.print("Introduce valor de elemento No. "+(i+1)+": ");
			m = reader.nextInt();
			prod*=m;
		}
		System.out.println("El producto es igual a: "+prod);
	}
	//
	public void Program57() throws IOException {
		int x,y;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Valor de x: ");
		x = Integer.parseInt(br.readLine());
		System.out.print("Valor de y: ");
		y = Integer.parseInt(br.readLine());
		if(x%y==0){
			System.out.println(x+" es multiplo de "+y);
		}
		else{
			System.out.println(x+" no es multiplo de "+y);
		}
	}
	//
	public void Program58() throws IOException {
		int a;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("\nEvaluacion de numeros\n");
		System.out.print("Ingrese un numero y luego presione enter: ");
		a = Integer.parseInt(br.readLine());
		System.out.print("\nResultado de Evaluacion\n");
		if(a%2==0){
			System.out.print("\nEl numero es par\n");
		}
		else{
			System.out.print("\nEl numero es impar\n");
		}
	}
	//
	public void Program59() {
		int a=0,b=0,c=0;
		Random r = new Random();
		for(int i=0;i<10;i++) {
			try {
				b = r.nextInt();
				c = r.nextInt();
				a = 12345 / (b/c);
			}
			catch(ArithmeticException e) {
				System.out.println("i: "+i);
				System.out.println("Division por cero");
				a = 0;
			}
			System.out.println("a: "+a);
		}
	}
	//
	public void Program60() throws IOException {
		int i,num,par=0;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		for(i=0;i<=120;i++) {
			System.out.print("Ingrese valor de num: ");
			num = Integer.parseInt(br.readLine());
			if (num%2==0){
				par+=1;
			}
		}
		System.out.println("Existen "+par+" numeros pares...");
	}
}
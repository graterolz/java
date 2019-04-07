import java.io.*;
import java.util.*;
public class JavaNoTest {
	//
	public void Program1() {
		int valorPar=0;
		int valorImpar=0;
		for(int i=1;i<=200;i=i+1){
			if((i%2)==0){
				valorPar=valorPar+i;
			}
			else{
				valorImpar=valorImpar+i;
			}
		}
		System.out.println("Sumar par: " + valorPar);
		System.out.println("Sumar Impar: " + valorImpar);
	}
	//
	public void Program2() {
		int SumImpar=0;
		for(int i=1;i<=100;i++){
			if(i%2!=0){
				SumImpar=SumImpar+i;
			}
		}
		System.out.print("Promedio: " + (SumImpar/100));
	}
	//
	public void Program3() {
		Scanner teclado=new Scanner(System.in);
		int a,b,c,d;
		try {
			System.out.print("Ingrese valor de A: ");
			a=teclado.nextInt();
			System.out.print("Ingrese valor de B: ");
			b=teclado.nextInt();
			System.out.print("Ingrese valor de C: ");
			c=teclado.nextInt();
			System.out.print("Ingrese valor de D: ");
			d=teclado.nextInt();
			System.out.println("Valor de D: "+d);
			System.out.println("Valor de C: "+c);
			System.out.println("Valor de B: "+b);
			System.out.println("Valor de A: "+a);
		}
		catch (Exception e) {
			System.out.println("Error al ingresar los valores enteros");
		}
	}
	//
	public void Program4() {
		int n=1;
		if(n==0){
			System.out.println("El numero es cero");
		}
		else if(n>0){
			System.out.println("El numero es positivo");
		}
		else{
			System.out.println("El numero es negativo");
		}
	}
	//
	public void Program5() {
		int[] edad = new int[100];
		int NumImpar=0;
		Scanner Entrada = new Scanner(System.in);
		for(int i=0;i<5;i++){
			System.out.print("Ingrese numero "+ (i+1) + ": ");
			edad[i] = Entrada.nextInt();
			if(edad[i]%2!=0){
				NumImpar++;
			}
		}
		System.out.print("Cantidad numeros impares: " + NumImpar);
	}
	//
	public void Program6() {
		Scanner Entrada = new Scanner(System.in);
		int Num;
		int NumMayor=0;
		int SumaNum=0;
		while(true){
			System.out.print("Ingrese numero: ");
			Num = Entrada.nextInt();
			if(Num<0){
				break;
			}
			if(Num>NumMayor){
				NumMayor=Num;
			}
			SumaNum=SumaNum+Num;
		}
		System.out.println("Numero mayor: " + NumMayor);
		System.out.println("Suma total: " + SumaNum);
	}
	//
	public void Program7() {
		int valorImpar=0;
		int contadorImpar=0;
		for(int i=1;i<=100;i=i+1){
			if((i%2)!=0){
				contadorImpar=contadorImpar+1;
				valorImpar=valorImpar+i;
			}
		}
		System.out.println("Promedio: " + (valorImpar/contadorImpar));
	}
	//
	public void Program8() {
		int X1=6;
		int X2=2;
		int Y1=5;
		int Y2=1;
		double P1=Math.pow((X1-X2), 2);
		double P2=Math.pow((Y1-Y2), 2);
		double Distancia=Math.sqrt(P1+P2);
		System.out.println(Distancia);
	}
	//
	public void Program9() {
		Scanner teclado=new Scanner(System.in);
		int a,b;
		try {
			System.out.print("Ingrese valor de A: ");
			a=teclado.nextInt();
			System.out.print("Ingrese valor de B: ");
			b=teclado.nextInt();
			double dividendo=(a+b);
			int divisor=3;
			dividendo=Math.pow(dividendo,2);
			System.out.println("Resultado: "+ (dividendo/divisor));
		}
		catch (Exception e) {
			System.out.println("Error al ingresar los valores enteros");
		}
	}
	//
	public void Program10() {
		Scanner teclado=new Scanner(System.in);
		double c1,c2,c3,c4,c5;
		try {
			System.out.print("Ingrese calificacion 1: ");
			c1=teclado.nextDouble();
			System.out.print("Ingrese calificacion 2: ");
			c2=teclado.nextDouble();
			System.out.print("Ingrese calificacion 3: ");
			c3=teclado.nextDouble();
			System.out.print("Ingrese calificacion 4: ");
			c4=teclado.nextDouble();
			System.out.print("Ingrese calificacion 5: ");
			c5=teclado.nextDouble();
			double promedio=(c1+c2+c3+c4+c5)/5;
			System.out.print("Promedio: "+promedio);
		}
		catch (Exception e) {
			System.out.println("Error al ingresar los valores decimales");
		}
	}
	//
	public void Program11() {
		Scanner teclado=new Scanner(System.in);
		int num;
		try {
			System.out.print("Ingrese un numero: ");
			num=teclado.nextInt();
			double cuadrado,cubo;
			System.out.println("El cuadrado del numero es: "+Math.pow(num,2));
			System.out.println("El cubo del numero es: "+Math.pow(num,3));
		}
		catch (Exception e) {
			System.out.println("Error al ingresar los valores enteros");
		}
	}
	//
	public void Program12() {
		Scanner teclado=new Scanner(System.in);
		double litros,precioLitros,galon;
		try {
			System.out.print("Ingrese cantidad de litros: ");
			litros=teclado.nextDouble();
			galon=litros/3.785;
			precioLitros=litros*4.50;
		}
		catch (Exception e) {
			System.out.println("Error al ingresar los valores decimales");
		}
	}
	//
	public void Program13() {
		int valorPar=0;
		int valorImpar=0;
		for(int i=1;i<=200;i=i+1){
			if((i%2)==0){
				valorPar=valorPar+i;
			}
			else{
				valorImpar=valorImpar+i;
			}
		}
		System.out.println("Sumar par: " + valorPar);
		System.out.println("Sumar Impar: " + valorImpar);
	}
	//
	public void Program14() {
		for(int i=1;i<=10;i++){
			for(int j=1; j<=10; j++){
				System.out.println(i + " * " + j + " = " + i*j);
			}
		}
	}
	//
	public void Program15() throws IOException {
		BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
		int a;
		double c,t,z;
		System.out.println ("Ingrese el monto inicial");
		a=Integer.parseInt (br.readLine());
		c=(a+300);
		t=c*0.15;
		z=c+t;
		System.out.println ("El bruto de la cuesta es " +c );
		System.out.println ("La couata de interes anuales " +t );
		System.out.println ("El total al final del año es " +z );
	}
	//
	public void Program16() throws IOException {
		double c,f;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Temperatura en centigrados: ");
		c=Double.parseDouble(br.readLine());
		f=32+1.8*c;
		System.out.println("Temperatura en Fahrenheit: "+f);
	}
	//
	public void Program17() {
		InputStreamReader irs = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (irs);
		try{
			System.out.print("Ingrese Numero: ");
			int Num = Integer.parseInt(br.readLine());
			System.out.print("El Numero Ingresado Es: "+Num);
		}
		catch(Exception W){
			W.printStackTrace();
		}
	}
	//
	public void Program18() {
		Scanner Entrada=new Scanner(System.in);
		double Kilometro=0.75;
		int Dist=0;
		int Dias=0;
		double Total=0;
		System.out.print("Ingresa distancia: ");
		Dist = Entrada.nextInt();
		System.out.print("Dias de estancia: ");
		Dias = Entrada.nextInt();
		Total=Dist*Dias;
		if(Dias>7){
			if(Dist>800){
			 Total=Total-(Total*0.30);
			}
		}
	}
	//
	public void Program19() throws IOException {
		double x=0, a, b, y=0;
		int i,n;
		BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
		System.out.println ("ingrese valor de n: ");
		n= Integer.parseInt (br.readLine ());
		for (i=1;i<=n;i++) {
			System.out.println ("Ingrese el valor de A: ");
			a= Double.parseDouble (br.readLine());
			System.out.println ("Ingrese el valor de B: ");
			b= Double.parseDouble (br.readLine());
			y= Math.pow (a,2) + Math.pow (b,2);
			if (y>0){
				x=(a+b);
			}
			else if (y==0){
				x=(a-2)*b;
			}
			else{
				x=(a+b-5);
			}
		}
		System.out.println ("El total de la suma: " +y);
	}
	//
	public void Program20() throws IOException{
		int lado_a,lado_b,lado_c;
		double S,producto;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese lado A: ");
		lado_a = Integer.parseInt(br.readLine());
		System.out.print("Ingrese lado B: ");
		lado_b = Integer.parseInt(br.readLine());
		System.out.print("Ingrese lado C: ");
		lado_c = Integer.parseInt(br.readLine());
		S = (lado_a+lado_b+lado_c);
		S = S/2;
		producto = (S*(S-lado_a)*(S-lado_b)*(S-lado_c));
		producto = Math.sqrt(producto);
		System.out.println("El area es: "+producto);
	}	
}
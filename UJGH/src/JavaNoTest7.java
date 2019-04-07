import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class JavaNoTest7 {
	//
	public void Program121() throws IOException {
		int n,i,num,cant_ceros=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese cantidad de numeros a leer: ");
		n = Integer.parseInt(br.readLine());
		for(i=1;i<=n;i++) {
			System.out.print("Ingrese un numero: ");
			num = Integer.parseInt(br.readLine());
			if(num==0) 
				cant_ceros+=1;
		}
		System.out.print("Cantidad de ceros ingresados: "+cant_ceros);
	}
	//
	public void Program122() {
		Scanner r = new Scanner(System.in);
		String mat;
		int n1,n2,n3,n4,n5;
		double prom;
		System.out.print("Ingrese matricula: ");
		mat = r.next();
		System.out.print("Ingrese calificacion No. 1: ");
		n1 = r.nextInt();
		System.out.print("Ingrese calificacion No. 2: ");
		n2 = r.nextInt();
		System.out.print("Ingrese calificacion No. 3: ");
		n3 = r.nextInt();
		System.out.print("Ingrese calificacion No. 4: ");
		n4 = r.nextInt();
		System.out.print("Ingrese calificacion No. 5: ");
		n5 = r.nextInt();
		prom = (n1+n2+n3+n4+n5)/5;
		System.out.println("Matricula: "+mat);
		System.out.println("Promedio: "+prom);
	}
	//
	public void Program123() throws IOException {
		int N,i;
		double suma=0; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese Valor de N: ");
		N = Integer.parseInt(br.readLine());
		for(i=1;i<=N;i++)
			suma=suma+Math.pow(i,i);
		System.out.println("La suma de la serie es: "+suma);
	}
	//
	public void Program124() {
		Scanner r = new Scanner(System.in);
		int n;
		boolean flag=false;
		System.out.print("Ingrese un numero: ");
		n = r.nextInt();
		for(int i=2;i<n-1;i++) {
			if(n%i==0) {
				flag = true;
				break;
			}
		}
		if(flag==false)
			System.out.println("El numero "+n+" es primo");
		else
			System.out.println("El numero "+n+" no es primo");
	}
	//
	public void Program125() {
		int opcion;
		Scanner d=new Scanner(System.in);
		System.out.println("Hallar la Superficie de un Triangulo. Press 1");
		System.out.println("Hallar el Area de un Circulo. Press 2");
		System.out.println("Hallar la Base de un Triangulo. Press 3");
		System.out.println("Hallar el Radio de un Circulo. Press 4");
		System.out.print("Seleccione una Opcion: ");
		opcion=d.nextInt();
		if ((opcion>0)&&(opcion<5)) {
			switch(opcion) {
				case 1:
					System.out.print("Ingrese la Base del triangulo: ");
					int base=d.nextInt();
					System.out.print("Ingrese la Altura del triangulo: ");
					int altura=d.nextInt();
					int superficie=base*altura;
					System.out.println("La superficie es: "+superficie);
					break;
				case 2:
					System.out.print("Ingrese el Radio del circulo: ");
					int r=d.nextInt();
					double area=Math.PI*Math.pow(r, 2);
					System.out.println("El Area es: "+area);
					break;
				case 3:
					System.out.print("Ingrese la Superficie del triangulo: ");
					int superf=d.nextInt();
					System.out.print("Ingrese la Altura del triangulo: ");
					int altu=d.nextInt();
					int base3=superf/altu;
					System.out.println("La Base: "+base3);
					break;
				case 4:
					System.out.print("Ingrese el Area del circulo: ");
					int ar=d.nextInt();
					double ra=Math.sqrt(ar/Math.PI);
					System.out.println("El Area es: "+ra);
					break;
			}
		}
		else {
			System.out.println("Ingrese Una opcion entre 1-4");
		}
	}
	//
	public void Program126() {
		int i,suma_p=0,suma_i=0;
		for(i=1;i<=200;i++) {
			if(i%2==0)
				suma_p += i;
			else
				suma_i += i;
		}
		System.out.println("Suma de Pares = "+suma_p);
		System.out.println("Suma de Impares = "+suma_i);
	}
	//
	public void Program127() {
		Scanner r = new Scanner(System.in);
		int dias;
		double dist,costo;
		System.out.print("Dias de estancia: ");
		dias = r.nextInt();
		System.out.print("Distancia a recorrer: ");
		dist = r.nextDouble();
		costo=dist*0.75;
		if((dias>7)&&(dist>800))
			costo-=costo*0.30;
		System.out.println("Costo = "+costo);
	}
	//
	public void Program128() throws IOException {
		int edad,i,te_fem=0,thc_2500=0,tmv_1000=0,th=0,sum_edad=0;
		double sueldo,prom_edad;
		String edo_civ,sexo;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(i=1;i<=20;i++) {
			System.out.println("Empleado(a) No. "+i);
			System.out.print("Edad: ");
			edad = Integer.parseInt(br.readLine());
			System.out.print("Estado Civil (S)oltero(a) - (C)asado(a) - (V)iudo(a): ");
			edo_civ = br.readLine();
			System.out.print("Sexo (H)ombre - (M)ujer: ");
			sexo = br.readLine();
			System.out.print("Sueldo: ");
			sueldo = Double.parseDouble(br.readLine());
			if ((sexo=="M")||(sexo=="m"))
				te_fem++;
			if(((sexo=="H")||(sexo=="h"))&&((edo_civ=="C")||(edo_civ=="c"))&&(sueldo>2500))
				thc_2500++;
			if(((sexo=="M")||(sexo=="m"))&&((edo_civ=="V")||(edo_civ=="v"))&(sueldo>1000))
				tmv_1000++;
			if((sexo=="H")||(sexo=="h")) {
				th++;
				sum_edad+=edad;
			}
		}
		System.out.println("Total Empleadas Femeninas = "+te_fem);
		System.out.println("Total Hombres Casados que ganen mas de 2500 = "+thc_2500);
		System.out.println("Total Mujeres Viudas que ganen mas de 1000 = "+thc_2500);
		System.out.println("Edad promedio Hombres = "+sum_edad/th);
	}
	//
	public void Program129() {
		Scanner d = new Scanner(System.in);
		int dias_mes=0;
		System.out.print("Dia: ");
		int dia = d.nextInt();
		System.out.print("Mes: ");
		int mes = d.nextInt();
		System.out.print("Año: ");
		int anio = d.nextInt();
		if(mes>12) {
			System.out.println("Error: mes invalido !!!");
			System.exit(1);
		}
		else {
			if((mes==1)||(mes==3)||(mes==5)||(mes==7)||(mes==8)||(mes==10)||(mes==12))
				dias_mes=31;
			else if(mes==2) {
				if((anio%4==0)&&((anio%100!=0)||(anio%400==0)))
					dias_mes=29;
				else
					dias_mes=28;
			}
		}
		if(dia>dias_mes) {
			System.out.println("Error: cantidad de dias invalidos !!!");
			System.exit(1);
		}
	}
	//
	public void Program130() {
		Scanner r = new Scanner(System.in);
		int n,cont=0,cont2=0,cont3=0,cont4=0;
		double p;
		System.out.print("Ingrese cantidad de alumnos: ");
		n = r.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.print("Ingrese peso de Alumno No. "+i+": ");
			p = r.nextDouble();
			if(p<40)
				cont++;
			else if((p>=40)&&(p<=50))
				cont2++;
			else if((p>50)&&(p<60))
				cont3++;
			else if(p>=60)
				cont4++;
			else if(p==-99)
				break;
		}
		System.out.println("Alumnos de menos de 40 Kg: "+cont);
		System.out.println("Alumnos entre 40 y 50 Kg: "+cont2);
		System.out.println("Alumnos de más de 50 y menos de 60 Kg: "+cont3);
		System.out.println("Alumnos de más o igual a 60 Kg: "+cont4);
	}
	//
	public void Program131() {
		Scanner r = new Scanner(System.in);
		int pA,pB,i=1;
		System.out.println("Poblacion de los paises A y B en el año 0");
		System.out.print("Ingrese población de Pais A: ");
		pA = r.nextInt();
		System.out.print("Ingrese población de Pais B: ");
		pB = r.nextInt();
		while(pA<=pB) {
			pA+=(pA*0.06);
			pB+=(pB*0.03);
			System.out.println("Poblacion de pais A - Año "+i+": "+pA);
			System.out.println("Poblacion de pais B - Año "+i+": "+pB);
			i++;
		}
	}
	//
	public void Program132() {
		int b,h,s,p;
		Scanner r = new Scanner(System.in);
		System.out.print("Ingrese valor de la Base: ");
		b = r.nextInt();
		System.out.print("Ingrese valor de la Altura: ");
		h = r.nextInt();
		s = b*h;
		p = 2+(b+h);
		System.out.println("Superficie = "+s);
		System.out.println("Perimetro = "+p);
	}
	//
	public void Program133() {
		Scanner reader = new Scanner(System.in);
		int i,j,k,m,n;
		long fact_m=1,fact_n=1,fact_d=1,dif;
		double c;
		System.out.print("Introduce valor de M:");
		m = reader.nextInt();
		System.out.print("Introduce valor de N:");
		n = reader.nextInt();
		for(i=1;i<=m;i++)
			fact_m*=i;
		for(j=1;j<=n;j++)
			fact_n*=j;
		dif=m-n;
		for(k=1;k<=dif;k++)
			fact_d*=k;
		c = fact_m/(fact_n*(fact_d));
		System.out.println("Valor de M: "+fact_m); 
		System.out.println("Valor de N: "+fact_n);
		System.out.println("Valor de C: "+c);
	}
	//
	public void Program134() {
		Scanner r = new Scanner(System.in);
		double precio;
		System.out.print("Tipo de Portada: ");
		String portada = r.next();
		System.out.print("Numero de Paginas: ");
		int npag = r.nextInt();
		if(portada=="S")
			precio = 5.50+npag*0.125;
		else
			precio = 10.70+npag*0.125;
		if(npag>500)
			precio = precio - precio * 0.25;
		System.out.print("El precio del libro es: "+precio);
	}
	//
	public void Program135() {
		Scanner r = new Scanner(System.in);
		int n,edad,suma=0;
		double prom;
		System.out.print("Ingrese cantidad de Alumnos: ");
		n = r.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.print("Ingrese Edad de Alumno No. "+i+": ");
			edad = r.nextInt();
			suma+=edad;
		}
		prom = suma / n;
		System.out.println("El promedio de edad es: "+prom);
	}
	//
	public void Program136() {
		Scanner reader = new Scanner(System.in);
		int n1,n2;
		System.out.print("Introduce valor de N1:");
		n1 = reader.nextInt();
		System.out.print("Introduce valor de N2:");
		n2 = reader.nextInt();
		if(n1>n2)
			System.out.println(n1+" es mayor que "+n2);
		else
			System.out.println(n2+" es mayor que "+n1);
	}
	//
	public void Program137() {
		Scanner reader = new Scanner(System.in);
		int n1;
		System.out.print("Introduce valor de N1:");
		n1 = reader.nextInt();
		if(n1%2==0)
			System.out.println("El numero introducido es par.");
		else
			System.out.println("El numero introducido es impar.");
	}
	//
	public void Program138(){
		int suma = 0;
		Scanner reader = new Scanner(System.in);
		System.out.println("SUMA DE OCHO NUMEROS");
		for(int i=1;i<9;i++){
			System.out.print("Introduce valor del numero "+i+": ");
			int numero = reader.nextInt();
			suma = suma + numero;
		}
		System.out.print("El Total de la Suma es: "+suma);
	}
	//
	public void Program139() {
		Scanner r = new Scanner(System.in);
		int b,h;
		double s;
		System.out.print("Ingrese Base: ");
		b = r.nextInt();
		System.out.print("Ingrese Altura: ");
		h = r.nextInt();
		s = b*h/2;
		System.out.println("Superficie = "+s);
	}
	//
	public void Program140() {
		Scanner d=new Scanner(System.in);
		int cont=0,acum=0;
		boolean flag=true;
		while (flag=true) {
			System.out.print("Ingrese un numero: ");
			int num=d.nextInt();
			if(num==0) {
				flag=false;
				break;
			}
			else {
				cont++;
				acum+=num;
			}
		}
		double prom=acum/cont;
		System.out.println("El promedio es: "+prom);
	}
}
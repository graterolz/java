import java.io.*;
import java.util.*;
public class JavaNoTest2 {
	//
	public void Program21() throws IOException{
		BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
		int Monto_Inicial = 0;
		double Cuenta = 0;
		double Sumatoria = 0;
		double Total = 0;
		System.out.print("Ingrese el Monto: ");
		Monto_Inicial = Integer.parseInt (br.readLine());
		Cuenta = (Monto_Inicial+3000);
		Sumatoria = Cuenta*0.15;
		Total = Cuenta+Sumatoria;
		System.out.println("El Monto de la Cuenta es: " +Cuenta);
		System.out.println("La Couta de intereses Anuales es: " +Sumatoria);
		System.out.println("Total en Todo el Año: "+Total);
	}
	//
	public void Program22() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numero;
		int contador = 2;
		System.out.print("Ingrese numero: ");
		numero = Integer.parseInt(br.readLine());
		while ((true) && (contador!=numero)){
			if (numero % contador == 0){
				System.out.println("No es Primo.");
				contador=contador+1;
			}
		}
		System.out.println("Es Primo.");
	}
	//
	public void Program23() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese numero de tabla de multiplicar a mostrar: ");
		int numero = Integer.parseInt(br.readLine());
		for(int i=1;i<=10;i=i+1){
			System.out.println(numero+" x "+i+" = "+(i*numero));
		}
	}
	//
	public void Program24(){
		Scanner entrada = new Scanner(System.in);
		int num1,num2,num3,num4;
		System.out.println("Ingrese numero 1:");
		num1 = entrada.nextInt();
		System.out.println("Ingrese numero 2:");
		num2 = entrada.nextInt();
		System.out.println("Ingrese numero 3:");
		num3 = entrada.nextInt();
		System.out.println("Ingrese numero 4:");
		num4 = entrada.nextInt();
		if(num1>num2){
			if(num1>num3){
				if(num1>num4){
					System.out.println("El numero mayor es: " + num1);
				}
				else{
					System.out.println("El numero mayor es: " + num4);
				}
			}
		}
		else if(num2>num3){
			if(num2>num4){
				System.out.println("El numero mayor es: " + num2);
			}
			else{
				System.out.println("El numero mayor es: " + num4);
			}
		}
		else if(num3>num4){
			System.out.println("El numero mayor es: " + num3);
		}
		else{
			System.out.println("El numero mayor es: " + num4);
		}
	}
	//
	public void Program25() throws IOException{
		BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
		String n,nra;
		int nt,nm,nm1=0, nf, nf1=0, np, np1=0;
		int Suma=0, Suma1=0, Suma2=0, Suma3=0;
		int aprob=0,aprom=0,aprof=0,aprop=0, tm=0, tp=0, tf=0,z, id;
		double tm1,tf1,tp1;
		System.out.println ("ingrese el cantidad de tarjetas a leer");
		nt=Integer.parseInt (br.readLine());
		for (z=1;z<=nt;z++){
			System.out.println ("ingrese la cedula del almuno");
			id=Integer.parseInt (br.readLine ());
			System.out.println ("ingrese el numero de notas de Matematica");
			nm=Integer.parseInt (br.readLine ());
			for (z=1;z<=nm;z++){
				System.out.println ("ingrese las nota de Matematica");
				nm1=Integer.parseInt (br.readLine( ));
			}
			System.out.println ("ingrese el numero de notas de Fisica");
			nf=Integer.parseInt (br.readLine ());
			for (z=1;z<=nf;z++){
				System.out.println ("ingrese las nota de Fisica");
				nf1=Integer.parseInt (br.readLine ());
			}
			System.out.println ("ingrese el numero de notas de Programacion");
			np=Integer.parseInt (br.readLine ());
			for (z=1;z<=np;z++){
				System.out.println ("ingrese las nota de Programacion");
				np1=Integer.parseInt (br.readLine ());
			}
			Suma1=Suma+nm1;
			Suma2=Suma+nf1;
			Suma3=Suma+np1;
			tm=Suma1/nm;
			tf=Suma2/nf;
			tp=Suma3/np;
			if (tm>=9.5){
				aprom=aprob+1;
				if (tf>=9.5){
					aprof=aprob+1;
					if (tp>=9.5){
						aprop=aprob+1;
					}
				}
			}
		}
		System.out.println ("los alumnos aprobados en matematica son " +aprom); 
		System.out.println ("los alumnos aprobados en Fisica son " +aprof);
		System.out.println ("los alumnos aprobados en Programacion son " +aprop);
		System.out.println ("el promedio de matematica es de " +tm);
		System.out.println ("el promedio de Fisica es de " +tf);
		System.out.println ("el promedio de Programacion es de " +tp);
	}
	//
	public void Program26() throws IOException{
		BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
		int i = 0;
		System.out.print("Ingrese Cantidad de Tarjetas que desea Ingresar: ");
		i = Integer.parseInt(br.readLine());
		int cedula[] = new int[i];
		double n_matematicas[] = new double [i];
		double n_fisica[] = new double [i];
		double n_programacion[] = new double [i];
		double promedio_alum[] = new double [i];
		double promedio_mat=0,promedio_fis=0,promedio_prog=0;
		int cantidad_aprobado=0;
		try{
			for(int x=0;x<i;x++){
				System.out.println("Alumno: "+(x+1));
				System.out.print("Ingrese Cedula: ");
				cedula[x] = Integer.parseInt(br.readLine());
				System.out.print("Ingrese Nota de Matematicas: ");
				n_matematicas[x] = Double.parseDouble(br.readLine());
				System.out.print("Ingrese Nota de Fisica: ");
				n_fisica[x] = Double.parseDouble(br.readLine());
				System.out.print("Ingrese Nota de Programacion: ");
				n_programacion[x] = Double.parseDouble(br.readLine());
				promedio_alum[x] = (n_matematicas[x]+n_fisica[x]+n_programacion[x])/3;
				promedio_mat = promedio_mat + n_matematicas[x];
				promedio_fis = promedio_fis + n_fisica[x];
				promedio_prog = promedio_prog + n_programacion[x];
				if (promedio_alum[x]>=10){
					cantidad_aprobado = cantidad_aprobado + 1;
				}
			}
			for(int x=0;x<i;x++){
				System.out.println("Alumno: "+(x+1)+", Promedio: "+promedio_alum[x]);
			}
			System.out.println("Promedio en Matematicas: "+(promedio_mat/i));
			System.out.println("Promedio en Fisica: "+(promedio_fis/i));
			System.out.println("Promedio en Programacion: "+(promedio_prog/i));
			System.out.println("Alumnos Aprobados: "+cantidad_aprobado);
		}
		catch(Exception ex){
			System.out.print(ex);
		}
	}
	//
	public void Program27() {
		Scanner sc = new Scanner(System.in);
		int Cedula;
		String Nombre;
		String Apellido;
		String Sexo;
		int Edad;
		double SueldoBase = 0;
		double CantidadLunes = 0;
		double SSO = 0;
		try{
			System.out.print("Ingrese Cedula: ");
			Cedula = sc.nextInt();
		}
		catch(Exception e){
			System.out.println("Error al Ingresar Cedula.");
			System.exit(0);
		}
		System.out.print("Ingrese Nombres: ");
		Nombre = sc.next();
		System.out.print("Ingrese Apellidos: ");
		Apellido = sc.next();
		System.out.print("Ingrese Sexo: ");
		Sexo = sc.next();
		try{
			System.out.print("Ingrese Edad: ");
			Edad = sc.nextInt();
		}
		catch(Exception e){
			System.out.print("Error al Ingresar Cedula.");
			System.exit(0);
		}		
		try{
			System.out.print("Ingrese Sueldo Base: ");
			SueldoBase = sc.nextFloat();
		}
		catch(Exception e){
			System.out.print("Error al Ingresar Sueldo Base.");
			System.exit(0);
		}
		System.out.print("Ahora indicanos la siguiente informacion para completar el Calculo:\n");
		try{
			System.out.print("Ingrese cantidad de dias Lunes que posee el Mes: ");
			CantidadLunes = sc.nextFloat();
			CantidadLunes = CantidadLunes/100;
			System.out.print(CantidadLunes);
		}
		catch(Exception e){
			System.out.print("Error al Ingresar Cantidad de Dias.");
			System.exit(0);
		}
		try{
			SSO = SueldoBase * (12/52);
			SSO = SSO * CantidadLunes;
			System.out.print(SSO);
			System.out.print(SSO);
			SSO = (SSO * CantidadLunes);
			System.out.print(SSO);
		}
		catch(Exception e){
			System.out.print("Error");
		}
	}
	//
	public void Program28() {
		Scanner teclado=new Scanner(System.in);
		String nombre="";
		double peso,longitud;
		double kilogramos,metros;
		try {
			System.out.print("Ingrese nombre del dinosaurio: ");
			nombre=teclado.nextLine();
			System.out.print("Ingrese peso (libras): ");
			peso=teclado.nextDouble();
			System.out.print("Ingrese longitud (pies): ");
			longitud=teclado.nextDouble();
			kilogramos=peso*0.4535;
			metros=longitud*0.3047;
			System.out.println("Nombre del dinosaurio: "+nombre);
			System.out.println("Kilogramos: "+kilogramos);
			System.out.println("Metros: "+metros);
		}
		catch (Exception e) {
			System.out.println("Error al ingresar los valores decimales");
		}
	}
	//
	public void Program29() {
		Scanner teclado=new Scanner(System.in);
		double costo,cantidadDinero,cambio;
		try {
			System.out.print("Ingrese costo del articulo: ");
			costo=teclado.nextDouble();
			System.out.print("Ingrese cantidad de dinero entregado: ");
			cantidadDinero=teclado.nextDouble();
			cambio=costo-cantidadDinero;
			if (costo==cantidadDinero) {
				System.out.println("No debe dar cambio.");
			}
			else if (costo>cantidadDinero) {
				System.out.println("Faltan: "+cambio);
			}
			else {
				System.out.println("El cambio es: "+(cambio*-1));
			}
		}
		catch (Exception e) {
			System.out.println("Error al ingresar los valores decimales");
		}
	}
	//
	public void Program30() {
		Scanner teclado=new Scanner(System.in);
		double base,altura;
		try {
			System.out.print("Ingrese base: ");
			base=teclado.nextDouble();
			System.out.print("Ingrese altura: ");
			altura=teclado.nextDouble();
			double superficie=(base*altura);
			double perimetro=2*(base+altura);
			System.out.println("Superficie: "+superficie);
			System.out.println("Perimetro: "+perimetro);
		}
		catch (Exception e) {
			System.out.println("Error al ingresar los valores decimales");
		}
	}
	//
	public void Program31() throws IOException{
		BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
		int i = 0;
		System.out.print("Ingrese Cantidad de Empleados: ");
		i = Integer.parseInt(br.readLine());
		double sueldos[] = new double [i];
		double asignaciones[] = new double [i];
		double deducciones[] = new double [i];
		double total_pagar[] = new double [i];
		try{
			for(int x=0;x<i;x++){
				System.out.println("Empleado: "+(x+1));
				System.out.print("Ingrese Sueldo Base: ");
				sueldos[x] = Double.parseDouble(br.readLine());
				System.out.print("Ingrese Total de Asignaciones: ");
				asignaciones[x] = Double.parseDouble(br.readLine());
				System.out.print("Ingrese Total de Deducciones: ");
				deducciones[x] = Double.parseDouble(br.readLine());
				total_pagar[x] = (sueldos[x]+asignaciones[x])-deducciones[x];
			}
			for(int x=0;x<i;x++){
				System.out.println("Empleado: "+(x+1));
				System.out.println("Total a Pagar: "+total_pagar[x]);
			}
		}
		catch(Exception ex){
			System.out.print(ex);
		}
	}
	//
	public void Program32() {
		Scanner teclado=new Scanner(System.in);
		double base,altura;
		try {
			System.out.print("Ingrese base: ");
			base=teclado.nextDouble();
			System.out.print("Ingrese altura: ");
			altura=teclado.nextDouble();
			double superficie=(base*altura)/2;
			System.out.println("Superficie: "+superficie);
		}
		catch (Exception e) {
			System.out.println("Error al ingresar los valores decimales");
		}
	}
	//
	public void Program33() {
		Scanner entrada = new Scanner(System.in);
		int num1,num2,num3,num4;
		System.out.println("Ingrese numero 1:");
		num1 = entrada.nextInt();
		System.out.println("Ingrese numero 2:");
		num2 = entrada.nextInt();
		System.out.println("Ingrese numero 3:");
		num3 = entrada.nextInt();
		System.out.println("Ingrese numero 4:");
		num4 = entrada.nextInt();
		if(num1>num2){
			if(num1>num3){
				if(num1>num4){
					System.out.println("El numero mayor es: " + num1);
				}
				else{
					System.out.println("El numero mayor es: " + num4);
				}
			}
		}
		else if(num2>num3){
			if(num2>num4){
				System.out.println("El numero mayor es: " + num2);
			}
			else{
				System.out.println("El numero mayor es: " + num4);
			}
		}
		else if(num3>num4){
			System.out.println("El numero mayor es: " + num3);
		}
		else{
			System.out.println("El numero mayor es: " + num4);
		}
	}
	//
	public void Program34() throws IOException {
		char entrada;
		try {
			Reader r = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(r);
			entrada = (char) br.read();
		}
		catch (IOException e) {
			System.exit(1);
		}
		System.out.println(entrada);
	}
	//
	public void Program35() throws IOException {
		String input;
		try {
			Reader rin = new InputStreamReader(System.in);
			BufferedReader brin = new BufferedReader(rin);
			input = brin.readLine();
		}
		catch (IOException e) {
			System.exit(1);
		}
		System.out.println(input);
	}
	//
	public void Program36() {
		char primero,ultimo;
		System.out.println("introduzca sus iniciales");
		System.out.print("\t primer apellido");
		System.out.flush();
		primero =(char) System.in.read();
		System.out.println("\t segundo apellido");
		System.out.flush();
		ultimo =(char) System.in.read();
		System.out.println("hola,"+ primero + "." + ultimo +".!\n");
		System.out.println("Programador: T.S.U. JULIO CESAR PARRA FUENMAYOR \n");
	}
	//
	public void Program37() throws IOException {
		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca los caracterres, pulse Q para salir");
		do {
			c = (char) br.read();
			System.out.println(c);
		} while(c!='q');
	}
	//
	public void Program38() {
		try {
			int a = args.length;
			System.out.println("a = "+a);
			int b = 42 / a;
			int c[] = {1}; 
			c[42] = 99; 
		}
		catch(ArithmeticException e) {
			System.out.println("Division por cero "+e);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice del Array fuera "+e);
		}
		System.out.println("Fin de las Excepciones");
	}
	//
	public void Program39() {
		int a,b,c,d,ad,bd,cd,dd,np,ni;
		np=0;
		ni=0;
		a=3;
		b=7;
		c=9;
		d=1;
		ad=a%2;
		if(ad==0){
			np=np+1;
		} else{
			ni=ni+1;
		}
		bd=b%2;
		if(bd==0){
			np=np+1;
		} else{
			ni=ni+1;
		}
		cd=c%2;
		if(cd==0){
			np=np+1;
		}
		else{
			ni=ni+1;
		}
		dd=d%2;
		if(dd==0){
			np=np+1;
		}
		else{
			ni=ni+1;
		}
		System.out.println("Cantidad de pares es: "+np);
		System.out.println("Cantidad de impares es: "+ni);
	}
	//
	public void Program40() throws IOException {
		String c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca los caracterres, pulse Q para salir"); 
		do {
			c = br.readLine();
			System.out.println(c);
		} while(!c.equals("alto"));
	}
}
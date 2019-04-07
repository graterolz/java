import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class JavaNoTest4{
	//
	public void Program61() throws IOException {
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
	//
	public void Program62() {
		Thread t = Thread.currentThread();
		System.out.println("Hilo actual: "+t);
		t.setName("Mi Hilo");
		System.out.println("Hilo nuevo: "+t);
		try {
			for(int n=5;n>0;n--) {
				System.out.println(n);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Interrupcion del hilo principal");
		}
	}
	//
	public void Program63() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese valor de Lado 1: ");
		int l1 = Integer.parseInt(br.readLine());
		System.out.print("Ingrese valor de Lado 2: ");
		int l2 = Integer.parseInt(br.readLine());
		System.out.print("Ingrese valor de Lado 3: ");
		int l3 = Integer.parseInt(br.readLine());
		double s = (l1+l2+l3)/2;
		double area = Math.sqrt(s*(s-l1)*(s-l2)*(s-l3));
		System.out.println("El area es: "+area);
	}
	//
	public void Program64() {
		double resultado1, resultado2;
		int ld=50;
		int kd=50;
		int md=50;
		int jd=50;
		int vd=50;
		int sd=50;
		int dd=80;
		resultado1= ld*(8)+kd*(8)+md*(8)+jd*(8)+vd*(8)+sd*(8)+dd*(8);
		JOptionPane.showMessageDialog(null, "El resultado de la suma de las tarifas diurnas es: "+ resultado1);
		int ln=80;
		int kn=80;
		int mn=80;
		int jn=80;
		int vn=80;
		int sn=80;
		int dn=110;
		resultado2= ln*(8)+kn*(8)+mn*(8)+jn*(8)+vn*(8)+sn*(8)+dn*(8);
		JOptionPane.showMessageDialog(null, "El resultado de la suma de las tarifas nocturnas es: "+ resultado2);
	}	
	//
	public void Program65() {
		Scanner reader = new Scanner(System.in);
		int m,n,i,spar=0,simp=0;
		System.out.print("Ingrese cantidad de Numeros: ");
		n = reader.nextInt();
		int a[] = new int[n];
		for(i=0;i<=n-1;i++) {
			System.out.print("Introduce valor de elemento No. "+(i+1)+": ");
			m = reader.nextInt();
			if(m%2==0){
				spar+=m;
			}
			else{
				simp+=m;
			}
		}
		System.out.println("La sumatoria de los pares es igual a: "+spar);
		System.out.println("La sumatoria de los impares es igual a: "+simp);
	}
	//
	public void Program66() throws IOException {
		BufferedReader in;
		in=new BufferedReader(new InputStreamReader(System.in));
		double m=1,aux=0,n=0,o=0;
		System.out.println("La edad 0 indica el final de ingreso de edades");
		while(m!=0) {
			System.out.print("Ingrese una edad: ");
			m=Integer.parseInt(in.readLine());
			if(m!=0){
				n++;
			}
			aux=aux+m;
			if(m>50){
				o++;
			}
		}
		double prom=aux/n;
		System.out.println("Promedio de edad: "+prom);
		System.out.println("Cantidad de personas: "+n);
		System.out.println("Personas >50: "+o);
	}
	//
	public void Program67() {
		Scanner reader = new Scanner(System.in);
		System.out.print("Ingrese Nota No. 1: ");
		int nota1 = reader.nextInt();
		System.out.print("Ingrese Nota No. 2: ");
		int nota2 = reader.nextInt();
		System.out.print("Ingrese Nota No. 3: ");
		int nota3 = reader.nextInt();
		System.out.print("Ingrese Nota No. 4: ");
		int nota4 = reader.nextInt();
		System.out.print("Ingrese Nota No. 5: ");
		int nota5 = reader.nextInt();
		double prom = (nota1+nota2+nota3+nota4+nota5)/5;
		System.out.println("El promedio es: "+prom);
	}
	//
	public void Program68() {
		boolean b;
		b = false;
		System.out.println("b es "+b);
		b = true;
		System.out.println("b es "+b);
		if (b){
			System.out.println("Esto se ejecuta");
		}
		b = false;
		if (b){
			System.out.println("Esto no se ejecuta");
		}
		System.out.println("10>9"+(10>9));
	}
	//
	public void Program69() {
		Scanner reader = new Scanner(System.in);
		int n,i,j,suma=0;
		System.out.print("Ingrese Dimension de la matriz: ");
		n = reader.nextInt();
		int a[][] = new int[n][n];
		int b[] = new int[n];
		for(i=0;i<=n-1;i++) {
			for(j=0;j<=n-1;j++) {
				System.out.print("Introduce valor de elemento No. ["+(i+1)+","+(j+1)+"]: ");
				a[i][j] = reader.nextInt();
				suma+=a[i][j];
			}
			b[i]=suma;
			suma=0;
		}
		for(i=0;i<=n-1;i++){
			System.out.println("Valor de b["+i+"]: "+b[i]);
		}
	}
	//
	public void Program70() {
		int a=3,b=6,c;
		c=a/b;
		System.out.println("El valor de c es: "+c);
		c=a%b;
		System.out.println("El valor de c es: "+c);
		a++;
		System.out.println("El valor de a es: "+a);
		++a;
		System.out.println("El valor de a es: "+a);
		c=++a+b++;
		System.out.println("El valor de a es: "+a);
		System.out.println("El valor de b es: "+b);
		System.out.println("El valor de c es: "+c);
		c=++a + ++b;
		System.out.println("El valor de a es: "+a);
		System.out.println("El valor de b es: "+b);
		System.out.println("El valor de c es: "+c);
	}
	//
	public void Program71() throws IOException {
		int h,m,s,total;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Valor de horas: ");
		h = Integer.parseInt(br.readLine());
		System.out.print("Valor de minutos: ");
		m = Integer.parseInt(br.readLine());
		System.out.print("Valor de segundos: ");
		s = Integer.parseInt(br.readLine());
		total = h*3600+m*60+s;
		System.out.println("Total de segundos: "+total);
	}
	//
	public void Program72() throws IOException {
		char a;
		System.out.println("Ingrese el numero del dia: ");
		a=(char) System.in.read();
		switch(a) {
			case '1': System.out.println("Lunes"); break;
			case '2': System.out.println("Martes"); break;
			case '3': System.out.println("Miercoles"); break;
			case '4': System.out.println("Jueves"); break;
			case '5': System.out.println("Viernes"); break;
			case '6': System.out.println("Sabado"); break;
			case '7': System.out.println("Domingo"); break;
			default: System.out.println("Solo existen siete dias"); break;
		}
	}
	//
	public void Program73() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double c1,c2,c3;
		double s1,s2;
		double nota_present;
		double prom_controles;
		System.out.print("\nIngrese nota control 1: ");
		c1 = Double.parseDouble(in.readLine());
		System.out.print("\nIngrese nota control 2: ");
		c2 = Double.parseDouble(in.readLine());
		System.out.print("\nIngrese nota control 3: ");
		c3 = Double.parseDouble(in.readLine());
		prom_controles=(c1+c2+c3)/3;
		prom_controles=Math.round(prom_controles*10)/10.0;
		System.out.println("\n\tPromedio controles: "+prom_controles);
		System.out.print("\nIngrese nota solemne 1: ");
		s1 = Double.parseDouble(in.readLine());
		System.out.print("\nIngrese nota solemne 2: ");
		s2 = Double.parseDouble(in.readLine());
		nota_present=(s1+s2+prom_controles)/3;
		nota_present=Math.round(nota_present*10)/10.0;
		System.out.println("\n\tNota de presentacion: "+nota_present);
		if(nota_present>=3.5) {
			double nota_examen;
			nota_examen=(3.95-0.70*nota_present)/0.30;
			nota_examen=Math.round(nota_examen*10)/10.0;
			System.out.println("\n\tNota minima de examen para aprobar el ramo: "+nota_examen);
		}
		else {
			System.out.println("\n\tNo tiene derecho a dar examen");
			System.out.println();
		}
	}
	//
	public void Program74() {
		InputStreamReader irs = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (irs);
		double PI = 3.14;
		try{
			System.out.print("Ingrese Radio del Cilindro: ");
			int Radio = Integer.parseInt(br.readLine());
			System.out.print("Ingrese Altura del Cilindro: ");
			int Altura = Integer.parseInt(br.readLine());
			double F_Volumen = PI*(Math.pow(Radio,2))*Altura;
			double F_Area = PI*(Math.pow(Radio,2))+PI*Radio*2*Altura; 
			System.out.println("******************************");
			System.out.println("El Area Es: "+F_Area);
			System.out.println("El Volumen Es: "+F_Volumen);
			System.out.println("******************************");
		}
		catch(NumberFormatException nfe){
			System.out.println("Lo que Ha Ingresado NO es un Numero ENTERO, VERIFIQUE.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//
	public void Program75() throws IOException {
		double x=0;
		double a,b,y=0;
		int i,n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Ingrese valor de n: ");
		n = Integer.parseInt(br.readLine());
		for(i=1;i<=n;i++) {
			System.out.print("Ingrese valor de a: ");
			a = Double.parseDouble(br.readLine());
			System.out.print("Ingrese valor de b: ");
			b = Double.parseDouble(br.readLine());
			y = Math.pow(a,2)+Math.pow(b,2);
			if (y>0) x+=(a+b);
			else if (y==0) x+=(a-2*b);
			else x+=(a+b-5);
		}
		System.out.println("La suma es: "+y);
	}
	//
	public void Program76() {
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
	public void Program77() throws IOException {
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
	public void Program78(){
		DecimalFormat df = new DecimalFormat("#.##");
		String sCedula;
		String sNombres;
		String sApellidos;
		String sSexo;
		String sEdad;
		String sSueldo;
		String sCantidadDias;
		int iCedula = 0;
		int iEdad = 0;
		int iCantidadDias = 0;
		double dSueldo = 0;
		double SSO = 0;
		double SPF = 0;
		double LPH = 0;
		sCedula = JOptionPane.showInputDialog("Ingrese Cedula:");
		try{
			iCedula = Integer.parseInt(sCedula);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Cedula Invalida.","Aplicacion",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		sNombres = JOptionPane.showInputDialog("Ingrese Nombres:");
		sApellidos = JOptionPane.showInputDialog("Ingrese Apellidos:");
		sSexo = JOptionPane.showInputDialog("Ingrese Sexo:");
		sEdad = JOptionPane.showInputDialog("Ingrese Edad:");
		try{
			iEdad = Integer.parseInt(sEdad);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Edad Invalida.","Aplicacion",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		sSueldo = JOptionPane.showInputDialog("Ingrese Sueldo Base:");
		try{
			dSueldo = Double.parseDouble(sSueldo);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Sueldo Base Invalido.","Aplicacion",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		sCantidadDias = JOptionPane.showInputDialog("Ingrese cantidad de dias Lunes que posee el Mes:");
		try{
			iCantidadDias = Integer.parseInt(sCantidadDias);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Dias Invalido.","Aplicacion",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		SSO = (dSueldo * 12)/52;
		SSO = (SSO * 0.04);
		SSO = (SSO * iCantidadDias);
		JOptionPane.showMessageDialog(null,"Seguro Social: "+df.format(SSO)+" Bsf.","Aplicacion",JOptionPane.INFORMATION_MESSAGE);
		SPF = (dSueldo * 12)/52;
		SPF = (SPF * 0.5);
		SPF = (SPF * iCantidadDias);
		JOptionPane.showMessageDialog(null,"Paro Forzoso: "+df.format(SPF)+" Bsf.","Aplicacion",JOptionPane.INFORMATION_MESSAGE);
		LPH = (dSueldo * 0.01);
		JOptionPane.showMessageDialog(null,"Ley de Politica Habitacional: "+df.format(LPH)+" Bsf.","Aplicacion",JOptionPane.INFORMATION_MESSAGE);
		dSueldo = dSueldo - SSO;
		dSueldo = dSueldo - SPF;
		dSueldo = dSueldo - LPH;
		dSueldo = (dSueldo/2);
		JOptionPane.showMessageDialog(null,"Cedula: "+iCedula+".\n Nombres: "+sNombres+".\n Apellidos: "+sApellidos+".\n Sexo: "+sSexo+".\n Edad: "+iEdad+".","Aplicacion",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null,"Quincena: "+df.format(dSueldo)+" Bsf.","Aplicacion",JOptionPane.INFORMATION_MESSAGE);
	}
	//
	public void Program79() {
		int d,a;
		try {
			d = 0;
			a = 42/d;
			System.out.println("Esto no se imprimirá");
		}
		catch(ArithmeticException e) {
			System.out.println("Division por cero"); 
		}
		System.out.println("Despues de la sentencia catch");
	}
	//
	public void Program80() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double a,b,c;
		System.out.println("Ingrese valor de a: ");
		a = Double.parseDouble(br.readLine());
		System.out.println("Ingrese valor de b: ");
		b = Double.parseDouble(br.readLine());
		System.out.println("Ingrese valor de c: ");
		c = Double.parseDouble(br.readLine());
		double d = Math.sqrt(Math.pow(b,2)-4*a*c);
		if (d<=0){
			System.out.println("Raices Imaginarias");
		}
		else {
			double x1 = (-b+d)/(2*a);
			double x2 = (-b-d)/(2*a);
			System.out.println("x1 = "+x1);
			System.out.println("x2 = "+x2);
		}
	}
}
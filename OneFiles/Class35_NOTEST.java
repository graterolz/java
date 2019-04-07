import java.util.Scanner;

class Empleado {
	private String dni,nombre,apellidos,domicilio,f_cont;
	private double s_bruto;
	//
	Empleado() {
		System.out.println("Uso del Constructor");
		dni = ""; 
		nombre = ""; 
		apellidos = ""; 
		domicilio = ""; 
		f_cont = "";
		s_bruto = 0.00;
	}
	// 
	void Get() {
		System.out.println("Uso de Get");   
		Scanner d = new Scanner(System.in);
		System.out.print("DNI: ");
		dni = d.next();
		System.out.print("Nombre: ");
		nombre = d.next();
		System.out.print("Apellido(s): ");
		apellidos = d.next();
		System.out.print("Domicilio: ");
		domicilio = d.next();
		System.out.print("Fecha Contratacion: ");
		f_cont = d.next();
		System.out.print("Sueldo bruto: ");
		s_bruto = d.nextDouble();
	}
	//
	void Set(String d,String n,String a,String dom,String fc,double sb) {
		System.out.println("Uso de Set");   
		dni = d; 
		nombre = n; 
		apellidos = a; 
		domicilio = dom; 
		f_cont = fc;
		s_bruto = sb;
	}
	//
	String GetAtributos() {
		return(dni+" "+nombre+" "+apellidos+" "+domicilio+" "+f_cont+" "+s_bruto);
	}
}
//
class Class35 {
	public static void main(String args[]) {
		Empleado empleado1 = new Empleado();
		empleado1.Get();
		empleado1.Set("12443786","Maria","Rivas C.","Los Haticos","25/10/2004",5600);
		System.out.println(empleado1.GetAtributos());
	}
}
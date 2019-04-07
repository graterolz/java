import java.util.*;
class empleado {
	String nombre;
	int numero;
	//
	void LeerDatos() {
		Scanner reader = new Scanner(System.in);
		System.out.print("Nombre: ");
		nombre = reader.next();
		System.out.print("Numero: ");
		numero = reader.nextInt();
	}
	//
	void VerDatos() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Numero: "+numero);
	}
}
//
class Class15 {
	public static void main(String args[]) {
		empleado emp = new empleado();
		emp.LeerDatos();
		emp.VerDatos();
	}
}
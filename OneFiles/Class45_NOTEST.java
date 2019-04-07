import java.io.*;
class Circulo {
	final double pi = 3.141516;
	double radio;
	//
	void LeerRadio(double r) {
		radio = r;
	}
	//
	double Area() {
		return (pi*Math.pow(radio,2));
	}
	//
	double Circunferencia() {
		return (2*pi*radio);
	}
}
//
class Cilindro extends Circulo {
	double altura;
	//
	void LeerAltura(double h) {
		altura = h;
	}
	//
	double Area() {
		return (2*pi*radio*altura+2*pi*radio);
	}
	//
	double Volumen() {
		return (pi*Math.pow(radio,2)*altura);
	}
}
//
class CilindroHueco extends Cilindro {
	double rinterno;
	//
	void LeerRadioInterno(double ri) {
		rinterno = ri;
	}
	//
	double Circunferencia() {
		return (2*pi*(Math.pow(radio,2)-Math.pow(rinterno,2))+2*pi*radio*altura+2*pi*rinterno);
	}
	//
	double Volumen() {
		return(pi*(Math.pow(radio,2)-Math.pow(rinterno,2))*altura);
	}
}
//
class Class45 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Uso de la clase Circulo");
		Circulo circle = new Circulo();
		System.out.print("Ingrese Radio: ");
		double x = Double.parseDouble(br.readLine());
		circle.LeerRadio(x);
		System.out.println("Area = "+circle.Area());
		System.out.println("Circunferencia = "+circle.Circunferencia());
		System.out.println("Uso de la clase Cilindro");
		Cilindro cylinder = new Cilindro();
		System.out.print("Ingrese Radio: ");
		double y = Double.parseDouble(br.readLine());
		System.out.print("Ingrese Altura: ");
		double z = Double.parseDouble(br.readLine());
		cylinder.LeerRadio(y);
		cylinder.LeerAltura(z);
		System.out.println("Area = "+cylinder.Area());
		System.out.println("Volumen = "+cylinder.Volumen());
		System.out.println("Uso de la clase CilindroHueco");
		CilindroHueco hollowCylinder = new CilindroHueco();
		System.out.print("Ingrese Radio: ");
		double i = Double.parseDouble(br.readLine());
		System.out.print("Ingrese Altura: ");
		double j = Double.parseDouble(br.readLine());
		System.out.print("Ingrese Altura: ");
		double k = Double.parseDouble(br.readLine());
		hollowCylinder .LeerRadio(i);
		hollowCylinder .LeerAltura(j);
		hollowCylinder .LeerRadioInterno(k);
		System.out.println("Circunferencia = "+hollowCylinder.Circunferencia());
		System.out.println("Volumen = "+hollowCylinder.Volumen());
	}
}
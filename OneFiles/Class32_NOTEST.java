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
class Class32 {
	public static void main(String args[]) {
		System.out.println("Uso de la clase Circulo");
		Circulo circle = new Circulo();
		circle.LeerRadio(3.25);
		System.out.println("Area = "+circle.Area());
		System.out.println("Circunferencia = "+circle.Circunferencia());
		System.out.println("Uso de la clase Cilindro");
		Cilindro cylinder = new Cilindro();
		cylinder.LeerRadio(5.15);
		cylinder.LeerAltura(4.45);
		System.out.println("Area = "+cylinder.Area());
		System.out.println("Volumen = "+cylinder.Volumen());
		System.out.println("Uso de la clase CilindroHueco");
		CilindroHueco hollowCylinder = new CilindroHueco();
		hollowCylinder .LeerRadio(5.15);
		hollowCylinder .LeerAltura(4.45);
		hollowCylinder .LeerRadioInterno(3.12);
		System.out.println("Circunferencia = "+hollowCylinder.Circunferencia());
		System.out.println("Volumen = "+hollowCylinder.Volumen());
	}
}
class Numero {
	int x,y;
	//
	void Numero() {
		x = 1;
		y = 2;
	}
	//
	void suma() {
		System.out.println("La suma es: "+(x+y));
	}
	//
	int suma(int a, int b) {
		return(a+b);
	}
	//
	double suma(double a, double b) {
		return(a+b);
	}
	//
	void resta() {
		System.out.println("La resta es: "+(x-y));
	}
	//
	int resta(int a, int b) {
		return(a-b);
	}
	//
	double resta(double a, double b) {
		return(a-b);
	}
	//
	void producto() {
		System.out.println("La Multiplicacion es: "+(x*y));
	}
	//
	int producto(int a, int b) {
		return(a*b);
	}
	//
	double producto(double a, double b) {
		return(a*b);
	}
	//
	void division() {
		System.out.println("La Division es: "+(x/y));
	}
	//
	int division(int a, int b) {
		return(a/b);
	}
	//
	double division(double a, double b) {
		return(a/b);
	}
}
//
class Class48 {
	public static void main(String args[]) {
		numero num = new numero();
		System.out.println("Aplicacion de los metodos de suma");
		num.suma();
		num.x = 6;
		num.y = 7;
		num.suma();
		//
		int s = num.suma(5,9);
		System.out.println("La suma es: "+s);
		double p = num.suma(5.99,9.99);
		System.out.println("La suma es: "+p);
		System.out.println("Aplicacion de los metodos de suma");
		//
		num.resta();
		num.x = 6;
		num.y = 7;
		num.resta();
		//
		int s1 = num.resta(5,9);
		System.out.println("La resta es: "+s1);
		double p1 = num.resta(5.99,9.99);
		System.out.println("La resta es: "+p1);
		num.producto();
		num.x = 6;
		num.y = 7;
		num.producto();
		//
		int s2 = num.producto(5,9);
		System.out.println("El producto es: "+s2);
		double p2 = num.producto(5.99,9.99);
		System.out.println("El producto es: "+p2);
		num.division();
		num.x = 7;
		num.y = 6;
		num.division();
		//
		int s3 = num.division(15,9);
		System.out.println("La division es: "+s3);
		double p3 = num.division(15.99,9.99);
		System.out.println("La division es: "+p3);
	}
}
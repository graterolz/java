class Figura {
	double dim1;
	double dim2;
	//
	Figura(double a,double b) {
		dim1 = a;
		dim2 = b;
	}
	//
	double area() {
		System.out.println("El area de la figura no esta definida");
		return 0;
	}
}
//
class Rectangulo extends Figura {
	Rectangulo(double a,double b) {
		super(a,b); 
	}
	//
	double area() {
		System.out.print("Dentro del metodo area para un ");
		System.out.println("rectangulo");
		return dim1*dim2;
	}
}
//
class Triangulo extends Figura {
	Triangulo(double a,double b) {
		super(a,b);
	}
	//
	double area() {
		System.out.print("Dentro del metodo area para un ");
		System.out.println("triangulo");
		return dim1*dim2/2;
	}
}
//
class Class31 {
	public static void main(String args[]) {
		Figura f = new Figura(10,10);
		Rectangulo r = new Rectangulo(9,5);
		Triangulo t = new Triangulo(10,8);
		Figura figref;
		figref = r;
		System.out.println("Area: "+figref.area());
		figref = t;
		System.out.println("Area: "+figref.area());
		figref = f;
		System.out.println("Area: "+figref.area());
	}
}
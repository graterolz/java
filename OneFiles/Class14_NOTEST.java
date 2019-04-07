class Triangulo {
	int base,altura;
	Triangulo() {
		base=10;
		altura=10;
	}
	//
	Triangulo(int b) {
		base=b;
		altura=b;
	}
	//
	Triangulo(int b, int a) {
		base=b;
		altura=a;
	}
}
//
class Class14 {
	public static void main(String args[]) {
		Triangulo tr1,tr2,tr3;
		tr1=new Triangulo();
		tr2=new Triangulo(15);
		tr3=new Triangulo(10,8);
		System.out.println("Area de Tr1: "+(tr1.base*tr1.altura));
		System.out.println("Area de Tr2: "+(tr2.base*tr2.altura));
		System.out.println("Area de Tr3: "+(tr3.base*tr3.altura));
	}
}
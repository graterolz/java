class Triangulo {
	int base,altura;
	//
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
class Class18 {
	public static void main(String args[]) {
		Triangulo fig;
		fig=new Triangulo();
		Triangulo fig2;
		fig2=new Triangulo(10);
		Triangulo fig3;
		fig3=new Triangulo(10,10);
		System.out.println("Area de Fig1: "+(fig.base*fig.altura));
		System.out.println("Area de Fig2: "+(fig2.base*fig2.altura));
		System.out.println("Area de Fig3: "+(fig3.base*fig3.altura));
	}

}
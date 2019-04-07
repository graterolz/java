class Padre {
	int a,b;
	Padre(int c,int d) {
		a=c;
		b=d;
	}
}
//
class Hijo extends Padre {
	int e;
	Hijo(int c,int d,int f) {
		super(c,d);
	}
}
//
class Class8 {
	public static void main(String args[]) {
		int a=10, b=20, f=30;
		Hijo p= new Hijo(a,b,f);
		System.out.println("Objeto creado");
		System.out.println(p.a+" "+p.b+" "+p.e);
	}
}
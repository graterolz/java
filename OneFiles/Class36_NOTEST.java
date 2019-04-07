class A {
	int i,j;
	//
	void mostrarij() {
		System.out.println("i y j: "+i+" "+j);
	}
}
//
class B extends A {
	int k;
	//
	void mostrark() {
		System.out.println("k: "+k);
	}
	//
	void sum() {
		System.out.println("i+j+k: "+(i+j+k));
	}
}
//
class C extends B {
	int m;
	void C() {
		i=5;
		j=6;
		k=7;
		m=8;
	}
}
//
class Class36 {
	public static void main(String args[]) {
		A superOb = new A();
		B subOb = new B();
		C subOb2 = new C();
		superOb.i = 10;
		superOb.j = 20;
		System.out.println("Contenido de superOb");
		superOb.mostrarij();
		System.out.println("");
		subOb.i = 7;
		subOb.j = 8;
		subOb.k = 9;
		System.out.println("Contenido de subOb");
		subOb.mostrarij();
		subOb.mostrark();
		System.out.println("");
		System.out.println("Suma de i, j y k en subOb: ");
		subOb.sum();
		System.out.println("Contenido de subOb 2");
		subOb2.mostrarij();
		subOb2.mostrark();
		System.out.println("");
		System.out.println("Suma de i, j y k en subOb 2: ");
		subOb2.sum();
	}
}
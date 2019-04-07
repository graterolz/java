class A {
	void A() {
		System.out.println("Dentro del constructor de A");
	} 
}
//
class B extends A {
	void B() {
		System.out.println("Dentro del constructor de B");
	}
}
//
class C extends B {
	void C() {
		System.out.println("Dentro del constructor de C"); 
	}
}
//
class Class20 {
	public static void main(String args[]) {
		C c = new C();
	}
}
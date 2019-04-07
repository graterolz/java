class A {
	static int n=0;
	String f(A x) {
		return "AA" + (x.n++);
	}
	//
	String f(B x) {
		return "AB" + (x.n--);
	}
}
//
class B extends A {
	String f(B x) {
		return "BB" + (x.n--);
	}
}
//
class Class1 {
	public static void main(String args[]) {
		A a = new A();
		A b = new B();
		System.out.println(a.f(b));
		System.out.println(b.f(b));
		System.out.println(a.f((B) b));
		System.out.println(b.f((B) b));
	}
}
class OverLoad {
	public static void main(String args[]) {
		OverLoadDemo ob = new OverLoadDemo();
		double result;
		ob.test();
		ob.test(10);
		ob.test(10,20);
		result = ob.test(123.25);
		System.out.println("Resultado de ob.test(123.25) es: "+result);
	}
}
//
class Class23 {
	void test() {
		System.out.println("Sin paràmetros");
	}
	//
	void test(int a) {
		System.out.println("Sobrecarga con un paràmetro");
		System.out.println("a: "+a);
	}
	//
	void test(int a,int b) {
		System.out.println("Sobrecarga con un paràmetro");
		System.out.println("a y b: "+a+" "+b);
	}
	//
	double test(double a) {
		return a*a;
	}
}
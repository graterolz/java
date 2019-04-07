class Test2 {
	int a;
	//
	Test2(int i) {
		a = i; 
	}
	//
	Test2 increDiez() {
		Test2 temp = new Test2(a+10);
		return temp;
	}
}
//
class Class27 {
	public static void main(String args[]) {
		Test2 ob1 = new Test2(2);
		Test2 ob2;
		ob2 = ob1.increDiez();
		System.out.println("ob1.a: "+ob1.a);
		System.out.println("ob2.a: "+ob2.a);
		ob2 = ob2.increDiez();
		System.out.println("ob2.a despues del segundo incremento: "+ob2.a); 
	}
}
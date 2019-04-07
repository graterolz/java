class numeros {
	int n1,n2;
	double n3,n4;
	//
	int suma(int x, int y) {
		return(x+y);
	}
	//
	int suma(int x) {
		return(x+x);
	}
	//
	void suma(double x,double y) {
		System.out.println("La suma es: "+(x+y));
	}
}
//
class Class22 {
	public static void main(String args[]) {
		numeros num = new numeros();
		int a=5,b=10;
		num.suma(3.15,5.65);
		int res=num.suma(a,b);
		int res2=num.suma(a);
		System.out.println("La suma es: "+res);
		System.out.println("La suma es: "+res2);
	}
}
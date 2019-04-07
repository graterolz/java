class Numero {
	double a;
	Numero(double i) {
		a = i;
	}
	//
	boolean Test(double j) {
		while (j>0){
			j--;
			if (j==0)
				return true; 
			else
				return false; 
		}
	}
}
//
class Class13 {
	public static void main(String args[]) {
		Numero Num1 = new Numero(5.22);
		Numero Num2 = new Numero(100);
		System.out.println("Es Entero: "+Num1.Test(Num1.a));
		System.out.println("Es Entero: "+Num2.Test(Num2.a));
	}
}
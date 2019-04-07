class SuperPar {
	int numero;
	//
	boolean Test(int j) {
		if (((j%2)==0)&&(j>0)) 
			return true; 
		else
			return false; 
	}
}
//
class SubMultiplo extends SuperPar {
	int numero;
	boolean Test2(int j)
	{
		if ((j%5)==0)
		return true;
	else
		return false;
	}
}
//
class Class21 {
	public static void main(String args[]) {
		SuperPar Num1 = new SuperPar();
		Num1.numero = 10;
		SubMultiplo Num2 = new SubMultiplo();
		Num2.numero = Num1.numero;
		System.out.println("Es Par y Mayor que Cero: "+Num1.Test(Num1.numero));
		if (Num1.Test(Num1.numero))
			System.out.println("Es Par, Mayor que Cero, Multiplo de Cinco: "+Num2.Test2(Num2.numero));
	}
}
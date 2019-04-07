class Numero {
	float num;
	void verificar() {
		if ((num%2)==0)
			System.out.println("Es Par");
		else
			System.out.println("Es Impar");
	}
	//
	void entero() {
		while (num>0)
			num = num - 1;
		if (num == 0) 
			System.out.println("Es Entero");
		else
			System.out.println("No es Entero");
	}
}
//
class Class6 {
	public static void main(String args[]) {
		Numero miNumero = new Numero();
		miNumero.num = 5;
		miNumero.verificar();
		miNumero.entero();
	}
}
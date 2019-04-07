class Comparar {
	int a, b;
	Comparar (int i, int j) {
		a = i;
		b = j;
	}
	//
	boolean equals (Comparar c) {
		if (c.a == a && c.b == b)
			return true;
		else
			return false;
	}
}
//
class Class5 {
	public static void main(String args[]) {
		Comparar objeto1 = new Comparar(2,3);
		Comparar objeto2 = new Comparar(2,3);
		System.out.println(objeto1.equals(objeto2));
	}
}
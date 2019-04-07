class Class4 {
	public static void main(String args[]) {
		Valores v1 = new Valores();
		Valores v2 = new Valores(8,9);
		System.out.println("Valores de x y y: "+v1.x+" y "+v1.y);
		System.out.println("Valores de x y y: "+v2.x+" y "+v2.y);
	}
}
//
class Valores {
	int x,y;
	Valores() {
		x = 0;
		y = 0;
	}
	//
	Valores(int a,int b) {
		x = a;
		y = b;
	}
}
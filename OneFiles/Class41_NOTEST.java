class Caja {
	double ancho;
	double alto;
	double largo;
	//
	void Caja(double w,double h,double d) {
		ancho = w;
		alto = h;
		largo = d; 
	}
	//
	void Caja() {
		ancho = -1;
		alto = -1;
		largo = -1;
	}
	//
	void Caja(double lado) {
		ancho = lado;
		alto = lado;
		largo = lado;
	}
	//
	double volumen() {
		return ancho*alto*largo;
	}
}
//
class Class41 {
	public static void main(String args[]) {
		Caja miCaja1 = new Caja(10,20,15);
		Caja miCaja2 = new Caja();
		Caja miCaja3 = new Caja(7);
		double vol;
		vol = miCaja1.volumen();
		System.out.println("El volumen de miCaja1 es: "+vol);
		vol = miCaja2.volumen();
		System.out.println("El volumen de miCaja2 es: "+vol);
		vol = miCaja3.volumen();
		System.out.println("El volumen de miCaja3 es: "+vol);
	}
}
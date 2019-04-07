class Caja {
	double ancho,alto,largo;
	//
	void volumen() {
		System.out.print("El volumen es: ");
		System.out.println(ancho*alto*largo);
	}
	//
	double volumen2() {
		return ancho*alto*largo;
	}
	//
	void Inicializar(double w,double h, double d) {
		ancho = w;
		alto = h;
		largo = d;
	}
}
//
class Class28 {
	public static void main(String args[]) {
		Caja miCaja = new Caja();
		double vol;
		miCaja.Inicializar(10,20,15);
		miCaja.volumen();
		vol = miCaja.volumen2();
		System.out.println("El volumen es: "+vol);
	}
}
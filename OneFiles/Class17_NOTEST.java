class Caja {
	double ancho;
	double alto;
	double largo;
	//
	Caja(double w,double h,double d) {
		System.out.println("Constructor de Caja");
		ancho = w;
		alto = h;
		largo = d;
	}
	//
	double volumen() {
		return ancho*alto*largo;
	}
}
//
class Class17 {
	public static void main(String args[]) {
		Caja miCaja;
		miCaja = new Caja(10,15,20);
		double vol;
		System.out.println("Ancho = "+miCaja.ancho);
		System.out.println("Alto = "+miCaja.alto);
		System.out.println("Largo = "+miCaja.largo);
		vol = miCaja.volumen();
		System.out.println("El volumen es: "+vol);
	}
}
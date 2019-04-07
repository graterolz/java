class Caja {
	double ancho;
	double alto;
	double largo;
	//
	Caja() {
		System.out.println("Constructor de Caja");
		ancho = 10;
		alto = 10;
		largo = 10;
	}
	//
	double volumen() {
		return ancho*alto*largo;
	}
}
//
class Class29 {
	public static void main(String args[]) {
		Caja miCaja;
		miCaja = new Caja();
		double vol;
		System.out.println("Ancho = "+miCaja.ancho);
		System.out.println("Alto = "+miCaja.alto);
		System.out.println("Largo = "+miCaja.largo);
		vol = miCaja.volumen();
		System.out.println("El volumen es: "+vol);
	}
}
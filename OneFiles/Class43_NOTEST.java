class rector {
	String cedula,apellidos,nombres;
}
//
class decanos extends rector {
	String facultad;
}
//
class secretaria extends rector{}
class directores extends decanos{}
class coordinadores extends directores{}
class profesores extends coordinadores {}
class estudiantes extends coordinadores {}
//
class Class43 {
	public static void main(String args[]) {
		rector rect=new rector();
		rect.cedula="12443786";
		rect.apellidos="Gonzalez";
		rect.nombres="Maria";
		System.out.println("Cedula: "+rect.cedula);
		System.out.println("Apellido(s): "+rect.apellidos);
		System.out.println("Nombre(s): "+rect.nombres);
		decanos dec=new decanos();
		dec.cedula="10410202";
		dec.apellidos="Perez";
		dec.nombres="Piter";
		dec.facultad="Fing";
		System.out.println("Cedula: "+dec.cedula);
		System.out.println("Apellido(s): "+dec.apellidos);
		System.out.println("Nombre(s): "+dec.nombres);
		System.out.println("Facultad: "+dec.facultad);
	}
}
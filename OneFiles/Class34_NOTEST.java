class Publicacion {
	String titulo;
	float precio;
	//
	void inicializar_pub(String t,float p) {
		titulo=t;
		precio=p;
	}
	void mostrar_pub() {
		System.out.println("Titulo: "+titulo);
		System.out.println("Precio: "+precio);
	}
}
//
class libro extends Publicacion {
	int pag,anio;
	float precio;
	//
	void inicializar_libro(int pg,int a,float p) {
		pag=pg;
		anio=a;
		precio=p;
	}
	//
	void mostrar_libro() {
		System.out.println("No. Paginas: "+pag);
		System.out.println("Año: "+anio);
		System.out.println("Precio: "+precio);
	}
}
//
class disco extends Publicacion {
	float duracion;
	int precio;
	//
	void inicializar_disco(float d,int p) {
		duracion=d;
		precio=p;
	}
	//
	void mostrar_disco() {
		System.out.println("Duracion: "+duracion);
		System.out.println("Precio: "+precio);
	}
}
//
class Class34 {
	public static void main(String args[]) {
		libro lib=new libro();
		disco dis=new disco();
		lib.inicializar_pub("Java",125);
		lib.mostrar_pub();
		lib.inicializar_libro(167,2012,145);
		lib.mostrar_libro();
		dis.inicializar_pub("PHP 5",67);
		dis.mostrar_pub();
		dis.inicializar_disco(234,123);
		dis.mostrar_disco();
	}
}
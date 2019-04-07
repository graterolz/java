class Animal {
	void habla() {
		System.out.println("No se que soy");
	}
}
//
class Perro extends Animal {
	void habla() {
		System.out.println("Guau");
	}
}
//
class Gato extends Animal {
	void habla() {
		System.out.println("Miau");
	}
}
//
class Class11 {
	public static void main(String[] args) {
		Animal animal = new Gato();
		animal.habla();
		animal=new Perro();
		animal.habla();
	}
}
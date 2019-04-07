class NewThread implements Runnable {
	String name;
	Thread t;
	//
	NewThread(String threadname) {
		name = threadname;
		t = new Thread(this,name);
		System.out.println("Nuevo hilo: "+t);
		t.start();
	}
	//
	public void run() {
		try {
			for(int i=5;i>0;i--) {
				System.out.println(name+": "+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Interrupcion del hilo: "+name);
		}
		System.out.println("Salida del hilo: "+name);
	}
}
//
class Class33 {
	public static void main(String args[]) {
		NewThread ob1 = new NewThread("Uno");
		NewThread ob2 = new NewThread("Dos");
		NewThread ob3 = new NewThread("Tres");
		System.out.println("El hilo Uno esta vivo: "+ob1.t.isAlive());
		System.out.println("El hilo Dos esta vivo: "+ob2.t.isAlive());
		System.out.println("El hilo Tres esta vivo: "+ob3.t.isAlive());
		try {
			System.out.println("Espera la finalizacion de los otros hilo");
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupcion del hilo Principal");
		}
		System.out.println("El hilo Uno esta vivo: "+ob1.t.isAlive());
		System.out.println("El hilo Dos esta vivo: "+ob2.t.isAlive());
		System.out.println("El hilo Tres esta vivo: "+ob3.t.isAlive());
		System.out.println("Salida del hilo principal");  
	}
}
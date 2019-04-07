class NewThread implements Runnable {
	String name;
	Thread t;
	//
	void NewThread(String threadname) {
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
class Class38 {
	public static void main(String args[]) {
		new NewThread("Uno");
		new NewThread("Dos");
		new NewThread("Tres");
		try {
			Thread.sleep(10000);
		}
		catch(InterruptedException e) {
			System.out.println("Interrupcion del hilo Principal");
		}
		System.out.println("Salida del hilo principal");  
	}
}
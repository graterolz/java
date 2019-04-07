class NewThread implements Runnable {
	String name;
	Thread t;
	boolean suspendFlag;
	//
	NewThread(String threadname) {
		name=threadname;
		t = new Thread(this,name);
		System.out.println("Nuevo hilo: "+t);
		suspendFlag=false;
		t.start();
	}
	//
	public void run() {
		try {
			for(int i=15;i>0;i--) {
				System.out.println(name+": "+i);
				Thread.sleep(200);
				synchronized(this) {
					while(suspendFlag) {
						wait();
					}
				}
			}
		}
		catch(InterruptedException e) {
			System.out.println("Interrupcion del hilo: "+name);
		}
		System.out.println("Salida del hilo: "+name);
	}
	//
	void mysuspend() {
		suspendFlag=true;
	}
	//
	synchronized void myresume() {
		suspendFlag=false;
		notify();
	}
}
//
class Class53 {
	public static void main(String args[]) {
		NewThread ob1 = new NewThread("Uno");
		NewThread ob2 = new NewThread("Dos");
		try {
			Thread.sleep(1000);
			ob1.mysuspend();
			System.out.println("Suspension del Hilo Uno");
			Thread.sleep(1000);
			ob1.myresume();
			System.out.println("Reanudacion del Hilo Uno");
			ob2.mysuspend();
			System.out.println("Suspension del Hilo Dos");
			Thread.sleep(1000);
			ob2.myresume();
			System.out.println("Reanudacion del Hilo Dos");
		}
		catch(InterruptedException e) {
			System.out.println("Interrupcion del hilo principal"); 
		}
		//
		try {
			System.out.println("Espera la finalizacion de los otros hilos");
			ob1.t.join();
			ob2.t.join();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupcion del hilo principal");
		}
		System.out.println("Salida del hilo principal"); 
	}
}
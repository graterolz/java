class clicker implements Runnable {
	int click=0;
	Thread t;
	private volatile boolean running=true;
	//
	public clicker(int p) {
		t = new Thread(this);
		t.setPriority(p);
	}
	//
	public void run() {
		while(running) {
			click++;
		}
	}
	//
	public void stop() {
		running = false;
	}
	//
	public void start() {
		t.start();
	}
}
//
class Class37 {
	public static void main(String args[]) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		clicker hi = new clicker(Thread.NORM_PRIORITY+2);
		clicker lo = new clicker(Thread.NORM_PRIORITY-2);
		lo.start();
		hi.start();
		try {
			Thread.sleep(10000);
		}
		catch(InterruptedException e) {
			System.out.println("Interrupcion del hilo principal");
		}
		lo.stop();
		hi.stop();
		try {
			hi.t.join();
			lo.t.join();
		}
		catch(InterruptedException e) {
			System.out.println("Captura de la excepcion InterruptedException");
		}
		System.out.println("Hilo de prioridad baja: "+lo.click);
		System.out.println("Hilo de prioridad alta: "+hi.click);
	}
}
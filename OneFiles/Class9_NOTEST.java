class Class9 {
	static void demoproc() {
		try {
			throw new NullPointerException("demo"); 
		}
		catch(NullPointerException e) {
			System.out.println("Capturada dentro de demoproc");
			throw e; 
		}
	}
	//
	public static void main(String args[]) {
		try {
			demoproc();
		}
		catch(NullPointerException e) {
			System.out.println("Recapturada "+e);
		}
	}
}
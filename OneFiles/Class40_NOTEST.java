import java.io.*;
class Class40{
	static int num_mayor;
	static int mayor(int a,int b,int c){
		if (a>b){
			num_mayor = a;
		}
		else{
			num_mayor = b;
		}

		if(a>c){
			num_mayor = a;
		}
		else{
			num_mayor = c;
		}

		if (b>c){
			num_mayor = b;
		}
		else{
			num_mayor = c;
		}		 
		return num_mayor;
	}
	//
	public static void main(String[] args){
		InputStreamReader irs = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (irs);
		try{
			System.out.print("Ingrese 1er Numero: ");
			int Num_1 = Integer.parseInt(br.readLine());
			System.out.print("Ingrese 2do Numero: ");
			int Num_2 = Integer.parseInt(br.readLine());
			System.out.print("Ingrese 3er Numero: ");
			int Num_3 = Integer.parseInt(br.readLine());
			System.out.println("Numero Mayor: "+mayor(Num_1,Num_2,Num_3));
		}
		catch(NumberFormatException nfe){
			System.out.println("Lo que Ha Ingresado NO es un Numero ENTERO, VERIFIQUE.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
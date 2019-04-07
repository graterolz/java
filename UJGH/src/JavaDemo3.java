import java.io.*;
import java.util.*;
public class JavaDemo3 {
	//
	public void J011_NumerosOrden() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int numero1,numero2,numero3;
		System.out.print("Ingrese primer numero: ");
		numero1 = Integer.parseInt(EntradaTeclado.readLine());
		System.out.print("Ingrese segundo numero: ");
		numero2 = Integer.parseInt(EntradaTeclado.readLine());
		
		if((numero1<numero2)||(numero1==numero2)){
			System.out.print("Ingrese tercer numero: ");
			numero3 = Integer.parseInt(EntradaTeclado.readLine());
			if((numero2<numero3)||(numero2==numero3)){ 
				System.out.print("Estan en orden ascendente.");
			}
			else{
				System.out.print("No estan en orden ascendente.");
			}
		}
		else{
			System.out.print("No estan en orden ascendente.");
		}
	}
	//
	public void J012_ContarNumeros() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int desde,hasta;
		System.out.print("Ingrese desde donde quiere contar: ");
		desde = Integer.parseInt(EntradaTeclado.readLine());
		System.out.print("Ingrese hasta donde quiere contar: ");
		hasta = Integer.parseInt(EntradaTeclado.readLine());
		if (desde<hasta){
			while(desde<=hasta){
				System.out.println(desde);
				desde++;
			}
		}
		else{
			while(hasta<=desde){
				System.out.println(desde);
				desde--;
			}
		}
	}
	//
	public void J013_SegundosMinutos() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		final int minuto = 60;
		int segundo;
		System.out.print("Ingresa cantidad a convertir en minutos: ");
		segundo = Integer.parseInt(EntradaTeclado.readLine());
		if (segundo>=0){
			float total_min = segundo / minuto;
			float total_seg = segundo % minuto;
			System.out.print("Tiene " + total_min + " minuto(s) con " + total_seg + " segundos.");
		}
		else{
			System.out.print("Solo calcula con valores mayor a cero (0).");
		}
	}
	//
	public void J014_AnioBisiesto() throws Exception{
		BufferedReader EntradaTeclado = new BufferedReader (new InputStreamReader(System.in));
		int anio;
		System.out.print("Ingresa el anio para saber si es bisiesto: ");
		anio = Integer.parseInt(EntradaTeclado.readLine());
		if (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0)){
			System.out.print("Anio Bisiesto.");
		}
		else {
			System.out.print("Anio no Bisiesto.");
		}
	}
	//
	public void J015_FechaHoraActual(){
		Calendar fecha = new GregorianCalendar();
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);
		System.out.println("Fecha Actual: " + dia + "/" + (mes+1) + "/" + anio);
		System.out.println("Hora Actual: " + hora + ":"+ minuto + ":" + segundo);
	}
}

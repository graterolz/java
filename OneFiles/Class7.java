import java.io.*;
import java.util.Scanner;

public class Class7 {
	public static void insercionDirecta(int v[]) {
		int tmp;
		int i, j;
		int N = v.length;
		for(i=1; i<N; i++) {
			tmp = v[i];
			for(j=i; (j>0 && (tmp < v[j-1])); j--)
				v[j] = v[j-1];
			v[j] = tmp;
		}
	}
	//
	public static void seleccionDirecta(int a[]) {
		for(int i=0; i<a.length -1; i++) {
			int current = a[i];
			int k=i;
			for(int j=i+1;j<=a.length-1;j++) {
				if(current>a[j]) {
					k=j;
					current = a[j];
				}
			}
			a[k]=a[i];
			a[i]=current;
		}
	}
	//
	public static void quickSort(int a[]) {
		quickSort(a, 0, a.length - 1);
	}
	//
	public static void swapReferences(int a[], int index1, int index2){
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
	//
	private static void quickSort(int a[], int low, int high){
		if (low >= high){
			return;
		}
		else{
			int middle = (low + high)/2;
			if(a[middle]< a[low])
				swapReferences(a, low, middle);
			if(a[high]< a[low])
				swapReferences(a, low, high);
			if(a[high]< a[middle])
				swapReferences(a, middle, high);
			int pivot = a[middle];
			int i, j;
			for(i = low, j = high ; ;){
				while(a[++i]< pivot);
				while(pivot < a[--j]);
				if(i < j)
					swapReferences(a, i, j);
				else
					break;
			}
			quickSort(a, low, i - 1);
			quickSort(a, i + 1, high);
		}
	}
	//
	public static void shellSort(int a[]){
		for(int gap = a.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)){
			for(int i = gap; i < a.length; i++){
				int tmp = a[i];
				int j;
				for(j = i; j >= gap && tmp <  a[j - gap] ; j -= gap){
					a[j] = a[j - gap];
				}
				a[j] = tmp;
			}
		}
	}
	//
	public static  void radixsort(int x[]) {
		if(x.length == 0){
			return;
		}
		int[][] np = new int[x.length][2];
		int[] q = new int[256];
		int i,j,k,l,f = 0;
		for(k=0;k<4;k++){
			for(i=0;i<(np.length-1);i++)
				np[i][1] = i+1;
			np[i][1] = -1;
			for(i=0;i<q.length;i++)
				q[i] = -1;
			for(f=i=0;i<x.length;i++){
				j = ((255<<(k<<3))&x[i])>>(k<<3);
				if(q[j] == -1)
					l = q[j] = f;
				else{
					l = q[j];
					while(np[l][1] != -1)
						l = np[l][1];
					np[l][1] = f;
					l = np[l][1];
				}
				f = np[f][1];
				np[l][0] = x[i];
				np[l][1] = -1;
			}
			for(l=q[i=j=0];i<256;i++)
				for(l=q[i];l!=-1;l=np[l][1])
					x[j++] = np[l][0];
		}
	}
	//
	public static void main(String[] args) throws IOException {
		BufferedReader entrada;
		entrada = new BufferedReader (new InputStreamReader(System.in));
		Scanner jsb = new Scanner(System.in);
		Scanner reader= new Scanner(System.in);
		int Longitud;
		System.out.println("***Ingrese Numero de Elementos*** ");
		Longitud=reader.nextInt();
		int [] Arreglo= new int[Longitud];
		char Resp = 'S', op;
		String aux;
		int Suma = 0;
		boolean Completo = false;
		System.out.println("\n\n Programacion Orientada a Objetos");
		do {
			Suma = 0;
			System.out.println("\n1.- Introducir Valores al Arreglo ");
			System.out.println("2.- Cacular Suma ");
			System.out.println("3.- Cacular Promedio ");
			System.out.println("4.- Ordenamiento por Insercion Directa ");
			System.out.println("5.- Ordenamiento por Seleccion Directa ");
			System.out.println("6.- Ordenacion Rapida ");
			System.out.println("7.- Ordenacion por Shell ");
			System.out.println("8.- Ordenamiento por RadixSort ");
			System.out.println("9.- Salir");
			System.out.print("\n\n Elija una Opcion : ");
			aux = entrada.readLine();
			op = aux.charAt(0);
			switch (op) {
				case '1':
					for (int i = 0; i <Arreglo.length ; i++) {
						System.out.print("Arreglo[" + i + "] =");
						Arreglo[i] = Integer.parseInt(entrada.readLine());
					}
					Completo = true;
					break;
				case '2':
					if (Completo) {
						System.out.println("Numeros ...\n");
						for (int i = 0; i <Arreglo.length; i++) {
							Suma = Suma + Arreglo[i];
						}
						System.out.println("\n La Suma es: "  + Suma);
					}
					else {
						System.out.println("\n Aun no has introducido Valores al Arreglo , Seleciona la Opcion 1 ");
					}
					break;
				case '3':
					if (Completo) {
						System.out.println("Promedio  ...\n");
						for (int i = 0; i <Arreglo.length; i++) {
							Suma = Suma + Arreglo[i];
							//System.out.println(Arreglo[i]);
						}
						System.out.println("\n La Suma es: "  + (Suma/Longitud));
					}
					else {
						System.out.println("\n Aun no has introducido Valores al Arreglo , Seleciona la Opcion 1 ");
					}
					break;
				case '4':
					if (Completo) {
						String pregunta1, pregunta2;
						int j;
						System.out.print("\n Deseas ver el recorrido de los numeros desordenados? S/N: ");
						pregunta1 = jsb.next();
						if(pregunta1.charAt(0)=='s' || pregunta1.charAt(0)=='S' || pregunta1.charAt(0)=='y' || pregunta1.charAt(0)=='Y')
						{    System.out.print("\n Los Numeros Ingresados Anteriormente son: ");
							for(j=0; j<Longitud; j++)
								System.out.print(Arreglo[j]+",");
						}
						insercionDirecta(Arreglo);
						System.out.print("\n El Ordenamiento por Insercion Directa es: ");
						for(j=0; j<Longitud; j++)
						{
							System.out.print(Arreglo[j]+",");
						}
						System.out.println("\n ");
					}
					else {
						System.out.println("\n Aun no has introducido Valores al Arreglo , Seleciona la Opcion 1 ");
					}
					break;
				case '5':
					if (Completo) {
						String pregunta1, pregunta2;
						int j;
						System.out.print("\n Deseas ver el recorrido de los numeros desordenados? S/N: ");
						pregunta1 = jsb.next();
						if(pregunta1.charAt(0)=='s' || pregunta1.charAt(0)=='S' || pregunta1.charAt(0)=='y' || pregunta1.charAt(0)=='Y') {
							System.out.print("\n Los Numeros Ingresados Anteriormente son: ");
							for(j=0; j<Longitud; j++)
								System.out.print(Arreglo[j]+",");
						}
						seleccionDirecta(Arreglo);
						System.out.print("\n El Ordenamiento por Seleccion Directa es: ");
						for(j=0; j<Longitud; j++) {
							System.out.print(Arreglo[j]+",");
						}
						System.out.println("\n ");
					}
					else {
						System.out.println("\n Aun no has introducido Valores al Arreglo , Seleciona la Opcion 1 ");
					}
					break;
				case '6':
					if (Completo) {
						String pregunta1, pregunta2;
						int j;
						System.out.print("\n Deseas ver el recorrido de los numeros desordenados? S/N: ");
						pregunta1 = jsb.next();
						if(pregunta1.charAt(0)=='s' || pregunta1.charAt(0)=='S' || pregunta1.charAt(0)=='y' || pregunta1.charAt(0)=='Y'){
							System.out.print("\n Los Numeros Ingresados Anteriormente son: ");
							for(j=0; j<Longitud; j++)
								System.out.print(Arreglo[j]+",");
						}
						quickSort(Arreglo);
						System.out.print("\n El Nuevo Orden por Ordenamiento Rapido es: ");
						for (int i=0;i < Longitud;i++) {
							System.out.print(Arreglo[i]+",");
						}
						System.out.println("\n ");
					}
					else {
						System.out.println("\n Aun no has introducido Valores al Arreglo , Seleciona la Opcion 1 ");
					}
					break;
				case '7':
					if (Completo) {
						String pregunta1, pregunta2;
						int j;
						System.out.print("\n Deseas ver el recorrido de los numeros desordenados? S/N: ");
						pregunta1 = jsb.next();
						if(pregunta1.charAt(0)=='s' || pregunta1.charAt(0)=='S' || pregunta1.charAt(0)=='y' || pregunta1.charAt(0)=='Y'){
							System.out.print("\n Los Numeros Ingresados Anteriormente son: ");
							for(j=0; j<Longitud; j++)
								System.out.print(Arreglo[j]+",");
						}
						shellSort(Arreglo);
						System.out.print("\n El Nuevo Orden por Ordenamiento Shell es: ");
						for (int i=0;i < Longitud;i++) {
							System.out.print(Arreglo[i]+",");
						}
						System.out.println("\n ");
					}
					else {
						System.out.println("\n Aun no has introducido Valores al Arreglo , Seleciona la Opcion 1 ");
					}
					break;
				case '8':
					if (Completo) {
						String pregunta1, pregunta2;
						int j;
						System.out.print("\n Deseas ver el recorrido de los numeros desordenados? S/N: ");
						pregunta1 = jsb.next();
						if(pregunta1.charAt(0)=='s' || pregunta1.charAt(0)=='S' || pregunta1.charAt(0)=='y' || pregunta1.charAt(0)=='Y'){
							System.out.print("\n Los Numeros Ingresados Anteriormente son: ");
							for(j=0; j<Longitud; j++)
								System.out.print(Arreglo[j]+",");
						}
						radixsort(Arreglo);
						System.out.print("\n El Nuevo Orden por Ordenamiento RadixSort es: ");
						for (int i=0;i < Longitud;i++) {
							System.out.print(Arreglo[i]+",");
						}
						System.out.println("\n ");
					}
					else {
						System.out.println("\n Aun no has introducido Valores al Arreglo , Seleciona la Opcion 1 ");
					}
					break;
				case '9':
					System.out.println("\n ********Fin del Programa********");
					Resp = 'N';
					break;
				default:
					System.out.println("\n Opcion fuera de rango !!");
			}
		} while (Resp == 'S' || Resp == 's');
	}
}
import java.util.*;
public class Class46 {
	public static void main(String[] args) {
		Scanner leer=new Scanner(System.in);
		int cuantos=0, total=0,promedio;
		System.out.println("ingrese cantidad de numeros a utilizar");
		cuantos=leer.nextInt();
		int numeros[]=new int[cuantos];
		int ordenar[]=new int[cuantos];
		for(int i=0;i<cuantos;i++) {
			System.out.println("ingrese valor "+(i+1));
			numeros[i]=leer.nextInt();
			total+=numeros[i];
		}
		promedio=total/cuantos;
		ordenar=numeros;
		for (int i = 0; i < ordenar.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < ordenar.length; j++) {
				if (ordenar[j] < ordenar[min]) {
					min = j;
				}
			}
			if (i != min) {
				int aux= ordenar[i];
				ordenar[i] = ordenar[min];
				ordenar[min] = aux;
			}
		}
		System.out.println("Numeros Ordenados con seleccion directa");
		for(int i=0;i<cuantos;i++) {
			System.out.println(ordenar[i]);
		}
		ordenar=numeros;
		for (int i=1; i<ordenar.length; i++) {
			int aux = ordenar[i];
			int j;
			for (j=i-1; j>=0 && ordenar[j]>aux; j--)
				ordenar[j+1] = ordenar[j];
			ordenar[j+1] = aux;
		}
		System.out.println("Numeros Ordenados con insercion directa");
		for(int i=0;i<cuantos;i++) {
			System.out.println(ordenar[i]);
		}
		ordenarQuicksort(ordenar,0,cuantos-1);
		System.out.println("Numeros Ordenados con Quicksort(ordenamiento rapido)");
		for(int i=0;i<cuantos;i++) {
			System.out.println(ordenar[i]);
		}
		ordenar=numeros;
		shellSort(ordenar);
		System.out.println("Numeros Ordenados con Shell");
		for(int i=0;i<cuantos;i++) {
			System.out.println(ordenar[i]);
		}
		System.out.println("Suma Total de los Numeros: "+total);
		System.out.println("Promedio de los Numeros: "+promedio);
	}
	//
	public static void ordenarQuicksort(int[] vector, int primero, int ultimo){
		int i=primero, j=ultimo;
		int pivote=vector[(primero+ultimo)/2];
		int auxiliar;
		do {
			while(vector[i]<pivote) i++;
			while(vector[j]>pivote) j--;
			if (i<=j){
				auxiliar=vector[j];
				vector[j]=vector[i];
				vector[i]=auxiliar;
				i++;
				j--;
			}
		} while (i<=j);
		if(primero<j) ordenarQuicksort(vector,primero, j);
		if(ultimo>i) ordenarQuicksort(vector,i, ultimo);
	}
	//
	public static void shellSort(int[] a) {
		for (int increment = a.length / 2; increment > 0;increment = (increment == 2 ? 1 : (int) Math.round(increment / 2.2))) {
			for (int i = increment; i < a.length; i++) {
				for (int j = i; j >= increment && a[j - increment] > a[j]; j -= increment) {
					int temp = a[j];
					a[j] = a[j - increment];
					a[j - increment] = temp;
				}
			}
		}
	}
}
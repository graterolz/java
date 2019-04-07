import java.util.Scanner;
public class Class51 {
	static int a[] = new int[100];
	static int n;
	//
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Ingresa el numero de elementos: ");
		n = reader.nextInt();
		for (int i=0;i<n;i++) {
			System.out.println("Introduce el valor del elemento No. "+(i+1)+":");
			a[i]=reader.nextInt();
		}
		pantalla();
	}
	//
	public static void pantalla() {                 
		Scanner reader = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("1) suma de numeros");
		System.out.println("2) promedio de numeros");
		System.out.println("3) ordenamiento por insercion directa");
		System.out.println("4) ordenamiento por seleccion directa");
		System.out.println("5) ordenacion rapida");
		System.out.println("6) ordenamiento por shell");
		System.out.println("7) ordenamiento por radixsort");
		System.out.println("para salir del programa presiona otro numero");
		System.out.println("Ingresa tu seleccion: ");
		System.out.println(" ");
		int opcion = reader.nextInt();
		switch(opcion) {
			case 1:
				suma(a, n);
				pantalla();
				break;
			case 2:
				promedio(a, n);
				pantalla();
				break;
			case 3:
				inserciond(a, n);
				pantalla();
				break;
			case 4:
				selecciond(a, n);
				pantalla();
				break;
			case 5:
				quick_srt(a, 0, n-1);
				verArray();
				pantalla();
				break;
			case 6:
				Shell_Sort(a, n);
				verArray();
				pantalla();
				break;
			case 7:
				Radix_Sort(a, n);
				verArray();
				pantalla();
				break;
		}
	}
	//
	public static void suma(int a[], int n) {
		int suma=0;
		for(int i=0;i<n;i++) {
			suma+= a[i];
		}
		System.out.println("respuesta:");
		System.out.println("suma: "+suma);
	}
	//
	public static void promedio(int a[], int n) {
		int suma=0;
		for(int i=0;i<n;i++) {
			suma+= a[i];
		}  
		System.out.println("respuesta:");
		System.out.println("promedio: "+suma/n);
	}
	//
	public static void inserciond(int a[], int n) {
		for (int i = 1; i < n; i++) {
			int v = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > v) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = v;
		}
		System.out.println("respuesta:");
		for( int i=0;i<n;i++) {
			System.out.println(a[i]);
		}    
	}
	//
	public static void selecciond(int a[],int  n) {
		for (int i = 0; i < n - 1; i++) {
			int posMin = i;
			for (int j = i+1; j < n; j++) {
				if (a[j] < a[posMin]) {
					posMin = j;
				}
			}
			int iaux = a[i];
			a[i] = a[posMin];
			a[posMin] = iaux;
		}
		System.out.println("respuesta:");
		for( int i=0;i<n;i++) {
			System.out.println(a[i]);
		}
	}
	//
	public static void quick_srt(int array[],int low, int n) {
		int lo = low;
		int hi = n;
		if (lo >= n) {
			return;
		}
		int mid = array[(lo + hi) / 2];
		while (lo < hi) {
			while (lo<hi && array[lo] < mid) {
				lo++;
			}
			while (lo<hi && array[hi] > mid) {
				hi--;
			}
			if (lo < hi) {
				int T = array[lo];
				array[lo] = array[hi];
				array[hi] = T;
			}
		}
		if (hi < lo) {
			int T = hi;
			hi = lo;
			lo = T;
		}
		quick_srt(array, low, lo);
		quick_srt(array, lo == low ? lo+1 : lo, n);
	}
	//
	static void Shell_Sort(int[] a, int n) {
		int t = 0;
		if (n % 2 == 0){
			t = n >> 1;
		}
		else{
			t = (n >> 1) + 1;
		}
		while (t >= 1) {
			for (int i = t,temp = 0; i < n; i++) {
				for (int j = i - t; j >= 0; j =j - t) {
					if (a[j] > a[j + t]) {
						temp = a[j];
						a[j] = a[j + t];
						a[j + t] = temp;   
					}
				}
			}
			if (t == 1)
				break;
			if (t % 2 == 0)
				t = t >> 1;
			else
				t = (t >> 1) + 1;
		}
	}
	//
	public static void Radix_Sort(int[] arr, int n) {
		if(n == 0)
			return;
		int[][] np = new int[n][2];
		int[] q = new int[0x100];
		int i,j,k,l,f = 0;
		for(k=0;k<4;k++){
			for(i=0;i<(np.length-1);i++)
				np[i][1] = i+1;
			np[i][1] = -1;
			for(i=0;i<q.length;i++)
				q[i] = -1;
			for(f=i=0;i<n;i++){
				j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
				if(q[j] == -1)
					l = q[j] = f;
				else{
					l = q[j];
					while(np[l][1] != -1){
						l = np[l][1];
					}
					np[l][1] = f;
					l = np[l][1];
				}
				f = np[f][1];
				np[l][0] = arr[i];
				np[l][1] = -1;
			}
			for(l=q[i=j=0];i<0x100;i++){
				for(l=q[i];l!=-1;l=np[l][1]){
					arr[j++] = np[l][0];
				}
			}
		}
	}
	//
	public static void verArray() {
		System.out.println("respuesta:");
		for(int i=0;i<n;i++) {
			System.out.println(a[i]);
		}
	}
}
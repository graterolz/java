import java.util.*;
class Class3 {
	static void display(int array[]) {
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println("");  
	}
	//
	public static void main(String args[]) {
		int array[] = new int[10];
		for(int i=0;i<10;i++)
			array[i] = -3*i;
		System.out.println("Contenido original del array");
		display(array);
		Arrays.sort(array);
		System.out.println("Contenido ordenado del array");
		display(array);
		Arrays.fill(array,2,6,-1);
		System.out.println("Contenido rellenado con fill");
		display(array);
		System.out.println("Contenido reordenado del array");
		Arrays.sort(array);
		display(array);
		System.out.println("El valor -9 està en la posicion ");
		int index = Arrays.binarySearch(array,-9);
		System.out.println(index);
	}
}
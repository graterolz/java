public class Ordenamiento {
	public static void main(String[] args) {
		String a[] = {"nuestra","aca","casa","bola","bom","acero","acar","su","suma","ramon", "maria", "juan"};
		java.util.ArrayList Lista = new java.util.ArrayList();
		for(int i = 0; i < a.length; i++){
			Lista.add(a[i]);
		}
		java.util.Collections.sort(Lista);
		java.util.Iterator i = Lista.iterator();
		while(i.hasNext()){
			System.out.println("Elemento del arreglo: "+i.next());
		}
	}
}
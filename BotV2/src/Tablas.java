public class Tablas {
	Excel E = new Excel();
	General G = new General();
	//
	public int CantidadTotalPalabras = E.CantidadCeldasExcel(G.vPestanasArchivo[0],"A");
	int CantidadTotalEntradas = E.CantidadCeldasExcel(G.vPestanasArchivo[1],"A");;
	int CantidadTotalSalidas = E.CantidadCeldasExcel(G.vPestanasArchivo[2],"A");
	int CantidadTotalErrores = E.CantidadCeldasExcel(G.vPestanasArchivo[3],"A");
	//
	String IdPalabra[] = new String [CantidadTotalPalabras];
	public String Palabra[] = new String[CantidadTotalPalabras];
	//
	String Combinacion[] = new String [CantidadTotalEntradas];
	//
	String IdEntrada[] = new String [CantidadTotalSalidas];
	String IdSalida[] = new String [CantidadTotalSalidas];
	//
	String IdError[] = new String [CantidadTotalErrores];
	String EntradaError[] = new String [CantidadTotalErrores];
	//
	void GeneraPalabras(){
		//Palabras
		for(int i=0;i<CantidadTotalPalabras;i++){ 
			IdPalabra[i] = E.LeeExcel(G.vPestanasArchivo[0],"B"+""+(i+1));
			Palabra[i] = E.LeeExcel(G.vPestanasArchivo[0],"C"+""+(i+1)); 
		}
		//Entradas
		for(int i=0;i<CantidadTotalEntradas;i++){
			Combinacion[i] = E.LeeExcel(G.vPestanasArchivo[1],"A"+""+(i+1)); 
		}
		//Salidas
		for(int i=0;i<CantidadTotalSalidas;i++){
			IdEntrada[i] = E.LeeExcel(G.vPestanasArchivo[2],"A"+""+(i+1));
			IdSalida[i] = E.LeeExcel(G.vPestanasArchivo[2],"B"+""+(i+1));
		}
	}
	//
	void GeneraErrores(){
		//Errores
		for(int i=0;i<CantidadTotalErrores;i++){
			IdError[i] = E.LeeExcel(G.vPestanasArchivo[3],"A"+""+(i+1)); 
			EntradaError[i] = E.LeeExcel(G.vPestanasArchivo[3],"B"+""+(i+1)); 
		}
	}
	//
	void OrdenaExcel(){
		String GuardaPalabra[] = new String[CantidadTotalPalabras];
		int Letra = (int) 'A';
		char[] Abecedario = new char[26];
		String LetraString = "";
		int w = 0;
		for(int i = 0; i < Abecedario.length; i++){
			Abecedario[i] = (char) (Letra + i);
			LetraString = Abecedario[i] + "";
			int CantidadRegistros = E.CantidadCeldasExcel(G.vPestanasArchivo[0],LetraString);
			for(int x=0;x<CantidadRegistros;x++){
				if (w != CantidadTotalPalabras){
					GuardaPalabra[w] = E.LeeExcel(G.vPestanasArchivo[0],LetraString+""+(x+1)); 
					w++; 
				}
			}
		}
		w = 0;
		java.util.ArrayList Lista = new java.util.ArrayList(); 
		for(int z = 0; z < GuardaPalabra.length; z++){
			Lista.add(GuardaPalabra[z]);
		}
		java.util.Collections.sort(Lista);
		java.util.Iterator i = Lista.iterator();
		int aa = 0;
		while(i.hasNext()){
			GuardaPalabra[aa] = i.next().toString();
			aa++;
		}
		for(int xx = 0; xx < Abecedario.length; xx++){
			Abecedario[xx] = (char) (Letra + xx);
			LetraString = Abecedario[xx] + "";
			int CantidadRegistros = E.CantidadCeldasExcel(G.vPestanasArchivo[0],LetraString);
			
			for(int x=0;x<CantidadRegistros;x++){
				if (w != CantidadTotalPalabras){
					E.EscribeExcel(G.vPestanasArchivo[4],xx,x,GuardaPalabra[w],"S");
					w++;
				}
			}
		}
	}
	//
	/*
	public static void main(String[] args) {
		Tablas U = new Tablas();
		U.GeneraPalabras();
		U.OrdenaExcel();
	}
	*/
}
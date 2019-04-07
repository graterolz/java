public class Combinaciones {
	public static void main (String[] args) {
		String var[] = {"A","B","C","D"};
		int cantidad_variable = 4;
		for(int i=0;i<=(cantidad_variable-1);i++){
			for(int j=0;j<=(cantidad_variable-1);j++){
				for(int k=0;k<=(cantidad_variable-1);k++){
					for(int w=0;w<=(cantidad_variable-1);w++){
						if (i!=j && i!=k && i!=w){
							if (j!=k && j!=i && j!=w){
								if (k!=i && k!=j && k!=w){
									if (w!=i && w!=j && w!=k){	
										System.out.println(var[i]+" "+var[j]+" "+var[k]+" "+var[w]);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
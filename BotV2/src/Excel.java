public class Excel{
	General G = new General();
	//
	public String LeeExcel(String pNombreHoja, String pNombreColumna){
		String ContenidoCelda = new String();
		try{
			jxl.Workbook workbook = jxl.Workbook.getWorkbook(new java.io.File(G.vNombresArchivo[0]));
			jxl.Sheet sheet = workbook.getSheet(pNombreHoja);
			jxl.Cell cell = sheet.getCell(pNombreColumna);
			ContenidoCelda = cell.getContents();
			//System.out.println("Data: " + cellData);
			workbook.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return ContenidoCelda;
	}
	//
	public void EscribeExcel(String sheet_name,int column, int row, String value,String pTipo){
		try{
			jxl.Workbook target_workbook = jxl.Workbook.getWorkbook(new java.io.File(G.vNombresArchivo[0]));
			jxl.write.WritableWorkbook workbook = jxl.Workbook.createWorkbook(new java.io.File(G.vNombresArchivo[0]),target_workbook);
			target_workbook.close();
			jxl.write.WritableSheet sheet = workbook.getSheet(sheet_name);
			switch (pTipo) {
				case "S":
					jxl.write.Label number = new jxl.write.Label(column, row, value);
					sheet.addCell(number);
					break;
				case "D":
					double num = Double.parseDouble(value);
					jxl.write.Number number2 = new jxl.write.Number(column, row, num);
					sheet.addCell(number2);
					break;
			}
			workbook.write();
			workbook.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	//
	public int CantidadCeldasExcel(String pNombreHoja, String pNombreColumna){
		String ContenidoCelda = new String();
		int Cantidad = 0; 
		boolean Bandera = true;
		int i=1;
		while(Bandera==true){
			try{
				jxl.Workbook workbook = jxl.Workbook.getWorkbook(new java.io.File(G.vNombresArchivo[0]));
				jxl.Sheet sheet = workbook.getSheet(pNombreHoja);
				jxl.Cell cell = sheet.getCell(pNombreColumna + "" + i); 
				ContenidoCelda = cell.getContents().trim();
				if (ContenidoCelda.equals("")){
					Bandera = false;
				}
				else{
					Cantidad++;
				}
				//System.out.println(ContenidoCelda);
				workbook.close();
			}
			catch(Exception e){
				Bandera = false;
			}
			i++;
		}
		return Cantidad;
	}
	//
	public int CantidadLetraExcel(String pNombreHoja, String pNombreColumna,String pLetra){
		String ContenidoCelda = new String();
		int Cantidad = 0; 
		boolean Bandera = true;
		int i=1;
		while(Bandera==true){
			try{
				jxl.Workbook workbook = jxl.Workbook.getWorkbook(new java.io.File(G.vNombresArchivo[0]));
				jxl.Sheet sheet = workbook.getSheet(pNombreHoja);
				jxl.Cell cell = sheet.getCell(pNombreColumna + "" + i); 
				ContenidoCelda = cell.getContents().trim();
				if (ContenidoCelda.equals("")){
					Bandera = false;
				}
				else{
					//System.out.println(ContenidoCelda.charAt(0) + " - " + pLetra);
					if (ContenidoCelda.charAt(0) == pLetra.charAt(0)){
						Cantidad++;
					}
					//Cantidad++;
				}
				//System.out.println(ContenidoCelda);
				workbook.close();
			}
			catch(Exception e){
				Bandera = false;
			}
			i++;
		}
		return Cantidad;
	}
	//
	/*
	public static void main(String[] args) {
		Excel E = new Excel();
		int CantidadRegistros = E.CantidadLetraExcel("Palabras","A","F");
		System.out.println(CantidadRegistros); 
	}
	*/
}
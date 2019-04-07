package PaqueteClases;

import javax.swing.*;

class Opciones {
	public void Opciones() {
		String[] items = {"Consulta", "Insertar", "Modificar", "Eliminar"};
		String opc = (String) JOptionPane.showInputDialog(null, null, "Elija una opcion", JOptionPane.PLAIN_MESSAGE, null, items, items[0]);
		if(opc!=null) {
			switch(opc) {
				case "Consulta": new Consulta().Consulta(); break;
				case "Insertar": new Insertar().Insertar(); break;
				case "Modificar": new Modificar().Modificar(); break;
				case "Eliminar": new Eliminar().Eliminar(); break;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Gracias por usar este programa.");
		}
	}
	//
	public static void main(String[]args) {
		new Opciones().Opciones();
	}
}
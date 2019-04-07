import javax.swing.*;
class Otros10 {
	public static void main (String args[]) {
		int j;
		int px,py,i,r,t;
		JTextArea salida=new JTextArea();
		String a[][]=new String [3][3];
		while(true) {
			salida.append("\t 0 \t 1 \t 2 \n");
			for(i=0;i<3;i++) {
				for(r=0;r<3;r++) {
					a[i][r]="-";
				}
			}
			for(t=0;t<5;t++) {
				JOptionPane.showMessageDialog(null, "TURNO DE EL JUGADOR #1");
				px=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'x'"));
				if(px>2) {
					while (px>2){
						JOptionPane.showMessageDialog(null, "Este valor no es valido\n Intente con un numero de 0 a 2");
						px=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'x'"));
					}
				}
				py=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'y'"));
				if(py>2) {
					while (py>2) {
						JOptionPane.showMessageDialog(null, "Este valor no es valido\n Intente con un numero de 0 a 2");
						py=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'y'"));
					}
				}
				else if ((a[px][py]=="O")||(a[px][py]=="X")) {
					while((a[px][py]=="O")||(a[px][py]=="X")) {
						JOptionPane.showMessageDialog(null,"La casilla ya esta OCUPADA \n Intenta en otra");
						px=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'x'"));
						if(px>2) {
							while (px>2) {
								JOptionPane.showMessageDialog(null, "Este valor no es valido\n Intente con un numero de 0 a 2");
								px=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'x'"));
							}
						}
						py=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'y'"));
						if(py>2) {
							while (py>2) {
								JOptionPane.showMessageDialog(null, "Este valor no es valido\n Intente con un numero de 0 a 2");
								py=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'y'"));
							}
						}
					}
					a[px][py]="O";
					for(i=0;i<3;i++) {
						salida.append(""+i);
						for(r=0;r<3;r++) {
							salida.append("\t"+a[i][r]);
						}
						salida.append("\n");
					}
					salida.append("__________________________________________\n");
					JOptionPane.showMessageDialog(null,salida);
					if((a[0][0]=="O"&&a[0][1]=="O"&&a[0][2]=="O")||(a[1][0]=="O"&&a[1][1]=="O"&&a[1][2]=="O")||
						(a[2][0]=="O"&&a[2][1]=="O"&&a[2][2]=="O")||(a[0][0]=="O"&&a[1][0]=="O"&&a[2][0]=="O")||
						(a[0][1]=="O"&&a[1][1]=="O"&&a[2][1]=="O")||(a[0][2]=="O"&&a[1][2]=="O"&&a[2][2]=="O")||
						(a[0][0]=="O"&&a[1][1]=="O"&&a[2][2]=="O")||(a[2][0]=="O"&&a[1][1]=="O"&&a[0][2]=="O")) {
						JOptionPane.showMessageDialog(null, "EL JUGADOR # 1 ¡¡¡¡¡HA GANADO!!!!!");
						JOptionPane.showMessageDialog(null, salida);
						System.exit(0);
					}
					if((a[0][0]=="O"||a[0][0]=="X")&&(a[0][1]=="O"||a[0][1]=="X")&&(a[0][2]=="O"||a[0][2]=="X")
						&&(a[1][0]=="O"||a[1][0]=="X")&&(a[1][1]=="O"||a[1][1]=="X")&&(a[1][2]=="O"||a[1][2]=="X")
						&&(a[2][0]=="O"||a[2][0]=="X")&&(a[2][1]=="O"||a[2][1]=="X")&&(a[2][2]=="O"||a[2][2]=="X")) {
						JOptionPane.showMessageDialog(null, "Nadie ha ganado \n Por lo tanto es un empate");
						JOptionPane.showMessageDialog(null, salida);
						System.exit(0);
					}
					JOptionPane.showMessageDialog(null, "TURNO DE EL JUGADOR #2");
					px=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'x'"));
					if(px>2) {
						while (px>2) {
							JOptionPane.showMessageDialog(null, "Este valor no es valido\n Intente con un numero de 0 a 2");
							px=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'x'"));
						}
					}
					py=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'y'"));
					if(py>2){
						while (py>2){
							JOptionPane.showMessageDialog(null, "Este valor no es valido\n Intente con un numero de 0 a 2");
							py=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'y'"));
						}
					}
					if ((a[px][py]=="O")||(a[px][py]=="X")) {
						while((a[px][py]=="O")||(a[px][py]=="X")) {
							JOptionPane.showMessageDialog(null,"La casilla ya esta OCUPADA \n Intenta en otra");
							px=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'x'"));
							if(px>2) {
								while (px>2) {
									JOptionPane.showMessageDialog(null, "Este valor no es valido\n Intente con un numero de 0 a 2");
									px=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'x'"));
								}
							}
							py=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'y'"));
							if(py>2) {
								while (py>2) {
									JOptionPane.showMessageDialog(null, "Este valor no es valido\n Intente con un numero de 0 a 2");
									py=Integer.parseInt(JOptionPane.showInputDialog("En que ubicacion  desea tirar para el eje de las 'y'"));
								}
							}
						}
					}
					a[px][py]="X";
					for(i=0;i<3;i++) {
						salida.append(""+i);
						for(r=0;r<3;r++) {
							salida.append("\t"+a[i][r]);
						}
						salida.append("\n");
					}
					salida.append("__________________________________________\n");
					JOptionPane.showMessageDialog(null,salida);
					if((a[0][0]=="X"&&a[0][1]=="X"&&a[0][2]=="X")||(a[1][0]=="X"&&
						a[1][1]=="X"&&a[1][2]=="X")||(a[2][0]=="X"&&a[2][1]=="X"&&a[2][2]=="X")||
						(a[0][0]=="X"&&a[1][0]=="X"&&a[2][0]=="X")||(a[0][1]=="X"&&a[1][1]=="X"&&a[2][1]=="X")||
						(a[0][2]=="X"&&a[1][2]=="X"&&a[2][2]=="X")||(a[0][0]=="X"&&a[1][1]=="X"&&a[2][2]=="X")||
						(a[2][0]=="X"&&a[1][1]=="X"&&a[0][2]=="X")) {
						JOptionPane.showMessageDialog(null, "EL JUGADOR # 2 ¡¡¡¡¡HA GANADO!!!!!!");
					JOptionPane.showMessageDialog(null, salida);
					System.exit(0);
				}
			}
		}
	}
}
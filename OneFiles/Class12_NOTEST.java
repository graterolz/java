import java.util.*;
import java.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Class12 extends JFrame {
	public Class12() {
		JButton boton = new JButton ("Pulsame");
		MiClase elListener = new MiClase();
		boton.addActionListener (elListener);
	}
	//
	public void pulsado() {
		System.out.println("Pulsado el botón");
	}
	//
	public class MiClase implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			pulsado();
		}
	}
}
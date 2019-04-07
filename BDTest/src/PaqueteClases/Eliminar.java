package PaqueteClases;

import java.awt.*;
import java.sql.*;
import PaqueteConexionMySQL.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Eliminar {
	Connection mysql = new ConexionMySQL().Conectar();
	public void Eliminar() {
		JPanel usuario = new JPanel();
		usuario.setLayout(new GridLayout(2, 1));
		JTextField tf = new JTextField(10);
		usuario.add(new JLabel("Ingrese el usuario a eliminar: ", JLabel.CENTER));
		usuario.add(tf);
		if(JOptionPane.showConfirmDialog(null, usuario, "Formulario de eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)==JOptionPane.OK_OPTION) {
			if(!tf.getText().equals("")) {
				if(JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar al usuario "+tf.getText(), "Confirmacion de eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION) {
					try {
						PreparedStatement ps = mysql.prepareStatement("DELETE FROM users WHERE usuario = '"+tf.getText()+"'");
						if(ps.executeUpdate()>0) {
							JOptionPane.showMessageDialog(null, "Usuario Eliminado satisfactoriamente");
						}
						else {
							JOptionPane.showMessageDialog(null, "El usuario especificado no existe");
						}
					}
					catch(SQLException | HeadlessException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Porfavor especifique el usuario a eliminar");
			}
			
			Eliminar();
		} else {
			new Opciones().Opciones();
		}
	}
}
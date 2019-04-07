package PaqueteClases;

import PaqueteConexionMySQL.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Insertar {
	Connection mysql = new ConexionMySQL().Conectar();
	public void Insertar() {
		JPanel datos = new JPanel();
		datos.setLayout(new GridLayout(3, 2));
		JTextField tf = new JTextField(10);
		JPasswordField[] pf = new JPasswordField[10];
		pf[0] = new JPasswordField(10);
		datos.add(new JLabel("Usuario ", JLabel.RIGHT));
		datos.add(tf);
		datos.add(new JLabel("Contrasena ", JLabel.RIGHT));
		datos.add(pf[0]);
		if(JOptionPane.showConfirmDialog(null, datos, "Formulario de Insercion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)==JOptionPane.OK_OPTION) {
			if(tf.getText().equals("") || pf[0].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Porfavor llene todos los campos");
			}
			else {
				try {
					PreparedStatement ps = mysql.prepareStatement("INSERT INTO users (usuario, contrasena) VALUES (?, ?)");
					ps.setString(1, tf.getText());
					ps.setString(2, pf[0].getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Usuario registrado satisfactoriamente");
				}
				catch (SQLException e) {
					if(e.getErrorCode()==1062) {
						JOptionPane.showMessageDialog(null, "Disculpe, el usuario insertado ya existe");
					}
					else if(e.getErrorCode()==1366) {
						JOptionPane.showMessageDialog(null, "Disculpe, el campos contraseña es invalido");
					}
					else {
						JOptionPane.showMessageDialog(null, e+"Codigo "+e.getErrorCode()+"Mensaje "+e.getLocalizedMessage());
					}
				}
			}
			Insertar();
		}
		else {
			new Opciones().Opciones();
		}
	}
}
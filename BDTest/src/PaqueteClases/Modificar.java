package PaqueteClases;

import java.sql.*;
import PaqueteConexionMySQL.*;
import javax.swing.*;
import java.awt.*;

public class Modificar {
	Connection mysql = new ConexionMySQL().Conectar();
	public void Modificar() {
		JTextField[] tf = {new JTextField(5), new JTextField(5)};
		if(JOptionPane.showConfirmDialog(null, tf[0], "Usuario a modificar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION) {
			String uam = tf[0].getText();
			try {
				ResultSet rs = mysql.createStatement().executeQuery("SELECT * FROM users WHERE usuario = '"+uam+"'");
				if(tf[0].getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Porfavor espefique un usuario");
				}
				else if(rs.next()==false) {
					JOptionPane.showMessageDialog(null, "Disculpe, el usuario especificado no existe");
				}
				else {
					while(true) {
						if(JOptionPane.showConfirmDialog(null, tf[1], "Contraseña del usuario a modificar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE)==JOptionPane.OK_OPTION) {
							if(tf[1].getText().equals("")) {
								JOptionPane.showMessageDialog(null, "Porfavor ingrese la contraseña del usuario a modificar");
							}
							else if(tf[1].getText().equals(rs.getString("contrasena"))) {
								JPanel datos = new JPanel();
								JPasswordField[] pf = {new JPasswordField(5), new JPasswordField(5)};
								datos.setLayout(new GridLayout(3,2));
								datos.add(new JLabel("Usuario ", JLabel.RIGHT));
								datos.add(tf[0]);
								datos.add(new JLabel("Contrasena ", JLabel.RIGHT));
								datos.add(pf[0]);
								while(true) {
									if(JOptionPane.showConfirmDialog(null, datos, "Formulario de modificacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)==JOptionPane.OK_OPTION) {
										try {
											ResultSet rs2 = mysql.createStatement().executeQuery("SELECT * FROM users WHERE usuario = '"+tf[0].getText()+"'");
											if(tf[0].getText().equals("") || pf[0].getText().equals("")) {
												JOptionPane.showMessageDialog(null, "Porfavor llene todos los campos");
											}
											else if(rs2.next()==true&&!tf[0].getText().equals(uam)) {
												JOptionPane.showMessageDialog(null, "Disculpe el usuario ingresado ya existe porfavor ingrese otro");
											}
											else {
												if(JOptionPane.showConfirmDialog(null, "¿Esta conforme con los datos suministrados?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION) {
													try {
														PreparedStatement ps = mysql.prepareStatement("UPDATE users SET usuario = ?, contrasena = ? WHERE usuario = '"+uam+"'");
														ps.setString(1, tf[0].getText());
														ps.setString(2, pf[0].getText());
														ps.executeUpdate();
														JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente");
													}
													catch(SQLException e) {
														JOptionPane.showMessageDialog(null, e);
													}
													break;
												}
											}
										}
										catch(SQLException e) {
											JOptionPane.showMessageDialog(null, e);
										}
									}
									else {
										break;
									}
								}
								break;
							}
							else {
								JOptionPane.showMessageDialog(null, "Disculpe su contraseña es incorrecta");
							}
						}
						else {
							break;
						}
					}
				}
				Modificar();
			}
			catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		else {
			new Opciones().Opciones();
		}
	}
}
package PaqueteClases;

import PaqueteConexionMySQL.*;
import java.sql.*;
import javax.swing.*;

public class Consulta {
	Connection mysql = new ConexionMySQL().Conectar();
	public void Consulta() {
		JPanel consulta = new JPanel();
		JTextArea ta = new JTextArea(30, 50);
		consulta.add(new JScrollPane(ta));
		try {
			ResultSet rs = mysql.createStatement().executeQuery("SELECT * FROM users");
			while(rs.next()) {
				ta.append("Usuario: " + rs.getString("usuario") + " - Contrasena: " + rs.getString("contrasena") + "\n\n");
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		JOptionPane.showConfirmDialog(null, consulta, "Registros", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
		new Opciones().Opciones();
	}
}
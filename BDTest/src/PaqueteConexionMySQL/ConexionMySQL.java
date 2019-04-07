package PaqueteConexionMySQL;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMySQL {
	String db = "test";
	String url = "jdbc:mysql://localhost/"+db;
	String user = "root";
	String pass = "";
	public Connection Conectar() {
		Connection link = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			link = DriverManager.getConnection(url, user, pass);
		}
		catch(ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return link;
	}
}
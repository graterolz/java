import java.sql.*;
import javax.swing.*;

class Oracle{
	public static void main (String args []) {
		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection objetoConexion = DriverManager.getConnection("jdbc:oracle:thin:@10.10.9.59:1521:AS400","MIGRA","temporal");
			Statement statement = objetoConexion.createStatement();
			ResultSet resultado = statement.executeQuery("select sysdate from dual");
			while (resultado.next()){
				System.out.println (resultado.getString(1));
				JOptionPane.showMessageDialog(null,resultado.getString(1));
			}
			statement.close();
		}
		catch(Exception e){
			System.out.println("Algun Error.");
		}
	}
} 
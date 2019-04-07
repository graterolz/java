import java.sql.*;
import javax.swing.JOptionPane;
public class ConexionMySQL {
	public String db = "test";
	public String url = "jdbc:mysql://localhost/"+db;
	public String user = "root";
	public String pass = "";
	//
	public ConexionMySQL() {}
	//
	public Connection Conectar() {
		Connection link = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			link = DriverManager.getConnection(this.url, this.user, this.pass);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return link;
	}
}
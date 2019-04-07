import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Prueba{
	public static void main( String [] args) throws Exception{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conexion = DriverManager.getConnection("jdbc:odbc:bd_odbc");
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from Usuario");
			while (rs.next()){
				System.out.println(rs.getObject(1));
				System.out.println(rs.getObject(2));
				System.out.println(rs.getObject(3));
			}
		}
		catch ( Exception e ){
			System.out.println("Algun error en algun sitio");
		}
		//
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conexion = DriverManager.getConnection("jdbc:odbc:bd_odbc");
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from Usuario");
		while (rs.next()){
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
		}
	}
}
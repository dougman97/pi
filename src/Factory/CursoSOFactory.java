package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CursoSOFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection obtemConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/curso_so?user=root&password=");
	}
}

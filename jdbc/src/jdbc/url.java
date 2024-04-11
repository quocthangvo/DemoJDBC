package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class url {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/demojdbc?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("Connect success");

		return connection;
	}
}

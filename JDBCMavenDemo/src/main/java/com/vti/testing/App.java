package com.vti.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resource/database.properties"));

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, username, password);

		System.out.println("connect success");

		String sql = "{CALL sp_update_group(?,?)}";
		CallableStatement callableStatement = connection.prepareCall(sql);

		short groupId = 3;
		String groupName = ".NET Senior";

		callableStatement.setString(1, groupName);
		callableStatement.setShort(2, groupId);

		int effectedRecordAmount = callableStatement.executeUpdate();

		System.out.println("Effected Record Amount: " + effectedRecordAmount);

		connection.close();
	}
}

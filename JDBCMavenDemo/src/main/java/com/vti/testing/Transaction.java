package com.vti.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Transaction {
	public static Connection getConnection()
			throws SQLException, ClassNotFoundException, IOException, FileNotFoundException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resource/database.properties"));

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(url, username, password);
	}

	private static void createUser(Connection connection) throws SQLException {
		String sql = "INSERT INTO `user` (`username`,`email`,`password`,`firstName`,`lastName`,`gender`,`dateOfBirth`,`address`,`phone`,`role`,`status`)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		String username = "quocthang", email = "quocthang@gmail.com", password = "123456", firstName = "Võ",
				lastName = "Quốc Thắng", gender = "M", dataOfBirth = "2002-10-23", address = "TPHCM",
				phone = "0964467214", role = "EMPLOYEE";
		int status = 0;

		preparedStatement.setString(1, username);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, firstName);
		preparedStatement.setString(5, lastName);
		preparedStatement.setString(6, gender);
		preparedStatement.setString(7, dataOfBirth);
		preparedStatement.setString(8, address);
		preparedStatement.setString(9, phone);
		preparedStatement.setString(10, role);
		preparedStatement.setInt(11, status);

		int effectedRecordAmount = preparedStatement.executeUpdate();

		System.out.println("Effected Recore Amout (Create User): " + effectedRecordAmount);

	}

	private static void createdGroup(Connection connection) throws SQLException {
		String sql = "INSERT INTO `Group` (`name`, `author_ID`)" + "VALUE (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		String groupName = ".NET Senior11";
		short authorId = 3;

		preparedStatement.setString(1, groupName);
		preparedStatement.setShort(2, authorId);

		int effectedRecordAmount = preparedStatement.executeUpdate();

		System.out.println("Effected Recore Amout (Create User): " + effectedRecordAmount);
	}

	private static void addUserToGroup(Connection connection) throws SQLException {
		String sql = "INSERT INTO `User_Group` (`group_id`, `user_id`)" + "VALUE (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		short group_id = 4;
		short user_id = 17;

		preparedStatement.setShort(1, group_id);
		preparedStatement.setShort(2, user_id);

		int effectedRecordAmount = preparedStatement.executeUpdate();

		System.out.println("Effected Recore Amout (Create User): " + effectedRecordAmount);
	}

	public static void main(String[] args)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Connection con = getConnection();

		con.setAutoCommit(false);
		try {
			createdGroup(con);
			createUser(con);
			addUserToGroup(con);

			con.commit();
			System.out.println("Transaction Commit");
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			System.out.println("Transaction Rollback");
		}
		con.setAutoCommit(true);
		con.close();
	}
}

package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class preparedStatement {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = url.getConnection();

		String sql = "INSERT INTO `Group` (`name`,author_ID) " + "VALUES (? , ?	 )";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		String groupName = "Java Senior";
		short authorId = 1;

		preparedStatement.setString(1, groupName);
		preparedStatement.setShort(2, authorId);
		int effectedRecordAmount = preparedStatement.executeUpdate();

		System.out.println("Effected Record Amount: " + effectedRecordAmount);

		connection.close();
	}
}

package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = url.getConnection();

		String sql = "UPDATE `Group`" + "SET `name` = ? " + "WHERE `id` = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		short groupId = 1;
		String groupName = "Java Senior hello";

		preparedStatement.setString(1, groupName);
		preparedStatement.setShort(2, groupId);

		int effectedRecordAmount = preparedStatement.executeUpdate();

		System.out.println("Effected Record Amount: " + effectedRecordAmount);

		connection.close();
	}
}

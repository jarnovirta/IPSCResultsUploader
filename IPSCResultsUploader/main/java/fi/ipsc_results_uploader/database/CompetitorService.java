package fi.ipsc_results_uploader.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CompetitorService {
	
	public String findCompetitorEmail(int memberId) {
		String email = null;		
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = AccessDatabaseUtil.connectToAccessDatabase();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT Email FROM tblMember WHERE MemberId = " + memberId);
			while (resultSet.next()) {
				email = resultSet.getString(1);
			}
			resultSet.close();
			statement.close();
			AccessDatabaseUtil.closeConnecion(connection);
			return email;
		} catch (Exception ex) {
			ex.printStackTrace();
			AccessDatabaseUtil.closeConnecion(connection);
			return null;
		}
	}
}

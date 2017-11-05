package fi.ipsc_results_uploader.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.ipsc_results_uploader.domain.Competitor;


// Methods for using a Ucanaccess connection to a Microsoft Access database file (.mdb).
public class AccessDatabaseUtil {
	public static Connection connectToAccessDatabase() {
		Connection connection = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbConnectionString = "jdbc:ucanaccess://WinMSS.mdb;jackcessOpener=fi.ipsc_results_uploader.database.CryptCodecOpener";
			connection = DriverManager.getConnection(dbConnectionString, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnecion(Connection conn) {
		try {
			if (conn != null) {
				conn.commit();
				conn.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

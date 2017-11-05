package fi.ipsc_results_uploader.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.ipsc_results_uploader.StageScoreSheet;

// Reads score data from a WinMSS .mdb file (Microsoft Access database)
public class StageScoreService {
	
	Connection connection;
	
	public List<StageScoreSheet> findScoreSheetsForMatch(int matchId) {
		List<StageScoreSheet> stageScoreSheets= new ArrayList<StageScoreSheet>();
		connection = AccessDatabaseUtil.connectToAccessDatabase();		
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM tblMatchStageScore WHERE MatchId = " + matchId);
			while (resultSet.next()) {
				StageScoreSheet sheet = new StageScoreSheet();
				sheet.setStageId(resultSet.getInt(2));
				sheet.setCompetitorId(resultSet.getInt(3));
				sheet.setaHits(resultSet.getInt(4));
				sheet.setbHits(resultSet.getInt(5));
				sheet.setcHits(resultSet.getInt(6));
				sheet.setdHits(resultSet.getInt(7));
				sheet.setMisses(resultSet.getInt(8));
				sheet.setPenalties(resultSet.getInt(9));
				sheet.setProcedurals(resultSet.getInt(10));
				sheet.setTime(resultSet.getDouble(11));
				sheet.setScoresZeroedForStage(resultSet.getBoolean(12));
				stageScoreSheets.add(sheet);
			}
			resultSet.close();
			statement.close();
			AccessDatabaseUtil.closeConnecion(connection);
			return stageScoreSheets;
		} catch (Exception ex) {
			ex.printStackTrace();
			AccessDatabaseUtil.closeConnecion(connection);
			return null;
		}
	}
}

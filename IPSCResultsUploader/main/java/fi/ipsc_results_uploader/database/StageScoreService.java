package fi.ipsc_results_uploader.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.ipsc_results_uploader.StageScoreSheet;

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
				sheet.setMatchId(Integer.parseInt(resultSet.getString(1)));
				sheet.setStageId(Integer.parseInt(resultSet.getString(2)));
				sheet.setCompetitorId(Integer.parseInt(resultSet.getString(3)));
				sheet.setaHits(Integer.parseInt(resultSet.getString(4)));
				sheet.setbHits(Integer.parseInt(resultSet.getString(5)));
				sheet.setcHits(Integer.parseInt(resultSet.getString(6)));
				sheet.setdHits(Integer.parseInt(resultSet.getString(7)));
				sheet.setMisses(Integer.parseInt(resultSet.getString(8)));
				sheet.setPenalties(Integer.parseInt(resultSet.getString(9)));
				sheet.setProcedurals(Integer.parseInt(resultSet.getString(10)));
				sheet.setTime(Double.parseDouble(resultSet.getString(11)));
				sheet.setHitFactor(Double.parseDouble(resultSet.getString(19)));
				sheet.setFinalScore(Integer.parseInt(resultSet.getString(20)));
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

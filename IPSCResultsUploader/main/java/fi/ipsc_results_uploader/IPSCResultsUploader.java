package fi.ipsc_results_uploader;

import java.util.List;

import fi.ipsc_results_uploader.GUI.MainWindow;
import fi.ipsc_results_uploader.database.MatchService;
import fi.ipsc_results_uploader.database.StageScoreService;
import fi.ipsc_results_uploader.web.SSIService;

public class IPSCResultsUploader {
	public static void main(String[] args) {
		System.out.println("Starting GUI");
		MainWindow mainWindow = new MainWindow();
		
		System.out.println("Starting IPSCResultsUploader and reading database...");
		StageScoreService scoreService = new StageScoreService();
		List<StageScoreSheet> sheets = scoreService.findScoreSheetsForMatch(4);
		System.out.println(sheets.size() + " scoresheets for match 4");
		System.out.println("Sending JSON");
		SSIService ssi = new SSIService();
		ssi.sendScoreSheets("http://shootnscoreit.com/api/alive/", sheets);
		// ssi.sendScoreSheets("https://requestb.in/1bs7lpa1", sheets);
		// RESULT in : https://requestb.in/1bs7lpa1?inspect
	}
}

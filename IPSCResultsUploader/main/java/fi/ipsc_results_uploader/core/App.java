package fi.ipsc_results_uploader.core;

import java.util.List;

import fi.ipsc_results_uploader.database.StageScoreService;
import fi.ipsc_results_uploader.domain.StageScoreSheet;
import fi.ipsc_results_uploader.gui.MainWindow;
import fi.ipsc_results_uploader.web.SSIService;

public class App {
	public static void main(String[] args) {
		// System.out.println("Starting GUI");
		// MainWindow mainWindow = new MainWindow();
		
		System.out.println("Starting IPSCResultsUploader and reading database...");
		StageScoreService scoreService = new StageScoreService();
		List<StageScoreSheet> sheets = scoreService.findScoreSheetsForMatch(1);
		System.out.println(sheets.size() + " scoresheets for match 1");
		System.out.println("Sending JSON");
		SSIService ssi = new SSIService();
		ssi.postScoreSheets(sheets, "jarvirta1@gmail.com",
				"HubbabubbaShootnscoreit1");
		// ssi.sendScoreSheets("https://requestb.in/1bs7lpa1", sheets);
		// RESULT in : https://requestb.in/1bs7lpa1?inspect
		// TEST COMMENT
	}
}

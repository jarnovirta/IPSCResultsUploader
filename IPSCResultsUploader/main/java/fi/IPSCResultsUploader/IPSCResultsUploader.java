package fi.IPSCResultsUploader;

import fi.IPSCResultsUploader.Database.AccessDatabaseUtil;
import fi.IPSCResultsUploader.Database.MatchService;
import fi.IPSCResultsUploader.GUI.MainWindow;

public class IPSCResultsUploader {
	public static void main(String[] args) {
		System.out.println("Starting GUI");
		MainWindow mainWindow = new MainWindow();
		MatchService matchService = new MatchService();
		System.out.println("Starting IPSCResultsUploader and reading database...");
		matchService.readMatchFromDatabase(2);
		AccessDatabaseUtil.connectToAccessDatabase();
	}
}

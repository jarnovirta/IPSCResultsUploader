package fi.IPSCResultsUploader;

import java.util.List;

import fi.IPSCResultsUploader.Database.AccessDatabaseUtil;
import fi.IPSCResultsUploader.Database.MatchService;

public class IPSCResultsUploader {
	
	
	public static void main(String[] args) {
		MatchService matchService = new MatchService();
		System.out.println("Starting IPSCResultsUploader and reading database...");
		
		matchService.readMatchFromDatabase(2);
		
		
		AccessDatabaseUtil.connectToAccessDatabase();
	}
}

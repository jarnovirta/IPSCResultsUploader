package fi.IPSCResultsUploader;

import java.util.List;

public class IPSCResultsUploader {
	public static void main(String[] args) {
		System.out.println("Starting IPSCResultsUploader and calling file parser...");
		DatabaseReader dbReader = new DatabaseReader();
		List<Competitor> competitorList = dbReader.findCompetitors();
		System.out.println("Competitor count: " + competitorList.size());
	}
}

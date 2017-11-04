package fi.IPSCResultsUploader;

public class IPSCResultsUploader {
	public static void main(String[] args) {
		System.out.println("Starting IPSCResultsUploader and calling file parser...");
		XmlFileParser xmlFileParser = new XmlFileParser();
		xmlFileParser.deserializeCompetitorXml();
		Competitor competitor = xmlFileParser.deserializeCompetitorXml();
		System.out.println("Kisaajan nimi: " + competitor.getName());
		System.out.println("Kisaajan luokitus: " + competitor.getClassification());
		System.out.println("Kisaajan id: " + competitor.getId());
	}
}

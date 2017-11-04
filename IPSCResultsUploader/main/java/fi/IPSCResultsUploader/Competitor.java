package fi.IPSCResultsUploader;

public class Competitor {
	private String name;
	private char classification;	
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getClassification() {
		return classification;
	}
	public void setClassification(char classification) {
		this.classification = classification;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

package fi.ipsc_results_uploader.domain;

public class Competitor {
	private String firstName;
	private String lastName;
	private String ICS;
	
	public Competitor() { }
	
	public Competitor(String firstName, String lastName, String ICS) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ICS = ICS; 
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getICS() {
		return ICS;
	}

	public void setICS(String iCS) {
		ICS = iCS;
	}
}

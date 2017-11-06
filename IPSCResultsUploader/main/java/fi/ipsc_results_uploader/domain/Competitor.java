package fi.ipsc_results_uploader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Competitor {
	@JsonProperty("pk")
	private int ssiPrimaryKey;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("ics_alias")
	private String ICS;
	private String email;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSsiPrimaryKey() {
		return ssiPrimaryKey;
	}

	public void setSsiPrimaryKey(int ssiPrimaryKey) {
		this.ssiPrimaryKey = ssiPrimaryKey;
	}
}

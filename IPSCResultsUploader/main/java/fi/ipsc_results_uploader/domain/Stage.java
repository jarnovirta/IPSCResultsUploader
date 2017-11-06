package fi.ipsc_results_uploader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stage {
	@JsonProperty("number")
	private int ssiStageNumber;
	private String name;
	@JsonProperty("pk")
	private int ssiPrimaryKey;
	public int getSsiStageNumber() {
		return ssiStageNumber;
	}
	public void setSsiStageNumber(int ssiStageNumber) {
		this.ssiStageNumber = ssiStageNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsiPrimaryKey() {
		return ssiPrimaryKey;
	}
	public void setSsiPrimaryKey(int ssiPrimaryKey) {
		this.ssiPrimaryKey = ssiPrimaryKey;
	}
	
	
}	

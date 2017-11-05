package fi.ipsc_results_uploader;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StageScoreSheet {
	
	@JsonProperty("model")
	private String ssiModel = "match_ipsc.ipscscorecard";
	@JsonIgnore
	private int primaryKey;
	@JsonProperty("stage")
	private int stageId;
	@JsonProperty("competitor")
	private int competitorId;
	@JsonProperty("ascore")
	private int aHits;
	@JsonProperty("bscore")
	private int bHits;
	@JsonProperty("cscore")
	private int cHits;
	@JsonProperty("dscore")
	private int dHits;
	@JsonProperty("miss")
	private int misses = 0;
	@JsonProperty("penalty")
	private int penalties = 0;
	@JsonProperty("deductions")
	private int deductedPoints = 0;
	@JsonProperty("spec_penalty")
	private int specialPenalty;
	@JsonIgnore
	private double time;
	@JsonProperty("time")
	private String timeString;
	// TODO: Reasons for disqualification. SSI API page 60 and WinMSS 
	// database table "tblTypeDisqualifyRule"
	@JsonProperty("dq_reason")
	private String disqualificationReason = "no";
	@JsonProperty("procedural")
	private int procedurals;
	@JsonProperty("zeroed")
	boolean scoresZeroedForStage = false;
	private String comment = "";
	
	
	// Set default values to required fields pf_correction, evt, tnh, tnn and tne. These 
	//	are not used. See SSI API pages 56 and 62.
	@JsonProperty("pf_correction")
	private int powerFactorCorrection = 0;
	
	@JsonProperty("tnh")
	private int targetNotHit = 0;
	@JsonProperty("tnn")
	private int targetNotNeutralized = 0;
	@JsonProperty("tne")
	private int targetNotEngaged = 0;
	
	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}


	public int getCompetitorId() {
		return competitorId;
	}

	public void setCompetitorId(int competitorId) {
		this.competitorId = competitorId;
	}

	public int getaHits() {
		return aHits;
	}

	public void setaHits(int aHits) {
		this.aHits = aHits;
	}

	public int getbHits() {
		return bHits;
	}

	public void setbHits(int bHits) {
		this.bHits = bHits;
	}

	public int getcHits() {
		return cHits;
	}

	public void setcHits(int cHits) {
		this.cHits = cHits;
	}

	public int getdHits() {
		return dHits;
	}

	public void setdHits(int dHits) {
		this.dHits = dHits;
	}

	public int getMisses() {
		return misses;
	}

	public void setMisses(int misses) {
		deductedPoints -= this.misses * 10;		
		this.misses = misses;
		deductedPoints += misses * 10;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		deductedPoints -= this.penalties * 10;
		this.penalties = penalties;
		deductedPoints += penalties * 10;
	}

	public int getProcedurals() {
		return procedurals;
	}

	public void setProcedurals(int procedurals) {
		this.procedurals = procedurals;
	}

	public int getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

	public int getSpecialPenalty() {
		return specialPenalty;
	}

	public void setSpecialPenalty(int specialPenalty) {
		this.specialPenalty = specialPenalty;
	}

	public String getDisqualificationReason() {
		return disqualificationReason;
	}

	public void setDisqualificationReason(String disqualificationReason) {
		this.disqualificationReason = disqualificationReason;
	}

	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isScoresZeroedForStage() {
		return scoresZeroedForStage;
	}

	public void setScoresZeroedForStage(boolean scoresZeroedForStage) {
		this.scoresZeroedForStage = scoresZeroedForStage;
	}

	public int getDeductedPoints() {
		return deductedPoints;
	}

	public void setDeductedPoints(int deductedPoints) {
		this.deductedPoints = deductedPoints;
	}

	public String getSsiModel() {
		return ssiModel;
	}

	public void setSsiModel(String ssiModel) {
		this.ssiModel = ssiModel;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
		this.timeString = Double.toString(time);
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public int getPowerFactorCorrection() {
		return powerFactorCorrection;
	}

	public void setPowerFactorCorrection(int powerFactorCorrection) {
		this.powerFactorCorrection = powerFactorCorrection;
	}

	public int getTargetNotHit() {
		return targetNotHit;
	}

	public void setTargetNotHit(int targetNotHit) {
		this.targetNotHit = targetNotHit;
	}

	public int getTargetNotNeutralized() {
		return targetNotNeutralized;
	}

	public void setTargetNotNeutralized(int targetNotNeutralized) {
		this.targetNotNeutralized = targetNotNeutralized;
	}

	public int getTargetNotEngaged() {
		return targetNotEngaged;
	}

	public void setTargetNotEngaged(int targetNotEngaged) {
		this.targetNotEngaged = targetNotEngaged;
	}
}

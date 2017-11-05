package fi.ipsc_results_uploader;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StageScoreSheet {

	@JsonProperty("match_id_TEST")
	private int matchId;
	private int stageId;
	private int competitorId;
	private int aHits;
	private int bHits;
	private int cHits;
	private int dHits;
	private int misses;
	private int penalties;
	private int procedurals;
	private double time;
	private double hitFactor;
	private double finalScore;
	
	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

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
		this.misses = misses;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}

	public int getProcedurals() {
		return procedurals;
	}

	public void setProcedurals(int procedurals) {
		this.procedurals = procedurals;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getHitFactor() {
		return hitFactor;
	}

	public void setHitFactor(double hitFactor) {
		this.hitFactor = hitFactor;
	}

	public double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}
}

package fi.ipsc_results_uploader.web;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fi.ipsc_results_uploader.database.CompetitorService;
import fi.ipsc_results_uploader.domain.Competitor;
import fi.ipsc_results_uploader.domain.Stage;
import fi.ipsc_results_uploader.domain.StageScoreSheet;

public class SSIService {
	
		private CompetitorService competitorService = new CompetitorService();
		private String encodedCredentials;
		private ObjectMapper objectMapper = new ObjectMapper();
		private int matchId;
		private List<StageScoreSheet> sheets;
		
	public void postScoreSheets(List<StageScoreSheet> sheets, String userName, 
			String password) {
		this.sheets = sheets;
		encodedCredentials = Base64.getEncoder().encodeToString((userName + ":" + password).getBytes());
		////// FOR TESTING:
		matchId = 6248;
		String url = "https://shootnscoreit.com/api/ipsc/match/" + matchId + "/scoresheets/";
//		int stageId = 21919;
//		int competitorId = 179847;
//		((StageScoreSheet) sheets.get(0)).setStageId(stageId);
//		((StageScoreSheet) sheets.get(0)).setCompetitorId(competitorId);
		
		///////////
		
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
        	setSsiPrimaryKeysToScoreSheetData();
        	String JSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sheets);
        	System.out.println("JSON: " + JSON);
            HttpPost request = new HttpPost(url);
            request.setHeader("Authorization", "Basic " + encodedCredentials);
            request.setHeader("X_REQUESTED_WITH", "XMLHttpRequest"); // Header instructed to be set in SSI API manual
            StringEntity params = new StringEntity(JSON);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            String responseString = new BasicResponseHandler().handleResponse(response);            
            System.out.println("RESULT : \n" + responseString);
            System.out.println("\n\n*** DONE UPLOADING RESULTS");
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        	// TODO: delete all scorecards from SSI?
        }
        
    }
	// Adds competitor and stage ID information from SSI server to score sheets
	private void setSsiPrimaryKeysToScoreSheetData() throws Exception {
		List<Competitor> ssiCompetitorList = new ArrayList<Competitor>();
		List<Stage> ssiStageList = new ArrayList<Stage>();
		
		String competitorsUrl = "https://shootnscoreit.com/api/ipsc/match/" + matchId + "/competitors/";
		String stagesUrl = "https://shootnscoreit.com/api/ipsc/match/" + matchId + "/stages/";
		
				// Get all competitors from SSI server
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet request = new HttpGet(competitorsUrl);
			System.out.println("Getting competitor info from SSI for match " + matchId);
			request.setHeader("Authorization", "Basic " + encodedCredentials);
            request.setHeader("X_REQUESTED_WITH", "XMLHttpRequest"); // Header instructed to be set in SSI API manual
            HttpResponse response = httpClient.execute(request);
            ssiCompetitorList = objectMapper.readValue(EntityUtils.toString(response.getEntity()), 
            		new TypeReference<List<Competitor>>(){});
            System.out.println("Got info for " + ssiCompetitorList.size() + " competitors from SSI server.");
            request = new HttpGet(stagesUrl);
            System.out.println("Getting stage info from SSI for match " + matchId);
			request.setHeader("Authorization", "Basic " + encodedCredentials);
            request.setHeader("X_REQUESTED_WITH", "XMLHttpRequest"); // Header instructed to be set in SSI API manual
            response = httpClient.execute(request);
            ssiStageList = objectMapper.readValue(EntityUtils.toString(response.getEntity()), 
            		new TypeReference<List<Stage>>(){});
            System.out.println("Got info for " + ssiStageList.size() + " stages from SSI server.");
            
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	throw new Exception();
	    }
		
		for (StageScoreSheet sheet : sheets) {
			String competitorEmail = competitorService.findCompetitorEmail(sheet.getWinMssMemberId());
			for (Competitor competitor : ssiCompetitorList) {
				if (competitor.getEmail().equals(competitorEmail)) {
					System.out.println("Setting ssi primary key " + competitor.getSsiPrimaryKey() 
							+ " to competitor " + competitorEmail);
					sheet.setCompetitorSsiPrimaryKey(competitor.getSsiPrimaryKey());
				}
			}
			for (Stage stage : ssiStageList) {
				if (stage.getSsiStageNumber() == sheet.getWinMssStageId()) {
					System.out.println("Setting ssi primary key " + stage.getSsiPrimaryKey() + " to score sheet");
					sheet.setSsiStagePrimaryKey(stage.getSsiPrimaryKey());
				}
			}
			
		}
	}
}

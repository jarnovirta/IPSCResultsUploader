package fi.ipsc_results_uploader.web;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import fi.ipsc_results_uploader.StageScoreSheet;

public class SSIService {
	public HttpResponse sendScoreSheets(String url, List<StageScoreSheet> sheets, String userName, 
			String password) {

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
        	String encodedCredentials = Base64.getEncoder().encodeToString((userName + ":" + password).getBytes());
        	System.out.println("Credentials encoding: " + "Basic " + encodedCredentials);
        	ObjectMapper objectMapper = new ObjectMapper();
        	String JSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sheets);
            HttpGet request = new HttpGet(url);
            request.setHeader("Authorization", "Basic " + encodedCredentials);
            request.setHeader("X_REQUESTED_WITH", "XMLHttpRequest"); // Header instructed to be set in API manual
            
            StringEntity params = new StringEntity(JSON);
            request.addHeader("content-type", "application/json");
            
            // request.setEntity(params);
            System.out.println("REQUEST: " + request.toString());
            HttpResponse response = httpClient.execute(request);
            String responseString = new BasicResponseHandler().handleResponse(response);            
            System.out.println("RESULT : \n" + responseString);

        } catch (IOException ex) {
        	ex.printStackTrace();
        }
        return null;
    }

}

package fi.IPSCResultsUploader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlFileParser {
	public Competitor deserializeCompetitorXml() {
		File file = new File("competitor_test.xml");
		XmlMapper xmlMapper = new XmlMapper();
		try {
		String xml = inputStreamToString(new FileInputStream(file));
		Competitor competitor = xmlMapper.readValue(xml, Competitor.class);
		return competitor;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String inputStreamToString(InputStream inputStream) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}
		bufferedReader.close();
		return stringBuilder.toString();
	}
}

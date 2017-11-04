package fi.IPSCResultsUploader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.healthmarketscience.jackcess.CryptCodecProvider;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

public class DatabaseReader {
	
	public List<Competitor> findCompetitors() {
		List<Competitor> competitorList = new ArrayList<Competitor>();
		try {
			DatabaseBuilder dbBuilder = new DatabaseBuilder(new File("WinMSS.mdb"));
			dbBuilder.setCodecProvider(new CryptCodecProvider());
			dbBuilder.setReadOnly(true);
			Database db = dbBuilder.open();
		Table table = db.getTable("tblMember");
				
		for(Row row : table) {
			competitorList.add(new Competitor(row.getString("Firstname"), row.getString("Lastname"), row.getString("ICS")));  
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return competitorList;
	}
}

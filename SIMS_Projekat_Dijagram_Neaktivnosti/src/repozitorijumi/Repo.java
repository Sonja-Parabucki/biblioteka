package repozitorijumi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.Clan;

public class Repo {

	public void sacuvajNaloge(List<Clan> nalozi) throws IOException {
		File fajlNalozi = new File("./podaci/clanovi.json");
		
		OutputStream osNalozi = new BufferedOutputStream(new FileOutputStream(fajlNalozi));
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			
			//mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(Visibility.ANY));
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			
			mapper.writeValue(fajlNalozi, nalozi);

			
		} finally {
			osNalozi.close();
		}
	}
	
	public List<Clan> ucitajNaloge() throws IOException {
		List<Clan> nalozi = new ArrayList<Clan>();
		
		File fajlNalozi = new File("./podaci/clanovi.json");
		
		InputStream isNalozi = new BufferedInputStream(new FileInputStream(fajlNalozi));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		try {
			nalozi = mapper.readValue(fajlNalozi, new TypeReference<List<Clan>>() {});
			
			
		} finally {
			isNalozi.close();
		}
		return nalozi;			
	}
	
	public void dodajNalog(Clan nalog) throws IOException {
		List<Clan> nalozi = ucitajNaloge();
		nalozi.add(nalog);
		sacuvajNaloge(nalozi);
	}
	
}

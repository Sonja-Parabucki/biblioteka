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

public class ClanRepo {
	
	List<Clan> clanovi = new ArrayList<Clan>();
	
	public ClanRepo() {
		try{
			ucitajClanove();
		}catch(Exception e) {
			
		}
	}
	
	public void sacuvajClanove() throws IOException {
		File fajlClanovi = new File("./podaci/clanovi.json");
		
		OutputStream osNalozi = new BufferedOutputStream(new FileOutputStream(fajlClanovi));
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			
			//mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(Visibility.ANY));
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			
			mapper.writeValue(fajlClanovi, clanovi);

			
		} finally {
			osNalozi.close();
		}
	}
	
	public void ucitajClanove() throws IOException {
		File fajlClanovi = new File("./podaci/clanovi.json");
		
		InputStream isNalozi = new BufferedInputStream(new FileInputStream(fajlClanovi));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		try {
			clanovi = mapper.readValue(fajlClanovi, new TypeReference<List<Clan>>() {});
		} 
		catch (Exception e) {
			clanovi = new ArrayList<Clan>();
		}
		finally {
			isNalozi.close();
		}		
	}
	
	public boolean PronadjiPoClanskojKarti(String clKarta) {
		for (Clan c : clanovi) {
			if (c.getBrojClanskeKarte().equals(clKarta))
				return true;
		}
		return false;
	}
	
	public void dodajClana(Clan clan) throws IOException {
		clanovi.add(clan);
		sacuvajClanove();
	}
	
	public List<Clan> getClanovi(){
		return clanovi;
	}
}

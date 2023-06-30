package repo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.Izdanje;
import model.Izdavac;

public class IzdanjaRepo {
	
	private List<Izdanje> izdanja = new ArrayList<Izdanje>();
	
	public List<Izdanje> getIzdanja() {
		return izdanja;
	}

	public void dodajIzdanje(Izdanje izdanje) throws IOException {
		izdanja.add(izdanje);
		sacuvaj();
	}
	
	public boolean postoji(Izdanje novo) {
		for (Izdanje izdanje : izdanja) {
			if (izdanje == novo)
				return true;
		}
		return false;
	}
	
	public int noviID() {
		return izdanja.size() + 1;
	}
	
	public List<Izdavac> nadjiSveIzdavace(){
		Set<Izdavac> izdavaci = new HashSet<Izdavac>();
		for (Izdanje izdanje : izdanja) {
			izdavaci.add(izdanje.getIzdavac());
		}
		return (List<Izdavac>) izdavaci;
	}

	public void sacuvaj() throws IOException {
		File fajlIzdanja = new File("./podaci/izdanja.json");
		
		OutputStream os = new BufferedOutputStream(new FileOutputStream(fajlIzdanja));
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.writeValue(fajlIzdanja, izdanja);
			
		} finally {
			os.close();
		}
	}
	
	public List<Izdanje> ucitaj() throws IOException {
		
		File fajlIzdanja = new File("./podaci/izdanja.json");
		
		InputStream is = new BufferedInputStream(new FileInputStream(fajlIzdanja));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		try {
			izdanja = mapper.readValue(fajlIzdanja, new TypeReference<List<Izdanje>>() {});
			
		} finally {
			is.close();
		}
		return izdanja;			
	}

}

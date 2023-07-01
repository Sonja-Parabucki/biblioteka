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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.Autor;
import model.Izdanje;
import model.Izdavac;
import model.Knjiga;
import model.Zanr;

public class IzdanjaRepo {
	
	private List<Izdanje> izdanja = new ArrayList<Izdanje>();
	
	public IzdanjaRepo() throws IOException {
		ucitaj();
	}
	
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
	
	public Set<Izdavac> nadjiSveIzdavace(){
		Set<Izdavac> izdavaci = new HashSet<Izdavac>();
		for (Izdanje izdanje : izdanja) {
			izdavaci.add(izdanje.getIzdavac());
		}
		return izdavaci;
	}
	
	public Set<Autor> nadjiSveAutore(){
		Set<Autor> autori = new HashSet<Autor>();
		for (Izdanje izdanje : izdanja) {
			autori.addAll(izdanje.getAutori());
		}
		return autori;
	}
	
	public Set<Zanr> nadjiSveZanrove(){
		Set<Zanr> zanrovi = new HashSet<Zanr>();
		for (Izdanje izdanje : izdanja) {
			zanrovi.addAll(izdanje.getZanrovi());
		}
		return zanrovi;
	}

	public List<Izdanje> nadjiSveKnjige(){
		List<Izdanje> knjige = new ArrayList<Izdanje>();
		int pom = 0;
		for(Izdanje izdanje : izdanja) {
			for(Izdanje iz : knjige) {
				if(iz.jeIstaKnjiga(izdanje)) {
					pom = 1;
					break;
				}
			}
			if(pom==0) {
				knjige.add(izdanje);
			}
			pom = 0;
		}
		return knjige;
	}
	
	public List<Izdanje> nadjiSvaIzdanja(Knjiga knjiga){
		List<Izdanje> izd = new ArrayList<Izdanje>();
		for(Izdanje izdanje : izdanja) {
			if(izdanje.jeIstaKnjiga(knjiga)) {
				izd.add(izdanje);
			}
		}
		return izd;
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
	
	public void ucitaj() throws IOException {
		
		File fajlIzdanja = new File("./podaci/izdanja.json");
		
		InputStream is = new BufferedInputStream(new FileInputStream(fajlIzdanja));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		try {
			izdanja = mapper.readValue(fajlIzdanja, new TypeReference<List<Izdanje>>() {});
			
		} finally {
			is.close();
		}		
	}

}

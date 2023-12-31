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

import enumeracije.StanjePrimerka;
import enumeracije.TipKoricenja;
import model.Autor;
import model.Izdanje;
import model.Izdavac;
import model.Knjiga;
import model.Primerak;
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
	
	public void izmeni(int id, String naziv, String jezik, List<Zanr> zanrovi, List<Autor> autori, String opis, String udk, String isbn,
			int godinaIzdanja, TipKoricenja koricenje, Izdavac izdavac) throws IOException {
		for (Izdanje iz:izdanja) {
			if (iz.getId() == id) {
				iz.setNaziv(naziv);
				iz.setJezik(jezik);
				iz.setZanrovi(zanrovi);
				iz.setAutori(autori);
				iz.setOpis(opis);
				iz.setUdk(udk);
				iz.setIsbn(isbn);
				iz.setGodinaIzdanja(godinaIzdanja);
				iz.setKoricenje(koricenje);
				iz.setIzdavac(izdavac);
				break;
			}
		}
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
	
	public List<Izdavac> nadjiSveIzdavace() {
		List<Izdavac> izdavaci = new ArrayList<Izdavac>();
		for (Izdanje izdanje : izdanja) {
			if(!izdavaci.contains(izdanje.getIzdavac()))
				izdavaci.add(izdanje.getIzdavac());
		}
		return izdavaci;
	}
	
	public List<Autor> nadjiSveAutore(){
		List<Autor> autori = new ArrayList<Autor>();
		for (Izdanje izdanje : izdanja) {
			for(Autor a : izdanje.getAutori()) {
				if(!autori.contains(a)) {
					autori.add(a);
				}
			}
		}
		return autori;
	}
	
	public List<Zanr> nadjiSveZanrove(){
		List<Zanr> zanrovi = new ArrayList<Zanr>();
		for (Izdanje izdanje : izdanja) {
			for(Zanr z : izdanje.getZanrovi()) {
				if(!zanrovi.contains(z)) {
					zanrovi.add(z);
				}
			}
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
	
	public void dodajPrimerak(Primerak p, int izdanje) throws IOException {
		this.izdanja.get(izdanje).dodajPrimerak(p);
		sacuvaj();
	}
	
	public void promeniNabavnuCenu(int idIzdanja, int inventarniBroj, double nova) throws IOException {
		for (Izdanje iz : izdanja) {
			if (iz.getId() == idIzdanja) {
				for (Primerak p : iz.getPrimerci()) {
					if (p.getInventarniBroj() == inventarniBroj) {
						p.setNabavnaCena(nova);
						break;
					}
				}
				break;
			}
		}
		sacuvaj();
	}

	public void promeniStanje(int invBroj, StanjePrimerka stanje) throws IOException {
		for (Izdanje izd : izdanja) {
			for (Primerak p : izd.getPrimerci()) {
				if(p.getInventarniBroj()!=invBroj) continue;
				p.setStanje(stanje);
				sacuvaj();
				return;
			}
		}
	}
}

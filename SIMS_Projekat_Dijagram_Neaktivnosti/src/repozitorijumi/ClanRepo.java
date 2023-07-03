package repozitorijumi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import enumeracije.TipClana;
import model.Adresa;
import model.Clan;
import model.Iznajmljivanje;

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
	
	public Clan PronadjiPoClanskojKarti(String clKarta) {
		for (Clan c : clanovi) {
			if (c.getBrojClanskeKarte().equals(clKarta))
				return c;
		}
		return null;
	}
	
	public void dodajClana(Clan clan) throws IOException {
		clanovi.add(clan);
		sacuvajClanove();
	}
	
	public List<Clan> getClanovi(){
		return clanovi;
	}

	public void dodajIznajmljivanje(String clanskaKarta, Iznajmljivanje iz) throws IOException {
		for(Clan c : clanovi) {
			if(c.getBrojClanskeKarte().equals(clanskaKarta)) {
				c.dodajIznajmljivanje(iz);
				sacuvajClanove();
				return;
			}
		}
		
	}
	public void izmeniClana(String staraClKarta, Adresa adresa, String broj, String ime, String mejl, String JMBG, String prezime, String telefon, String tip) throws IOException {
		for (Clan clan : clanovi) {
			if (clan.getBrojClanskeKarte().equals(staraClKarta)) {
				clan.setAdresa(adresa);
				clan.setBrojClanskeKarte(broj);
				clan.setIme(ime);
				clan.setImejl(mejl);
				clan.setJmbg(JMBG);
				clan.setPrezime(prezime);
				clan.setTelefon(telefon);
				clan.setTip(TipClana.valueOf(tip));
			}
		}
		sacuvajClanove();
	}

	public void vratiKnjigu(int invBroj) throws IOException {
		for(Clan c : clanovi) {
			for(Iznajmljivanje iz : c.getPrimerci()) {
				if((iz.getPrimerak().getInventarniBroj()!=invBroj)||!iz.getDatumVracanja().equals("nije vracen")) continue;
				LocalDate danas = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String datumVrac = danas.format(formatter);
				iz.setDatumVracanja(datumVrac);
				sacuvajClanove();
				return;
			}
		}
	}
	
	public int izbrojDug(String clanskaKarta) {
		int broj = 0;
		Clan c = PronadjiPoClanskojKarti(clanskaKarta);
		for(Iznajmljivanje iz : c.getPrimerci()) {
			if(iz.getDatumVracanja().equals("nije vracen")) broj++;
		}
		return broj;
	}
	
	public boolean platioClanarinu(String clanskaKarta) {
		Clan c = PronadjiPoClanskojKarti(clanskaKarta);
		LocalDate danas = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate uplatio = LocalDate.parse(c.getPlacenaClanarina(), formatter);
		int razlika = Math.abs((int) ChronoUnit.DAYS.between(uplatio, danas));
		return razlika < 365;
	}
}

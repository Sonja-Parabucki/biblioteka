package kontroleri;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import enumeracije.StanjePrimerka;
import model.Biblioteka;
import model.Clan;
import model.Iznajmljivanje;
import model.Primerak;
import repozitorijumi.ClanRepo;
import repozitorijumi.IzdanjaRepo;
import repozitorijumi.PrimerakRepo;

public class IznajmljivanjeKontroler {
	private Biblioteka biblioteka;
	private ClanRepo clanRepo;
	private PrimerakRepo primerakRepo;
	private IzdanjaRepo izdanjeRepo;
	public IznajmljivanjeKontroler(Biblioteka biblioteka) throws IOException {
		this.biblioteka = biblioteka;
		clanRepo = new ClanRepo();
		primerakRepo = new PrimerakRepo();
		izdanjeRepo = new IzdanjaRepo();
	}
	
	public void iznajmiKnjigu(String clanskaKarta, int invBroj) throws IOException {
		
		promeniStanje(invBroj, StanjePrimerka.IZNAJMLJEN);
		
		LocalDate danas = LocalDate.now();
		LocalDate rok = LocalDate.now();
		rok.plusDays(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String datumIzn = danas.format(formatter);
		String datumVrac = rok.format(formatter);
		
		Primerak p = primerakRepo.dobaviPrimerak(invBroj);
		Iznajmljivanje iz = new Iznajmljivanje(datumIzn, datumVrac, false, p);
		clanRepo.dodajIznajmljivanje(clanskaKarta, iz);
		
	}
	
	private void promeniStanje(int invBroj, StanjePrimerka stanje) throws IOException {
		primerakRepo.promeniStanje(invBroj, stanje);
		biblioteka.promeniStanje(invBroj, stanje);
		izdanjeRepo.promeniStanje(invBroj, stanje);
		
	}
	
	public void vratiKnjigu(int invBroj) throws IOException {
		promeniStanje(invBroj, StanjePrimerka.DOSTUPAN);
	}
	
	public String[] dobaviNaziveClanova(){
		List<Clan> clanovi = clanRepo.getClanovi();
		String[] nazivi = new String[clanovi.size()];
		for(int i=0; i<clanovi.size(); i++) {
			nazivi[i] = clanovi.get(i).naziv();
		}
		return nazivi;
	}
	
	public String[] dobaviNazivePrimeraka(StanjePrimerka stanje) {
		List<Primerak> primerci = primerakRepo.dobaviPoStanju(stanje);
		String[] nazivi = new String[primerci.size()];
		for(int i=0; i<primerci.size(); i++) {
			nazivi[i] = primerci.get(i).naziv();
		}
		return nazivi;
	}
}

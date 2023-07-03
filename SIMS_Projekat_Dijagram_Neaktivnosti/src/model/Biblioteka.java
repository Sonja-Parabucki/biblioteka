package model;

import java.util.ArrayList;
import java.util.List;

import enumeracije.StanjePrimerka;

public class Biblioteka {
	private Nalog prijavljeniKorisnik = null;
	private List<Propisi> propisi = new ArrayList<Propisi>();
	private List<Izdanje> izdanja = new ArrayList<Izdanje>();
	private List<Ogranak> ogranci = new ArrayList<Ogranak>();
	private List<Naplata> naplate = new ArrayList<Naplata>();
	private List<ZahtevZaProduzenje> zahteviZaProduzenje = new ArrayList<ZahtevZaProduzenje>();
	private List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
	private List<Nalog> nalozi = new ArrayList<Nalog>();
	
	public Biblioteka() {}
	
	public Biblioteka(Nalog prijavljeniKorisnik, List<Propisi> propisi, List<Izdanje> izdanja, List<Ogranak> ogranci,
			List<Naplata> naplate, List<ZahtevZaProduzenje> zahteviZaProduzenje, List<Rezervacija> rezervacije, List<Nalog> nalozi) {
		super();
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		this.propisi = propisi;
		this.izdanja = izdanja;
		this.ogranci = ogranci;
		this.naplate = naplate;
		this.zahteviZaProduzenje = zahteviZaProduzenje;
		this.rezervacije = rezervacije;
		this.nalozi = nalozi;
	}
	public Nalog getPrijavljeniKorisnik() {
		return prijavljeniKorisnik;
	}
	public void setPrijavljeniKorisnik(Nalog prijavljeniKorisnik) {
		this.prijavljeniKorisnik = prijavljeniKorisnik;
	}
	public List<Propisi> getPropisi() {
		return propisi;
	}
	public void setPropisi(List<Propisi> propisi) {
		this.propisi = propisi;
	}
	public List<Izdanje> getIzdanja() {
		return izdanja;
	}
	public void setIzdanja(List<Izdanje> izdanja) {
		this.izdanja = izdanja;
	}
	public List<Ogranak> getOgranci() {
		return ogranci;
	}
	public void setOgranci(List<Ogranak> ogranci) {
		this.ogranci = ogranci;
	}
	public List<Naplata> getNaplate() {
		return naplate;
	}
	public void setNaplate(List<Naplata> naplate) {
		this.naplate = naplate;
	}
	public List<ZahtevZaProduzenje> getZahteviZaProduzenje() {
		return zahteviZaProduzenje;
	}
	public void setZahteviZaProduzenje(List<ZahtevZaProduzenje> zahteviZaProduzenje) {
		this.zahteviZaProduzenje = zahteviZaProduzenje;
	}
	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	public List<Nalog> getNalozi() {
		return nalozi;
	}
	public void setNalozi(List<Nalog> nalozi) {
		this.nalozi = nalozi;
	}
	
	public void dodajNalog(Nalog nalog) {
		this.nalozi.add(nalog);
	}
	
	@Override
	public String toString() {
		return "Biblioteka [prijavljeniKorisnik=" + prijavljeniKorisnik + ", propisi=" + propisi + ", izdanja="
				+ izdanja + ", ogranci=" + ogranci + ", naplate=" + naplate + ", zahteviZaProduzenje="
				+ zahteviZaProduzenje + ", rezervacije=" + rezervacije + "]";
	}
	public void dodajPrimerak(Primerak p, int i) {
		this.izdanja.get(i).dodajPrimerak(p);
	}
	
	public void dodajIzdanje(Izdanje izdanje) {
		izdanja.add(izdanje);
	}

	public void promeniStanje(int invBroj, StanjePrimerka stanje) {
		for (Izdanje izd : izdanja) {
			for (Primerak p : izd.getPrimerci()) {
				if(p.getInventarniBroj()!=invBroj) continue;
				p.setStanje(stanje);
				return;
			}
		}
	}
}

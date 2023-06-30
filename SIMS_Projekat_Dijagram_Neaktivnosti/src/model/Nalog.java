package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import enumeracije.TipNaloga;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Nalog {
	private String korisnickoIme;
	private String lozinka;
	private TipNaloga tip;
	private Osoba osoba;
	
	public Nalog() {}
	
	public Nalog(String korisnickoIme, String lozinka, TipNaloga tip, Osoba osoba) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tip = tip;
		this.osoba = osoba;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public TipNaloga getTip() {
		return tip;
	}
	public void setTip(TipNaloga tip) {
		this.tip = tip;
	}
	public Osoba getOsoba() {
		return osoba;
	}
	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	@Override
	public String toString() {
		return "Nalog [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", tip=" + tip + ", osoba=" + osoba
				+ "]";
	}
	
}

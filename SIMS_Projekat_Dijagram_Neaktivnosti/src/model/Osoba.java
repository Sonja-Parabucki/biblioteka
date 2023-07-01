package model;

public class Osoba {
	private String ime;
	private String prezime;
	private String jmbg;
	private String imejl;
	private String telefon;
	private Adresa adresa;
	
	public Osoba() {}
	public Osoba(String ime, String prezime, String jmbg, String imejl, String telefon, Adresa adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.imejl = imejl;
		this.telefon = telefon;
		this.adresa = adresa;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getImejl() {
		return imejl;
	}
	public void setImejl(String imejl) {
		this.imejl = imejl;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	@Override
	public String toString() {
		return "Osoba [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", imejl=" + imejl + ", telefon="
				+ telefon + ", adresa=" + adresa + "]";
	}
	
}

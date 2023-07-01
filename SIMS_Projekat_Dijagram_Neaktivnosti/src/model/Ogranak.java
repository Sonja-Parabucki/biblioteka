package model;

public class Ogranak {
	private String naziv;
	private Adresa adresa;
	public Ogranak() {}
	public Ogranak(String naziv, Adresa adresa) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	@Override
	public String toString() {
		return "Ogranak [naziv=" + naziv + ", adresa=" + adresa + "]";
	}
	
}

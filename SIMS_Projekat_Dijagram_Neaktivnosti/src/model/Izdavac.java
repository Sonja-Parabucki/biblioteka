package model;

import java.util.List;

public class Izdavac {
	
	private String naziv;
	private Adresa adresa;
	private List<Izdanje> izdanja;
	public Izdavac(String naziv, Adresa adresa, List<Izdanje> izdanja) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.izdanja = izdanja;
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
	public List<Izdanje> getIzdanja() {
		return izdanja;
	}
	public void setIzdanja(List<Izdanje> izdanja) {
		this.izdanja = izdanja;
	}
	@Override
	public String toString() {
		return "Izdavac [naziv=" + naziv + ", adresa=" + adresa + ", izdanja=" + izdanja + "]";
	}

}

package model;

import java.util.List;

public class Knjiga {
	private String naziv;
	private String jezik;
	private List<Autor> autori;
	public Knjiga(String naziv, String jezik, List<Autor> autori) {
		super();
		this.naziv = naziv;
		this.jezik = jezik;
		this.autori = autori;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getJezik() {
		return jezik;
	}
	public void setJezik(String jezik) {
		this.jezik = jezik;
	}
	public List<Autor> getAutori() {
		return autori;
	}
	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}
	@Override
	public String toString() {
		return "Knjiga [naziv=" + naziv + ", jezik=" + jezik + ", autori=" + autori + "]";
	}
	
}

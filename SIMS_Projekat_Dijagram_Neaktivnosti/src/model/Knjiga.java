package model;

import java.util.List;
import java.util.Objects;

public class Knjiga {
	protected String naziv;
	protected String jezik;
	protected List<Autor> autori;
	protected List<Zanr> zanrovi;
	public Knjiga() {}
	
	public Knjiga(String naziv, String jezik, List<Autor> autori, List<Zanr> zanrovi) {
		super();
		this.naziv = naziv;
		this.jezik = jezik;
		this.autori = autori;
		this.zanrovi = zanrovi;
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
	public List<Zanr> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(List<Zanr> zanrovi) {
		this.zanrovi = zanrovi;
	}

	@Override
	public String toString() {
		return "Knjiga [naziv=" + naziv + ", jezik=" + jezik + ", autori=" + autori + ", zanrovi=" + zanrovi + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		return Objects.equals(autori, other.autori) && Objects.equals(naziv, other.naziv);
	}
	
	
	
}

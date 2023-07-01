package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Izdavac {
	
	private String naziv;
	private Adresa adresa;
	//private List<Izdanje> izdanja = new ArrayList<Izdanje>();
	
	public Izdavac() {}
	
//	public Izdavac(String naziv, Adresa adresa, List<Izdanje> izdanja) {
//		super();
//		this.naziv = naziv;
//		this.adresa = adresa;
//	}
	public Izdavac(String naziv, Adresa adresa) {
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
		return naziv + ", " + adresa.getMesto().getNaziv();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Izdavac other = (Izdavac) obj;
		return naziv.equals(other.naziv);
	}
}

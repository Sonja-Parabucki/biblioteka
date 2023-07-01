package model;

import java.util.List;

public class InventarnaKnjiga {
	private int broj;
	private String naziv;
	private List<Primerak> primerci;
	
	public InventarnaKnjiga() {}
	public InventarnaKnjiga(int broj, String naziv, List<Primerak> primerci) {
		super();
		this.broj = broj;
		this.naziv = naziv;
		this.primerci = primerci;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<Primerak> getPrimerci() {
		return primerci;
	}
	public void setPrimerci(List<Primerak> primerci) {
		this.primerci = primerci;
	}
	@Override
	public String toString() {
		return "InventarnaKnjiga [broj=" + broj + ", naziv=" + naziv + ", primerci=" + primerci + "]";
	}
	
}

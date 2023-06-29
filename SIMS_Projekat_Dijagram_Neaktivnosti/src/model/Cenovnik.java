package model;

import java.util.Date;

public class Cenovnik {
	private double clanarina;
	private double kaznaPoDanu;
	private Date pocetniDatum;
	public Cenovnik(double clanarina, double kaznaPoDanu, Date pocetniDatum) {
		super();
		this.clanarina = clanarina;
		this.kaznaPoDanu = kaznaPoDanu;
		this.pocetniDatum = pocetniDatum;
	}
	public double getClanarina() {
		return clanarina;
	}
	public void setClanarina(double clanarina) {
		this.clanarina = clanarina;
	}
	public double getKaznaPoDanu() {
		return kaznaPoDanu;
	}
	public void setKaznaPoDanu(double kaznaPoDanu) {
		this.kaznaPoDanu = kaznaPoDanu;
	}
	public Date getPocetniDatum() {
		return pocetniDatum;
	}
	public void setPocetniDatum(Date pocetniDatum) {
		this.pocetniDatum = pocetniDatum;
	}
	@Override
	public String toString() {
		return "Cenovnik [clanarina=" + clanarina + ", kaznaPoDanu=" + kaznaPoDanu + ", pocetniDatum=" + pocetniDatum
				+ "]";
	}
	
}

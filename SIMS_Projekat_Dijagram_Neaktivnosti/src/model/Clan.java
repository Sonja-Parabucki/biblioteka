package model;

import java.util.Date;
import java.util.List;

import enumeracije.TipClana;

public class Clan extends Osoba {
	private String brojClanskeKarte;
	private Date placenaClanarina;
	private List<Primerak> primerci;
	private TipClana tip;
	public Clan() {}
	public Clan(String ime, String prezime, String jmbg, String imejl, String telefon, Adresa adresa,
			String brojClanskeKarte, Date placenaClanarina, List<Primerak> primerci, TipClana tip) {
		super(ime, prezime, jmbg, imejl, telefon, adresa);
		this.brojClanskeKarte = brojClanskeKarte;
		this.placenaClanarina = placenaClanarina;
		this.primerci = primerci;
		this.tip = tip;
	}
	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}
	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	public Date getPlacenaClanarina() {
		return placenaClanarina;
	}
	public void setPlacenaClanarina(Date placenaClanarina) {
		this.placenaClanarina = placenaClanarina;
	}
	public List<Primerak> getPrimerci() {
		return primerci;
	}
	public void setPrimerci(List<Primerak> primerci) {
		this.primerci = primerci;
	}
	public TipClana getTip() {
		return tip;
	}
	public void setTip(TipClana tip) {
		this.tip = tip;
	}
	@Override
	public String toString() {
		return "Clan [brojClanskeKarte=" + brojClanskeKarte + ", placenaClanarina=" + placenaClanarina + ", primerci="
				+ primerci + ", tip=" + tip + "]";
	}
	
}

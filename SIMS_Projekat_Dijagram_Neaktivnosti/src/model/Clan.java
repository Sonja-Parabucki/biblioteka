package model;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import enumeracije.TipClana;

public class Clan extends Osoba {
	private String brojClanskeKarte;
	private LocalDate placenaClanarina;
	private List<Iznajmljivanje> iznajmljivanje;
	private TipClana tip;
	public Clan(String ime, String prezime, String jmbg, String imejl, String telefon, Adresa adresa,
			String brojClanskeKarte, LocalDate placenaClanarina, List<Iznajmljivanje> iznajmljivanje, TipClana tip) {
		super(ime, prezime, jmbg, imejl, telefon, adresa);
		this.brojClanskeKarte = brojClanskeKarte;
		this.placenaClanarina = placenaClanarina;
		this.iznajmljivanje = iznajmljivanje;
		this.tip = tip;
	}
	public Clan(String ime, String prezime, String jmbg, String imejl, String telefon, Adresa adresa,
	String brojClanskeKarte, TipClana tip) {
		super(ime, prezime, jmbg, imejl, telefon, adresa);
		this.brojClanskeKarte = brojClanskeKarte;
		this.placenaClanarina = LocalDate.now();
;		this.iznajmljivanje = new ArrayList<Iznajmljivanje>();
		this.tip = tip;
	}
	
	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}
	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	public LocalDate getPlacenaClanarina() {
		return placenaClanarina;
	}
	public void setPlacenaClanarina(LocalDate placenaClanarina) {
		this.placenaClanarina = placenaClanarina;
	}
	public List<Iznajmljivanje> getPrimerci() {
		return iznajmljivanje;
	}
	public void setPrimerci(List<Iznajmljivanje> iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
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
				+ iznajmljivanje + ", tip=" + tip + "]";
	}
	
}

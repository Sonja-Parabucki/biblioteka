package model;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;

import enumeracije.TipClana;

public class Clan extends Osoba {
	private String brojClanskeKarte;
	private String placenaClanarina;
	private List<Iznajmljivanje> iznajmljivanja;
	private TipClana tip;
	
	public Clan() {}
	
	public Clan(String ime, String prezime, String jmbg, String imejl, String telefon, Adresa adresa,
			String brojClanskeKarte, String placenaClanarina, List<Iznajmljivanje> iznajmljivanje, TipClana tip) {
		super(ime, prezime, jmbg, imejl, telefon, adresa);
		this.brojClanskeKarte = brojClanskeKarte;
		this.placenaClanarina = placenaClanarina;
		this.iznajmljivanja = iznajmljivanje;
		this.tip = tip;
	}
	
	public Clan(String ime, String prezime, String jmbg, String imejl, String telefon, Adresa adresa,
	String brojClanskeKarte, TipClana tip) {
		super(ime, prezime, jmbg, imejl, telefon, adresa);
		this.brojClanskeKarte = brojClanskeKarte;
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(date);
		this.placenaClanarina = strDate;
		
;		this.iznajmljivanja = new ArrayList<Iznajmljivanje>();
		this.tip = tip;
	}
	
	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}
	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	public String getPlacenaClanarina() {
		return placenaClanarina;
	}
	public void setPlacenaClanarina(String placenaClanarina) {
		this.placenaClanarina = placenaClanarina;
	}
	public List<Iznajmljivanje> getPrimerci() {
		return iznajmljivanja;
	}
	public void setPrimerci(List<Iznajmljivanje> iznajmljivanje) {
		this.iznajmljivanja = iznajmljivanje;
	}
	public TipClana getTip() {
		return tip;
	}
	public void setTip(TipClana tip) {
		this.tip = tip;
	}
	@Override
	public String toString() {
		return "Clan [brojClanskeKarte=" + brojClanskeKarte + ", placenaClanarina=" + placenaClanarina + ", iznajmljivanja="
				+ iznajmljivanja + ", tip=" + tip + "]";
	}
	
}

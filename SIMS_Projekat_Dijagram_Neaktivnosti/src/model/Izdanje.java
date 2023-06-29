package model;

import java.util.Date;
import java.util.List;

import enumeracije.TipKoricenja;

public class Izdanje extends Knjiga {
	
	private String opis;
	private String udk;
	private String isbn;
	private Date godinaIzdanja;
	private TipKoricenja koricenje;
	private Izdavac izdavac;
	private List<Primerak> primerci;
	public Izdanje(String naziv, String jezik, List<Autor> autori, String opis, String udk, String isbn,
			Date godinaIzdanja, TipKoricenja koricenje, Izdavac izdavac, List<Primerak> primerci) {
		super(naziv, jezik, autori);
		this.opis = opis;
		this.udk = udk;
		this.isbn = isbn;
		this.godinaIzdanja = godinaIzdanja;
		this.koricenje = koricenje;
		this.izdavac = izdavac;
		this.primerci = primerci;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getUdk() {
		return udk;
	}
	public void setUdk(String udk) {
		this.udk = udk;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getGodinaIzdanja() {
		return godinaIzdanja;
	}
	public void setGodinaIzdanja(Date godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}
	public TipKoricenja getKoricenje() {
		return koricenje;
	}
	public void setKoricenje(TipKoricenja koricenje) {
		this.koricenje = koricenje;
	}
	public Izdavac getIzdavac() {
		return izdavac;
	}
	public void setIzdavac(Izdavac izdavac) {
		this.izdavac = izdavac;
	}
	public List<Primerak> getPrimerci() {
		return primerci;
	}
	public void setPrimerci(List<Primerak> primerci) {
		this.primerci = primerci;
	}
	@Override
	public String toString() {
		return "Izdanje [opis=" + opis + ", udk=" + udk + ", isbn=" + isbn + ", godinaIzdanja=" + godinaIzdanja
				+ ", koricenje=" + koricenje + ", izdavac=" + izdavac + ", primerci=" + primerci + "]";
	}

}
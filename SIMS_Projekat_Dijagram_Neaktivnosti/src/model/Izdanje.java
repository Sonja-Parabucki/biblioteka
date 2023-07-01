package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import enumeracije.TipKoricenja;

public class Izdanje extends Knjiga {
	
	private int id;
	private String opis;
	private String udk;
	private String isbn;
	private int godinaIzdanja;
	private TipKoricenja koricenje;
	private Izdavac izdavac;
	private List<Primerak> primerci;
	
	public Izdanje() {
		super();
	}
	
	public Izdanje(int id, String naziv, String jezik, List<Zanr> zanrovi, List<Autor> autori, String opis, String udk, String isbn,
			int godinaIzdanja, TipKoricenja koricenje, Izdavac izdavac) {
		super(naziv, jezik, autori, zanrovi);
		this.id = id;
		this.opis = opis;
		this.udk = udk;
		this.isbn = isbn;
		this.godinaIzdanja = godinaIzdanja;
		this.koricenje = koricenje;
		this.izdavac = izdavac;
		this.primerci = new ArrayList<Primerak>();
	}
	
	public Izdanje(int id, String naziv, String jezik, List<Zanr> zanrovi, List<Autor> autori, String opis, String udk, String isbn,
			int godinaIzdanja, TipKoricenja koricenje, Izdavac izdavac, List<Primerak> primerci) {

		super(naziv, jezik, autori, zanrovi);
		this.id = id;
		this.opis = opis;
		this.udk = udk;
		this.isbn = isbn;
		this.godinaIzdanja = godinaIzdanja;
		this.koricenje = koricenje;
		this.izdavac = izdavac;
		this.primerci = primerci;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int getGodinaIzdanja() {
		return godinaIzdanja;
	}
	public void setGodinaIzdanja(int godinaIzdanja) {
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Izdanje other = (Izdanje) obj;
		return Objects.equals(godinaIzdanja, other.godinaIzdanja) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(izdavac, other.izdavac) && koricenje == other.koricenje
				&& Objects.equals(autori, other.autori) && Objects.equals(naziv, other.naziv);
	}

}

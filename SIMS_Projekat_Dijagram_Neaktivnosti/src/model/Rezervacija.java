package model;

import java.util.Date;

public class Rezervacija {
	private Date datumKreiranja;
	private boolean preuzeo;
	private Date datumDodele;
	private Knjiga knjiga;
	private Primerak primerak;
	private Clan clan;
	
	public Rezervacija() {}
	public Rezervacija(Date datumKreiranja, boolean preuzeo, Date datumDodele, Knjiga knjiga, Primerak primerak,
			Clan clan) {
		super();
		this.datumKreiranja = datumKreiranja;
		this.preuzeo = preuzeo;
		this.datumDodele = datumDodele;
		this.knjiga = knjiga;
		this.primerak = primerak;
		this.clan = clan;
	}
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public boolean isPreuzeo() {
		return preuzeo;
	}
	public void setPreuzeo(boolean preuzeo) {
		this.preuzeo = preuzeo;
	}
	public Date getDatumDodele() {
		return datumDodele;
	}
	public void setDatumDodele(Date datumDodele) {
		this.datumDodele = datumDodele;
	}
	public Knjiga getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}
	public Primerak getPrimerak() {
		return primerak;
	}
	public void setPrimerak(Primerak primerak) {
		this.primerak = primerak;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
	@Override
	public String toString() {
		return "Rezervacija [datumKreiranja=" + datumKreiranja + ", preuzeo=" + preuzeo + ", datumDodele=" + datumDodele
				+ ", knjiga=" + knjiga + ", primerak=" + primerak + ", clan=" + clan + "]";
	}
	
}

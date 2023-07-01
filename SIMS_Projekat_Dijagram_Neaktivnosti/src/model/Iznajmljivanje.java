package model;

import java.util.Date;

public class Iznajmljivanje {
	private Date datumIznajmljivanja;
	private Date datumVracanja;
	private boolean produzen;
	private Primerak primerak;
	private Clan clan;
	
	public Iznajmljivanje() {}
	public Iznajmljivanje(Date datumIznajmljivanja, Date datumVracanja, boolean produzen, Primerak primerak,
			Clan clan) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.produzen = produzen;
		this.primerak = primerak;
		this.clan = clan;
	}
	public Date getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(Date datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public Date getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(Date datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	public boolean isProduzen() {
		return produzen;
	}
	public void setProduzen(boolean produzen) {
		this.produzen = produzen;
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
		return "Iznajmljivanje [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", produzen=" + produzen + ", primerak=" + primerak + ", clan=" + clan + "]";
	}
	
}

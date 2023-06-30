package model;

import java.util.Date;

public class Iznajmljivanje {
	private Date datumIznajmljivanja;
	private Date datumVracanja;
	private boolean produzen;
	private Primerak primerak;
	
	public Iznajmljivanje(Date datumIznajmljivanja, Date datumVracanja, boolean produzen, Primerak primerak) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.produzen = produzen;
		this.primerak = primerak;
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
	@Override
	public String toString() {
		return "Iznajmljivanje [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", produzen=" + produzen + ", primerak=" + primerak + "]";
	}
	
}

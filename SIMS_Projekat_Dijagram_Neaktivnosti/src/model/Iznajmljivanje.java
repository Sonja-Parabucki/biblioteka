package model;

public class Iznajmljivanje {
	private String datumIznajmljivanja;
	private String datumVracanja;
	private boolean produzen;
	private Primerak primerak;

	public Iznajmljivanje() {}
	
	public Iznajmljivanje(String datumIznajmljivanja, String datumVracanja, boolean produzen, Primerak primerak) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.produzen = produzen;
		this.primerak = primerak;
	}
	public String getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(String datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public String getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(String datumVracanja) {
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

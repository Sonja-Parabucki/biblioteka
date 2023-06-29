package model;

import java.util.Date;

import enumeracije.StatusZahteva;

public class ZahtevZaProduzenje {
	private Date datumZahteva;
	private StatusZahteva status;
	private Iznajmljivanje iznajmljivanje;
	public ZahtevZaProduzenje(Date datumZahteva, StatusZahteva status, Iznajmljivanje iznajmljivanje) {
		super();
		this.datumZahteva = datumZahteva;
		this.status = status;
		this.iznajmljivanje = iznajmljivanje;
	}
	public Date getDatumZahteva() {
		return datumZahteva;
	}
	public void setDatumZahteva(Date datumZahteva) {
		this.datumZahteva = datumZahteva;
	}
	public StatusZahteva getStatus() {
		return status;
	}
	public void setStatus(StatusZahteva status) {
		this.status = status;
	}
	public Iznajmljivanje getIznajmljivanje() {
		return iznajmljivanje;
	}
	public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
	}
	@Override
	public String toString() {
		return "ZahtevZaProduzenje [datumZahteva=" + datumZahteva + ", status=" + status + ", iznajmljivanje="
				+ iznajmljivanje + "]";
	}
	
	
}

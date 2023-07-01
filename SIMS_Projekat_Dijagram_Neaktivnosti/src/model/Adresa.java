package model;

public class Adresa {
	private String ulica;
	private String broj;
	private Mesto mesto;
	public Adresa(String ulica, String broj, Mesto mesto) {
		super();
		this.ulica = ulica;
		this.broj = broj;
		this.mesto = mesto;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public Mesto getMesto() {
		return mesto;
	}
	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}
	@Override
	public String toString() {
		return "Adresa [ulica=" + ulica + ", broj=" + broj + ", mesto=" + mesto + "]";
	}
}

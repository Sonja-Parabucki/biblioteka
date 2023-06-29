package model;

public class Adresa {
	private String ulica;
	private int broj;
	private Mesto mesto;
	public Adresa(String ulica, int broj, Mesto mesto) {
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
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
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

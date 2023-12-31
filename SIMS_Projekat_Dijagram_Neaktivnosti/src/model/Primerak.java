package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import enumeracije.StanjePrimerka;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Primerak {
	private int inventarniBroj;
	private double nabavnaCena;
	private StanjePrimerka stanje;
	
	public Primerak() {}
	
	public Primerak(int inventarniBroj, double nabavnaCena, StanjePrimerka stanje) {
		super();
		this.inventarniBroj = inventarniBroj;
		this.nabavnaCena = nabavnaCena;
		this.stanje = stanje;
	}
	public int getInventarniBroj() {
		return inventarniBroj;
	}
	public void setInventarniBroj(int inventarniBroj) {
		this.inventarniBroj = inventarniBroj;
	}
	public double getNabavnaCena() {
		return nabavnaCena;
	}
	public void setNabavnaCena(double nabavnaCena) {
		this.nabavnaCena = nabavnaCena;
	}
	public StanjePrimerka getStanje() {
		return stanje;
	}
	public void setStanje(StanjePrimerka stanje) {
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return "Primerak [inventarniBroj=" + inventarniBroj + ", nabavnaCena=" + nabavnaCena + ", stanje=" + stanje + "]";
	}
	
	public String naziv() {
		return Integer.toString(inventarniBroj);
	}

	
}

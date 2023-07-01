package model;

import enumeracije.StanjePrimerka;

public class Primerak {
	private int inventarniBroj;
	private double nabavnaCena;
	private StanjePrimerka stanje;
//	private Izdanje izdanje;
	
	public Primerak () {}	
	
	public Primerak(int inventarniBroj, double nabavnaCena, StanjePrimerka stanje) {
		super();
		this.inventarniBroj = inventarniBroj;
		this.nabavnaCena = nabavnaCena;
		this.stanje = stanje;
//		this.izdanje = izdanje;
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
//	public Izdanje getIzdanje() {
//		return izdanje;
//	}
//	public void setIzdanje(Izdanje izdanje) {
//		this.izdanje = izdanje;
//	}
//	@Override
//	public String toString() {
//		return "Primerak [inventarniBroj=" + inventarniBroj + ", nabavnaCena=" + nabavnaCena + ", stanje=" + stanje
//				+ ", izdanje=" + izdanje + "]";
//	}
	
}

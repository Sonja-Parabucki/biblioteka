package model;

import java.util.List;

import enumeracije.TipClana;

public class Propisi {
	private int brojKnjiga;
	private int brojDana;
	private int brojSlikovnica;
	private TipClana tipClana;
	private List<Cenovnik> cenovnici;
	public Propisi() {}
	public Propisi(int brojKnjiga, int brojDana, int brojSlikovnica, TipClana tipClana, List<Cenovnik> cenovnici) {
		super();
		this.brojKnjiga = brojKnjiga;
		this.brojDana = brojDana;
		this.brojSlikovnica = brojSlikovnica;
		this.tipClana = tipClana;
		this.cenovnici = cenovnici;
	}
	public int getBrojKnjiga() {
		return brojKnjiga;
	}
	public void setBrojKnjiga(int brojKnjiga) {
		this.brojKnjiga = brojKnjiga;
	}
	public int getBrojDana() {
		return brojDana;
	}
	public void setBrojDana(int brojDana) {
		this.brojDana = brojDana;
	}
	public int getBrojSlikovnica() {
		return brojSlikovnica;
	}
	public void setBrojSlikovnica(int brojSlikovnica) {
		this.brojSlikovnica = brojSlikovnica;
	}
	public TipClana getTipClana() {
		return tipClana;
	}
	public void setTipClana(TipClana tipClana) {
		this.tipClana = tipClana;
	}
	public List<Cenovnik> getCenovnici() {
		return cenovnici;
	}
	public void setCenovnici(List<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}
	@Override
	public String toString() {
		return "Propisi [brojKnjiga=" + brojKnjiga + ", brojDana=" + brojDana + ", brojSlikovnica=" + brojSlikovnica
				+ ", tipClana=" + tipClana + ", cenovnici=" + cenovnici + "]";
	}
	
	
}

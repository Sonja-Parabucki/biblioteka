package model;

public class Mesto {
	private String naziv;
	private int pptBroj;
	
	public Mesto() {}
	
	public Mesto(String naziv, int pptBroj) {
		super();
		this.naziv = naziv;
		this.pptBroj = pptBroj;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getPptBroj() {
		return pptBroj;
	}
	public void setPptBroj(int pptBroj) {
		this.pptBroj = pptBroj;
	}
	@Override
	public String toString() {
		return "Mesto [naziv=" + naziv + ", pptBroj=" + pptBroj + "]";
	}
}

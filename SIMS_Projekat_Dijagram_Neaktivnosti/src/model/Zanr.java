package model;

public class Zanr {
	private String naziv;

	public Zanr() {}
	public Zanr(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return naziv;
	}
	
}

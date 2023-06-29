package model;

import java.util.Date;
import java.util.List;

public class Autor {
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private Date datumSmrti = null;
	private List<Knjiga> knjige;
	public Autor(String ime, String prezime, Date datumRodjenja, Date datumSmrti, List<Knjiga> knjige) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.datumSmrti = datumSmrti;
		this.knjige = knjige;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public Date getDatumSmrti() {
		return datumSmrti;
	}
	public void setDatumSmrti(Date datumSmrti) {
		this.datumSmrti = datumSmrti;
	}
	public List<Knjiga> getKnjige() {
		return knjige;
	}
	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja + ", datumSmrti="
				+ datumSmrti + ", knjige=" + knjige + "]";
	}
	
}

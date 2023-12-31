package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Autor {

	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String datumSmrti = null;
	
	public Autor() {}
//	public Autor(String ime, String prezime, String datumRodjenja, String datumSmrti, List<Knjiga> dela) {
//		super();
//		this.ime = ime;
//		this.prezime = prezime;
//		this.datumRodjenja = datumRodjenja;
//		this.datumSmrti = datumSmrti;
//	}
	public Autor(String ime, String prezime, String datumRodjenja, String datumSmrti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.datumSmrti = datumSmrti;
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
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getDatumSmrti() {
		return datumSmrti;
	}
	public void setDatumSmrti(String datumSmrti) {
		this.datumSmrti = datumSmrti;
	}
	@Override
	public String toString() {
		return ime + " " + prezime + ", " + datumRodjenja;
	}
	@Override
	public boolean equals(Object obj) {
		Autor a = (Autor)obj;
		return ime.equals(a.ime) && prezime.equals(a.prezime) && datumRodjenja.equals(a.datumRodjenja);
	}
}

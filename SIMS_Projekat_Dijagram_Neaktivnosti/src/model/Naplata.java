package model;

import java.util.Date;

import enumeracije.TipNaplate;

public class Naplata {
	private double iznos;
	private Date datum;
	private TipNaplate tip;
	private Clan clan;
	
	public Naplata() {}
	public Naplata(double iznos, Date datum, TipNaplate tip, Clan clan) {
		super();
		this.iznos = iznos;
		this.datum = datum;
		this.tip = tip;
		this.clan = clan;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public TipNaplate getTip() {
		return tip;
	}
	public void setTip(TipNaplate tip) {
		this.tip = tip;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
	@Override
	public String toString() {
		return "Naplata [iznos=" + iznos + ", datum=" + datum + ", tip=" + tip + ", clan=" + clan + "]";
	}
	
	
}

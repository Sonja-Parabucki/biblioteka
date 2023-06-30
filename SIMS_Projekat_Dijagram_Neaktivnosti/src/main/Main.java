package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import enumeracije.TipNaloga;
import model.Biblioteka;
import model.Nalog;
import pogled.Prijava;
import repozitorijumi.ClanRepo;
import repozitorijumi.NalogRepo;

public class Main {

	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		
		NalogRepo s = new NalogRepo();
		try {
			biblioteka.setNalozi(s.ucitajNaloge());
			
			Prijava prozor = new Prijava(biblioteka);
			prozor.setVisible(true);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		///
		ClanRepo c;
		try {
			c = new ClanRepo();
			c.ucitajClanove();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

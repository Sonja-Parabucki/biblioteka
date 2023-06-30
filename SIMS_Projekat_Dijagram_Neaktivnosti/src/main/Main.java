package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import enumeracije.TipNaloga;
import model.Biblioteka;
import model.Nalog;
import pogled.Prijava;
import repozitorijumi.KorisnikRepo;

public class Main {

	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		
		KorisnikRepo s = new KorisnikRepo();
		try {
			biblioteka.setNalozi(s.ucitajNaloge());
			
			Prijava prozor = new Prijava(biblioteka);
			prozor.setVisible(true);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

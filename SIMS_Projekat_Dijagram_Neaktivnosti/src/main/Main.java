package main;

import java.io.IOException;

import model.Biblioteka;
import pogled.Prijava;
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
		
	}

}

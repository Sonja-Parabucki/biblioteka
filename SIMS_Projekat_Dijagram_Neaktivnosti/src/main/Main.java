package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import enumeracije.TipNaloga;
import model.Biblioteka;
import model.Nalog;
import pogled.Prijava;
import serijalizacija.Serijalizator;

public class Main {

	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		
		Serijalizator s = new Serijalizator();
		try {
			biblioteka.setNalozi(s.ucitajNaloge());
			
			Nalog nalog = new Nalog("clan", "clan", TipNaloga.CLAN, null);
			Nalog nalog1 = new Nalog("k", "k", TipNaloga.VISI_BIBLIOTEKAR, null);
			List<Nalog> nalozi = new ArrayList<Nalog>();
			nalozi.add(nalog);
			nalozi.add(nalog1);
			s.sacuvajNaloge(nalozi);
			
			Prijava prozor = new Prijava(biblioteka);
			prozor.setVisible(true);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import enumeracije.TipKoricenja;
import enumeracije.TipNaloga;
import model.Autor;
import model.Biblioteka;
import model.Izdanje;
import model.Nalog;
import model.Primerak;
import pogled.Prijava;
import repozitorijumi.Serijalizator;

public class Main {

	public static void main(String[] args) {
		Biblioteka biblioteka = new Biblioteka();
		
		Serijalizator s = new Serijalizator();
		try {
			biblioteka.setNalozi(s.ucitajNaloge());
			
			Nalog nalog = new Nalog("clan", "clan", TipNaloga.CLAN, null);
			Nalog nalog1 = new Nalog("k", "k", TipNaloga.VISI_BIBLIOTEKAR, null);
			List<Izdanje> izdanja = new ArrayList<Izdanje>();
			izdanja.add(new Izdanje("aa", "aa", new ArrayList<Autor>(), "a", "udkkaaa", "isbnaap", null, TipKoricenja.TVRD_POVEZ, null, new ArrayList<Primerak>()));
			izdanja.add(new Izdanje("bb", "bb", new ArrayList<Autor>(), "b", "udkkbbb", "isbnaal", null, TipKoricenja.TVRD_POVEZ, null, new ArrayList<Primerak>()));
			izdanja.add(new Izdanje("vv", "vv", new ArrayList<Autor>(), "v", "udkkvvvvv", "isbnaas", null, TipKoricenja.TVRD_POVEZ, null, new ArrayList<Primerak>()));
			izdanja.add(new Izdanje("gg", "gg", new ArrayList<Autor>(), "b", "udkkbbb", "isbnaal", null, TipKoricenja.TVRD_POVEZ, null, new ArrayList<Primerak>()));
			List<Nalog> nalozi = new ArrayList<Nalog>();
			nalozi.add(nalog);
			nalozi.add(nalog1);
			biblioteka.setIzdanja(izdanja);
			s.sacuvajNaloge(nalozi);
			
			Prijava prozor = new Prijava(biblioteka);
			prozor.setVisible(true);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

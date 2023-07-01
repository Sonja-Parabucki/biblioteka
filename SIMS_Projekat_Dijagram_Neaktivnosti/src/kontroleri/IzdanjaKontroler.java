package kontroleri;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import enumeracije.TipKoricenja;
import model.Autor;
import model.Biblioteka;
import model.Izdanje;
import model.Izdavac;
import model.Zanr;
import repo.IzdanjaRepo;

public class IzdanjaKontroler {
	
	private Biblioteka biblioteka;
	private IzdanjaRepo repo;
	
	public IzdanjaKontroler(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		this.repo = new IzdanjaRepo();
	}
	
	public boolean dodajNovo
	(String naziv, String jezik, List<Zanr> zanrovi, List<Autor> autori, String opis, String udk, String isbn,
			Date godinaIzdanja, TipKoricenja koricenje, Izdavac izdavac) 
					throws IOException {
		int id = repo.noviID();
		Izdanje izdanje = new Izdanje(id, naziv, jezik, zanrovi, autori, opis, udk, isbn, godinaIzdanja, koricenje, izdavac);
		if (repo.postoji(izdanje)) return false;
		
		repo.dodajIzdanje(izdanje);
		return true;
	}
}

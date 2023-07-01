package kontroleri;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import enumeracije.TipKoricenja;
import model.Autor;
import model.Biblioteka;
import model.Izdanje;
import model.Izdavac;
import model.Knjiga;
import model.Zanr;
import repozitorijumi.IzdanjaRepo;


public class IzdanjaKontroler {
	
	private Biblioteka biblioteka;
	private IzdanjaRepo repo;
	
	public IzdanjaKontroler(Biblioteka biblioteka) throws IOException {
		this.biblioteka = biblioteka;
		this.repo = new IzdanjaRepo();
	}
	
	public boolean dodajNovo
	(String naziv, String jezik, List<Zanr> zanrovi, List<Autor> autori, String opis, String udk, String isbn,
			int godinaIzdanja, TipKoricenja koricenje, Izdavac izdavac) 
					throws IOException {
		int id = repo.noviID();
		Izdanje izdanje = new Izdanje(id, naziv, jezik, zanrovi, autori, opis, udk, isbn, godinaIzdanja, koricenje, izdavac);
		if (repo.postoji(izdanje)) return false;
		
		repo.dodajIzdanje(izdanje);
		
		biblioteka.dodajIzdanje(izdanje);
		for (Autor autor: autori) {
			autor.dodajDelo(izdanje);
		}
		izdavac.dodajIzdanje(izdanje);
		
		return true;
	}
	
	
	public List<Izdanje> nadjiSveKnjige(){
		return repo.nadjiSveKnjige();
	}
	
	public List<Izdanje> nadjiSvaIzdanja(Knjiga knjiga){
		return repo.nadjiSvaIzdanja(knjiga);
	}
	
	public Set<Izdavac> nadjiSveIzdavace(){
		return repo.nadjiSveIzdavace();
	}
	
	public Set<Autor> nadjiSveAutore(){
		return repo.nadjiSveAutore();
	}
	
	public Set<Zanr> nadjiSveZanrove(){
		return repo.nadjiSveZanrove();
	}

}

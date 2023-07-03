package kontroleri;

import java.io.IOException;

import enumeracije.StanjePrimerka;
import izuzeci.BadFormatException;
import model.Biblioteka;
import model.Primerak;
import repozitorijumi.IzdanjaRepo;
import repozitorijumi.PrimerakRepo;
import util.Validacija;

public class PrimerakKontroler {
	private Biblioteka biblioteka;

	public PrimerakKontroler(Biblioteka biblioteka) {
		super();
		this.biblioteka = biblioteka;
		
	}
	
	public void dodajPrimerak(String cena, int izdanje) throws BadFormatException, IOException {
		if(!Validacija.proveriCenu(cena)) {
			throw new BadFormatException("Cena nije broj veći od nule.");
		}
		double c = Double.parseDouble(cena);
		
		PrimerakRepo pR = new PrimerakRepo();
		
		Primerak p = new Primerak(pR.generisiInvBroj(), c, StanjePrimerka.DOSTUPAN);
		
		this.biblioteka.dodajPrimerak(p, izdanje);
		pR.dodajPrimerak(p);
		
		IzdanjaRepo iR = new IzdanjaRepo();
		iR.dodajPrimerak(p, izdanje);
	}
	
	public void promeniCenu(int id, int cena) throws IOException {
		PrimerakRepo repo = new PrimerakRepo();
		repo.promeniCenu(id, cena);
	}
}

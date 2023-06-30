package kontroleri;

import izuzeci.BadCredentialsException;
import izuzeci.MissingValueException;
import model.Biblioteka;
import model.Nalog;

public class NaloziKontroler {
	
		private Biblioteka biblioteka;
		
		public NaloziKontroler(Biblioteka biblioteka) {
			this.biblioteka = biblioteka;
		}
		
		public void login(String korisnickoIme, String lozinka) throws MissingValueException, BadCredentialsException {
			if (checkIfNullOrEmpty(korisnickoIme)) {
				throw new MissingValueException("Nije validno uneto korisničko ime.");
			} else if (checkIfNullOrEmpty(lozinka)) {
				throw new MissingValueException("Nije validno uneta lozinka.");
			}
			
			Nalog nalog = nadjiNalog(korisnickoIme);
			if (nalog == null || !nalog.getLozinka().equals(lozinka)) {
				throw new BadCredentialsException("Uneti kredencijali nisu odgovarajući.");
			}
			
			biblioteka.setPrijavljeniKorisnik(nalog);
		}
		
		private Nalog nadjiNalog(String korisnickoIme) {
			for (Nalog nalog : biblioteka.getNalozi()) {
				if (nalog.getKorisnickoIme().equals(korisnickoIme))
					return nalog;
			}
			return null;
		}

		private boolean checkIfNullOrEmpty(String input) {
			return input == null || input.equals("");
		}
	}

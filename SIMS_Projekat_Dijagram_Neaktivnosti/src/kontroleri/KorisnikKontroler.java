package kontroleri;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import enumeracije.TipClana;
import izuzeci.BadCredentialsException;
import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.UniqueValueException;
import model.Biblioteka;
import model.Nalog;
import util.Bezbednost;
import util.Validacija;

public class KorisnikKontroler {
	
		private Biblioteka biblioteka;
		
		public KorisnikKontroler(Biblioteka biblioteka) {
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
		
		public void registrujClana(String ime, String prezime, String JMBG, String mejl, String telefon, String mesto, String broj, String ulica,
				String korIme, String lozinka, String clanskaKarta, String tip) throws MissingValueException, BadFormatException, UniqueValueException {
			
			Nalog nalog = nadjiNalog(korIme);
			if (nalog != null) {
				throw new UniqueValueException("Uneto korisničko ime je već registrovano.");
			} else if (Validacija.praznaIliNepostojecaVrednost(ime)) {
				throw new MissingValueException("Nije validno uneto ime.");
			} else if (Validacija.praznaIliNepostojecaVrednost(prezime)) {
				throw new MissingValueException("Nije validno uneto prezime.");
			} else if (Validacija.praznaIliNepostojecaVrednost(telefon)) {
				throw new MissingValueException("Nije validno unet telefon.");
			} else if (!Validacija.validanTelefon(telefon)) {
				throw new BadFormatException("Broj telefona može da sadrži samo cifre 0-9.");
			} else if (Validacija.praznaIliNepostojecaVrednost(mejl)) {
				throw new MissingValueException("Nije validno uneta email adresa.");
			} else if (!Validacija.validanEmail(mejl)) {
				throw new BadFormatException("Email adresa nije uneta u validnom formatu. Mora biti oblika text@text.text");
			} else if (Validacija.praznaIliNepostojecaVrednost(JMBG)) {
				throw new MissingValueException("Nije validno unet JMBG.");
			} else if (Validacija.praznaIliNepostojecaVrednost(mesto)) {
				throw new MissingValueException("Nije validno uneto mesto.");
			} else if (Validacija.praznaIliNepostojecaVrednost(ulica)) {
				throw new MissingValueException("Nije validno unet ulica.");
			} else if (Validacija.praznaIliNepostojecaVrednost(broj)) {
				throw new MissingValueException("Nije validno unet broj.");
			} else if (Validacija.praznaIliNepostojecaVrednost(clanskaKarta)) {
				throw new MissingValueException("Nije validno unet broj clanske karte.");
			} else if (!Validacija.validanJMBG(JMBG)) {
				throw new BadFormatException("JMBG nije unet u validnom formatu. Mora biti sadrzati 13 cifara");
			} else if (Validacija.praznaIliNepostojecaVrednost(korIme)) {
				throw new MissingValueException("Nije uneto korisničko ime.");
			} else if (Validacija.praznaIliNepostojecaVrednost(lozinka)) {
				throw new MissingValueException("Nije uneta lozinka.");
			} else if (!Validacija.validnaLozinka(lozinka)) {
				throw new BadFormatException("Lozinka mora da sadrži bar 8 karaktera, od čega bar jedno veliko slovo, malo slovo i broj.");
			}
			
			//dodaj u listu necega
			
		}

		private boolean checkIfNullOrEmpty(String input) {
			return input == null || input.equals("");
		}
	}

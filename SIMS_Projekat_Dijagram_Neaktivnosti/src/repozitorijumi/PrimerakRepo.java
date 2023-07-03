package repozitorijumi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.Nalog;
import model.Primerak;

public class PrimerakRepo {
	
	private List<Primerak> primerci;
	
	public PrimerakRepo() {
		try {
			primerci = ucitajPrimerke();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sacuvajPrimerke() throws IOException {
		File fajlPrimerci = new File("./podaci/primerci.json");
		
		OutputStream osPrimerci = new BufferedOutputStream(new FileOutputStream(fajlPrimerci));
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			
			//mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(Visibility.ANY));
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			
			mapper.writeValue(fajlPrimerci, primerci);

			
		} finally {
			osPrimerci.close();
		}
	}
	
	private List<Primerak> ucitajPrimerke() throws IOException {
		List<Primerak> primerci = new ArrayList<Primerak>();
		
		File fajlPrimerci = new File("./podaci/primerci.json");
		
		InputStream isPrimerci = new BufferedInputStream(new FileInputStream(fajlPrimerci));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		try {
			primerci = mapper.readValue(fajlPrimerci, new TypeReference<List<Primerak>>() {});
			
		} finally {
			isPrimerci.close();
		}
		return primerci;
	}
	
	public void dodajPrimerak(Primerak p) throws IOException {
		this.primerci.add(p);
		sacuvajPrimerke();
	}
	
	public int generisiInvBroj() {
		int i = 1;
		while (true) {
			if (!nadjiInvBroj(i)) {
				return i;
			}
			i++;
		}
	}
	
	private boolean nadjiInvBroj(int broj) {
		for(Primerak p : this.primerci) {
			if (p.getInventarniBroj() == broj) return true;
		}
		return false;
	}
	
	public void promeniCenu(int id, double cena) throws IOException {
		for(Primerak p : this.primerci) {
			if (p.getInventarniBroj() == id) {
				p.setNabavnaCena(cena);
				sacuvajPrimerke();
			}
		}
	}
}

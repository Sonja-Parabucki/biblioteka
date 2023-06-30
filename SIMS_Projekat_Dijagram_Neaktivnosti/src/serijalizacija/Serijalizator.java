package serijalizacija;

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



public class Serijalizator {

	public void sacuvajNaloge(List<Nalog> nalozi) throws IOException {
		File fajlNalozi = new File("./podaci/nalozi.json");
		
		OutputStream osNalozi = new BufferedOutputStream(new FileOutputStream(fajlNalozi));
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			
			//mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(Visibility.ANY));
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			
			mapper.writeValue(fajlNalozi, nalozi);

			
		} finally {
			osNalozi.close();
		}
	}
	
	public List<Nalog> ucitajNaloge() throws IOException {
		List<Nalog> nalozi = new ArrayList<Nalog>();
		
		File fajlNalozi = new File("./podaci/nalozi.json");
		
		InputStream isNalozi = new BufferedInputStream(new FileInputStream(fajlNalozi));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		try {
			nalozi = mapper.readValue(fajlNalozi, new TypeReference<List<Nalog>>() {});
			
			
		} finally {
			isNalozi.close();
		}
		return nalozi;			
	}
	
}

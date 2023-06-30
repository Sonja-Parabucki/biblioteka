package enumeracije;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public enum TipClana {
	DETE,
	STUDENT,
	PENZIONER,
	ODRASLA_OSOBA,
	DJAK
}

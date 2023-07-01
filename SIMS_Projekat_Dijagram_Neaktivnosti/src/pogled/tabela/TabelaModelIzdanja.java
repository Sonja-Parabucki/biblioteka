package pogled.tabela;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import enumeracije.TipKoricenja;
import model.Autor;
import model.Izdanje;
import model.Knjiga;
import model.Zanr;

public class TabelaModelIzdanja extends AbstractTableModel{

	private static final long serialVersionUID = -4732328582395183355L;
	private List<Izdanje> izdanja;
	
	public TabelaModelIzdanja(List<Izdanje> izdanja) {
		this.izdanja = izdanja;
	}
	
	public void dodajIzdanja(Izdanje izdanje) {
		this.izdanja.add(izdanje);
	}
	
	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return izdanja.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Opis";
		case 1:
			return "UDK";
		case 2:
			return "ISBN";
		case 3:
			return "Godina izdanja";
		case 4:
			return "Tip koričenja";
		case 5:
			return "Izdavač";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return LocalDate.class;
		case 4:
			return TipKoricenja.class;
		case 5:
			return String.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Izdanje izdanje = izdanja.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return izdanje.getOpis();
		case 1:
			return izdanje.getUdk();
		case 2:
			return izdanje.getIsbn();
		case 3:
			return izdanje.getGodinaIzdanja();
		case 4:
			return izdanje.getKoricenje();
		case 5:
			try {
			return izdanje.getIzdavac().getNaziv();
			}catch(Exception e){
				return "";
			}
		default:
			return "";
		}
	}
	
	public Izdanje getIzdanje(int rowIndex) {
		return izdanja.get(rowIndex);
	}

}

package pogled.tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

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
		return 4;
	}

	@Override
	public int getRowCount() {
		return izdanja.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Naziv";
		case 1:
			return "Jezik";
		case 2:
			return "Zanr";
		case 3:
			return "Autor";
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
			return String.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Knjiga knjiga = (Knjiga)izdanja.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return knjiga.getNaziv();
		case 1:
			return knjiga.getJezik();
		case 2:
			List<Zanr> zanrovi = knjiga.getZanrovi();
			String za = "";
			try {
				for(Zanr z : zanrovi) {
					za += z.getNaziv() + ", ";
				}
				za.substring(0, za.length()-2);
			}catch(Exception e) {}
			return za;
		case 3:
			List<Autor> autori = knjiga.getAutori();
			String au = "";
			try {
			for(Autor a : autori) {
				au += a.getIme() + " " + a.getPrezime() + ", ";
			}
			au.substring(0, au.length()-2);
			}catch(Exception e) {}
			return au;
		default:
			return "";
		}
	}
	
	public Izdanje getIzdanje(int rowIndex) {
		return izdanja.get(rowIndex);
	}

}

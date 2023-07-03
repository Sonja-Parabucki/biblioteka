package pogled.tabela;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import enumeracije.TipClana;
import enumeracije.TipKoricenja;
import model.Clan;
import model.Izdanje;

public class TabelaModelClanovi extends AbstractTableModel{

	private static final long serialVersionUID = 7611602942535914161L;

	private List<Clan> clanovi;
	
	public TabelaModelClanovi(List<Clan> clanovi) {
		this.clanovi = clanovi;
	}
	
	public void dodajIzdanja(Clan clan) {
		this.clanovi.add(clan);
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return clanovi.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Broj clanske karte";
		case 1:
			return "Ime";
		case 2:
			return "Prezime";
		case 3:
			return "Tip clana";
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
			return TipClana.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Clan clan = clanovi.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return clan.getBrojClanskeKarte();
		case 1:
			return clan.getIme();
		case 2:
			return clan.getPrezime();
		case 3:
			return clan.getTip();
		default:
			return "";
		}
	}
	
	public Clan getClan(int rowIndex) {
		return clanovi.get(rowIndex);
	}

}

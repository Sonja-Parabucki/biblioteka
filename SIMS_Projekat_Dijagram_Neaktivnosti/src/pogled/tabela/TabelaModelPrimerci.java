package pogled.tabela;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import enumeracije.StanjePrimerka;
import enumeracije.TipKoricenja;
import model.Izdanje;
import model.Primerak;

public class TabelaModelPrimerci extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Primerak> primerci;
	
	public TabelaModelPrimerci(List<Primerak> primerci) {
		this.primerci = primerci;
	}
	
	public void dodajIzdanja(Primerak primerak) {
		this.primerci.add(primerak);
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return primerci.size();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Inventarni broj";
		case 1:
			return "Nabavna cena";
		case 2:
			return "Stanje";
		default:
			return "";
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return Double.class;
		case 2:
			return StanjePrimerka.class;
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Primerak primerak = primerci.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return primerak.getInventarniBroj();
		case 1:
			return primerak.getNabavnaCena();
		case 2:
			return primerak.getStanje();
		default:
			return "";
		}
	}
	
	public Primerak getPrimerak(int rowIndex) {
		return primerci.get(rowIndex);
	}
}

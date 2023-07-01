package pogled.tabela;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import util.PogledUtil;

public class TabelaIzdanja extends JTable {

	private static final long serialVersionUID = -8153561197677276582L;

	public TabelaIzdanja(TabelaModelIzdanja tabelaModelIzdanja) {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(tabelaModelIzdanja);
		this.getTableHeader().setBackground(PogledUtil.getPrimarnaBoja());
		this.getTableHeader().setForeground(PogledUtil.getForegroundColor());
		this.getTableHeader().setFont(PogledUtil.getTeksPoljeFont());
		this.setFont(PogledUtil.getTeksPoljeFont());
		this.setRowHeight(40);
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.getColumnModel().getColumn(0).setPreferredWidth(150);
		this.getColumnModel().getColumn(1).setPreferredWidth(150);
		this.getColumnModel().getColumn(2).setPreferredWidth(150);
		this.getColumnModel().getColumn(3).setPreferredWidth(150);
		this.getColumnModel().getColumn(4).setPreferredWidth(150);
		this.getColumnModel().getColumn(5).setPreferredWidth(150);
		
		TableCellRenderer stringCellRenderer = this.getDefaultRenderer(String.class);
		TableCellRenderer floatCellRenderer = this.getDefaultRenderer(Float.class);
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer)stringCellRenderer;
        DefaultTableCellRenderer floatRenderer = (DefaultTableCellRenderer)floatCellRenderer;
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        floatRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
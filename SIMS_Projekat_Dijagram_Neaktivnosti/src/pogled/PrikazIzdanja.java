package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import enumeracije.TipKoricenja;
import kontroleri.IzdanjaKontroler;
import model.Autor;
import model.Biblioteka;
import model.Izdanje;
import model.Knjiga;
import model.Zanr;
import net.miginfocom.swing.MigLayout;
import pogled.tabela.TabelaIzdanja;
import pogled.tabela.TabelaKnjiga;
import pogled.tabela.TabelaModelIzdanja;
import pogled.tabela.TabelaModelKnjiga;
import util.PogledUtil;

public class PrikazIzdanja  extends JFrame {

	private static final long serialVersionUID = -8047306579673693674L;

	private List<Izdanje> izdanja;
	//kontroleri
	
	private TabelaIzdanja tabelaIzdanja;
	private TabelaModelIzdanja tabelaModelIzdanja;
	private IzdanjaKontroler izdanjeKontroler;
	
	public PrikazIzdanja(Knjiga knjiga, Biblioteka biblioteka) {
		setSize(new Dimension(1000, 600));
		setTitle("Izdanja");
		setLocationRelativeTo(null);
		setResizable(false);
		setName("Izdanja");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		
		try {
			izdanjeKontroler = new IzdanjaKontroler(biblioteka);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			this.izdanja = izdanjeKontroler.nadjiSvaIzdanja(knjiga);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Labela lblNaslov = new Labela("Izdanja", fntNaslov, clrForeground);
	
				
		setLayout(new MigLayout("", "30[]40[]", "5[]5[]40[]"));
		
		add(lblNaslov, "wrap, span2, align center");
		this.inicijalizujTabeluZaposlenih();
	}

	private void inicijalizujTabeluZaposlenih() {
		tabelaModelIzdanja = new TabelaModelIzdanja(izdanja);
		this.tabelaIzdanja= new TabelaIzdanja(tabelaModelIzdanja);
		JScrollPane scrollPane = new JScrollPane(tabelaIzdanja);
		scrollPane.setPreferredSize(new Dimension(900, 500));

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelIzdanja model = (TabelaModelIzdanja) tabelaIzdanja.getModel();
		model.fireTableDataChanged();
		validate();
	}
}


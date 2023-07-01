package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import enumeracije.TipKoricenja;
import enumeracije.TipNaloga;
import model.Autor;
import model.Biblioteka;
import model.Izdanje;
import model.Knjiga;
import model.Zanr;
import net.miginfocom.swing.MigLayout;
import pogled.tabela.TabelaIzdanja;
import pogled.tabela.TabelaModelIzdanja;
import util.PogledUtil;

public class PrikazIzdanja  extends JFrame {

	private static final long serialVersionUID = -8047306579673693674L;

	private List<Izdanje> izdanja;
	//kontroleri
	
	private TabelaIzdanja tabelaIzdanja;
	private TabelaModelIzdanja tabelaModelIzdanja;
	
	public PrikazIzdanja(Knjiga knjiga) {
		setSize(new Dimension(800, 600));
		setTitle("Izdanja");
		setLocationRelativeTo(null);
		setResizable(false);
		setName("Izdanja");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		
//		jeloKontroler = new JeloKontroler();
//		tipJelaKontroler = new TipJelaKontroler();
		try {
			//dobavi izdanja
			this.izdanja = new ArrayList<>();
			Izdanje i = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, null, null, null);
			List<Zanr> zi = new ArrayList<Zanr>();
			Zanr z = new Zanr("Z");
			Zanr a = new Zanr("A");
			Zanr n = new Zanr("N");
			Zanr r = new Zanr("R");
			zi.add(z);
			zi.add(a);
			zi.add(n);
			zi.add(r);
			i.setZanrovi(zi);
			
			this.izdanja.add(i);
			Izdanje i1 = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, TipKoricenja.TVRD_POVEZ, null, null);
			List<Autor> autori = new ArrayList<Autor>();
			Autor autor1 = new Autor("Ime", "Prezime", null, null, null);
			Autor autor2 = new Autor("Ime2", "Prezime2", null, null, null);
			autori.add(autor1);
			autori.add(autor2);
			i1.setAutori(autori);
			this.izdanja.add(i1);
			Izdanje i2 = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, TipKoricenja.MEK_POVEZ, null, null);
			this.izdanja.add(i2);
			Izdanje i3 = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, null, null, null);
			this.izdanja.add(i3);
			Izdanje i4 = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, null, null, null);
			this.izdanja.add(i4);
			//this.izdanja = jeloKontroler.dobaviJelaSaCenama();
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
        tabelaIzdanja.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(tabelaIzdanja);
		scrollPane.setPreferredSize(new Dimension(800, 500));

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


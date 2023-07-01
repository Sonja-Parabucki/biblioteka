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
import model.Zanr;
import net.miginfocom.swing.MigLayout;
import pogled.tabela.TabelaKnjiga;
import pogled.tabela.TabelaModelKnjiga;
import util.PogledUtil;

public class PrikazKnjiga extends JFrame {

	private static final long serialVersionUID = 4175309540188497204L;
	private List<Izdanje> izdanja;
	//kontroleri
	
	private TabelaKnjiga tabelaKnjiga;
	private TabelaModelKnjiga tabelaModelKnjiga;
	
	public PrikazKnjiga(Biblioteka biblioteka) {
		setSize(new Dimension(800, 600));
		setTitle("Knjige");
		setLocationRelativeTo(null);
		setResizable(false);
		setName("Knjige");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		
//		jeloKontroler = new JeloKontroler();
//		tipJelaKontroler = new TipJelaKontroler();
		try {
			//dobavi izdanja
//			this.izdanja = new ArrayList<>();
//			Izdanje i = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, null, null, null);
//			List<Zanr> zi = new ArrayList<Zanr>();
//			Zanr z = new Zanr("Z");
//			Zanr a = new Zanr("A");
//			Zanr n = new Zanr("N");
//			Zanr r = new Zanr("R");
//			zi.add(z);
//			zi.add(a);
//			zi.add(n);
//			zi.add(r);
//			i.setZanrovi(zi);
//			
//			this.izdanja.add(i);
//			Izdanje i1 = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, TipKoricenja.TVRD_POVEZ, null, null);
//			List<Autor> autori = new ArrayList<Autor>();
//			Autor autor1 = new Autor("Ime", "Prezime", null, null, null);
//			Autor autor2 = new Autor("Ime2", "Prezime2", null, null, null);
//			autori.add(autor1);
//			autori.add(autor2);
//			i1.setAutori(autori);
//			this.izdanja.add(i1);
//			Izdanje i2 = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, TipKoricenja.MEK_POVEZ, null, null);
//			this.izdanja.add(i2);
//			Izdanje i3 = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, null, null, null);
//			this.izdanja.add(i3);
//			Izdanje i4 = new Izdanje("A", "A", null, null, "a", "UDK", "ISBN", null, null, null, null);
//			this.izdanja.add(i4);
			//this.izdanja = jeloKontroler.dobaviJelaSaCenama();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Labela lblNaslov = new Labela("Knjige", fntNaslov, clrForeground);
	

		FormaDugme btnIzdanja = new FormaDugme("Pogledaj izdanja", clrPrimarna, clrForeground, 150, 20);
		btnIzdanja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				   int selectedRow = tabelaKnjiga.getSelectedRow();

                   if (selectedRow != -1) {
                       // Get the values from the selected row
//                       String name = tabelaKnjiga.getValueAt(selectedRow, 0).toString();
//                       String position = tabelaKnjiga.getValueAt(selectedRow, 1).toString();
//                       int age = Integer.parseInt(tabelaKnjiga.getValueAt(selectedRow, 2).toString());
                	   Izdanje izdanje = tabelaModelKnjiga.getIzdanje(selectedRow);
                       // Do something with the selected item
                       System.out.println("Selected item: " + izdanje);
                   } else {
                       // No row selected
                       System.out.println("No item selected.");
                   }
//				DijalogDodavanjeJela dijalogDodavanjeJela = new DijalogDodavanjeJela(jeloKontroler, naziviTipovaJela, (TabelaModelJelovnik) tabelaJelovnik.getModel());
//				dijalogDodavanjeJela.setVisible(true);
			}
		});
				
		setLayout(new MigLayout("", "30[]40[]", "5[]5[]40[]"));
		
		add(lblNaslov, "wrap, span2, align center");
		add(btnIzdanja, "cell 0 2, wrap, align left");
		if (biblioteka.getPrijavljeniKorisnik().getTip() != TipNaloga.VISI_BIBLIOTEKAR) {
			btnIzdanja.setVisible(false);

		}
		this.inicijalizujTabeluZaposlenih();
	}

	private void inicijalizujTabeluZaposlenih() {
		
		tabelaModelKnjiga = new TabelaModelKnjiga(izdanja);
		this.tabelaKnjiga = new TabelaKnjiga(tabelaModelKnjiga);
        tabelaKnjiga.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(tabelaKnjiga);
		scrollPane.setPreferredSize(new Dimension(800, 500));

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelKnjiga model = (TabelaModelKnjiga) tabelaKnjiga.getModel();
		model.fireTableDataChanged();
		validate();
	}
}

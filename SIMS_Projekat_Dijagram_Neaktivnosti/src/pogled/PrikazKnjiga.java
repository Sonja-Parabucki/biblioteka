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
import pogled.tabela.TabelaKnjiga;
import pogled.tabela.TabelaModelKnjiga;
import util.PogledUtil;

public class PrikazKnjiga extends JFrame {

	private static final long serialVersionUID = 4175309540188497204L;
	private List<Knjiga> izdanja;
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
//			this.izdanja = jeloKontroler.dobaviJelaSaCenama();
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
//                	   Izdanje izdanje = tabelaModelKnjiga.getIzdanje(selectedRow);
//                       System.out.println("Selected item: " + izdanje);
                   } else {
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

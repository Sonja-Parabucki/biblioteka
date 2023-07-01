package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import enumeracije.TipKoricenja;
import enumeracije.TipNaloga;
import kontroleri.IzdanjaKontroler;
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
	private List<Izdanje> izdanja;
	//kontroleri
	
	private TabelaKnjiga tabelaKnjiga;
	private TabelaModelKnjiga tabelaModelKnjiga;
	private IzdanjaKontroler izdanjaKontroler;
	
	public PrikazKnjiga(Biblioteka biblioteka) {
		setSize(new Dimension(1000, 600));
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
			izdanjaKontroler = new IzdanjaKontroler(biblioteka);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			System.out.println("");
			this.izdanja = izdanjaKontroler.nadjiSveKnjige();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Labela lblNaslov = new Labela("Knjige", fntNaslov, clrForeground);
	

		FormaDugme btnIzdanja = new FormaDugme("Prikazi izdanja", clrPrimarna, clrForeground, 150, 20);
		btnIzdanja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				   int selectedRow = tabelaKnjiga.getSelectedRow();

                   if (selectedRow != -1) {

                	   Izdanje izdanje = tabelaModelKnjiga.getIzdanje(selectedRow);
                	   PrikazIzdanja prikaz = new PrikazIzdanja(izdanje, biblioteka);
                	   prikaz.setVisible(true);
                   } else {
                       JOptionPane.showMessageDialog(null, "Niste izabrali knjigu.");
                   }
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
		JScrollPane scrollPane = new JScrollPane(tabelaKnjiga);
		scrollPane.setPreferredSize(new Dimension(900, 500));

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

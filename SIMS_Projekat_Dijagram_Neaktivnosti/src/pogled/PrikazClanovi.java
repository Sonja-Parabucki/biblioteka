package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import enumeracije.TipNaloga;
import kontroleri.IzdanjaKontroler;
import kontroleri.KorisnikKontroler;
import model.Biblioteka;
import model.Clan;
import model.Izdanje;
import net.miginfocom.swing.MigLayout;
import pogled.tabela.TabelaClanovi;
import pogled.tabela.TabelaKnjiga;
import pogled.tabela.TabelaModelClanovi;
import pogled.tabela.TabelaModelKnjiga;
import util.PogledUtil;

public class PrikazClanovi extends JFrame {

	private static final long serialVersionUID = 8975687317591663060L;
	private List<Clan> clanovi;
	//kontroleri
	
	private TabelaClanovi tabelaClanovi;
	private TabelaModelClanovi tabelaModelClanovi;
	
	public PrikazClanovi(Biblioteka biblioteka) {
		setSize(new Dimension(1000, 600));
		setTitle("Clanovi");
		setLocationRelativeTo(null);
		setResizable(false);
		setName("Clanovi");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		
		KorisnikKontroler kk = new KorisnikKontroler(biblioteka);
		
		try {
			System.out.println("");
			this.clanovi = kk.getClanovi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Labela lblNaslov = new Labela("Clanovi", fntNaslov, clrForeground);
	

		FormaDugme btnIzdanja = new FormaDugme("Izmeni clana", clrPrimarna, clrForeground, 150, 20);
		btnIzdanja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				   int selectedRow = tabelaClanovi.getSelectedRow();

                   if (selectedRow != -1) {

                	   Clan clan = tabelaModelClanovi.getClan(selectedRow);
                	   
                	   //prozor za izmenu
                	   
                   } else {
                       JOptionPane.showMessageDialog(null, "Niste izabrali clana.");
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
		
		tabelaModelClanovi = new TabelaModelClanovi(clanovi);
		this.tabelaClanovi = new TabelaClanovi(tabelaModelClanovi);
		JScrollPane scrollPane = new JScrollPane(tabelaClanovi);
		scrollPane.setPreferredSize(new Dimension(900, 500));

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelClanovi model = (TabelaModelClanovi) tabelaClanovi.getModel();
		model.fireTableDataChanged();
		validate();
	}
}

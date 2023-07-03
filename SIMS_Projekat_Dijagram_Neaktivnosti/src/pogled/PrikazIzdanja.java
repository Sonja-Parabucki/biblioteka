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
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
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
		
		FormaDugme btnPrimerci = new FormaDugme("Prikazi primerke", clrPrimarna, clrForeground, 150, 20);
		btnPrimerci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				   int selectedRow = tabelaIzdanja.getSelectedRow();

                   if (selectedRow != -1) {

                	   Izdanje izdanje = tabelaModelIzdanja.getIzdanje(selectedRow);
                	   PrikazPrimerci prikaz = new PrikazPrimerci(biblioteka, izdanje);
                	   prikaz.setVisible(true);
                   } else {
                       JOptionPane.showMessageDialog(null, "Niste izabrali knjigu.");
                   }
                   
			}
		});
		
		FormaDugme btnIzmeni = new FormaDugme("Izmeni izdanje", clrPrimarna, clrForeground, 150, 20);
		btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			   int selectedRow = tabelaIzdanja.getSelectedRow();
               if (selectedRow != -1) {

            	   Izdanje izdanje = tabelaModelIzdanja.getIzdanje(selectedRow);
            	   FormaIzdanje prozor = new FormaIzdanje(biblioteka, izdanje);
            	   prozor.setVisible(true);
               } else {
                   JOptionPane.showMessageDialog(null, "Niste izabrali izdanje.");
               }
			}
		});
	
				
		setLayout(new MigLayout("", "30[]40[]", "5[]5[]40[]"));
		
		add(lblNaslov, "wrap, span2, align center");
		add(btnPrimerci, "cell 0 2, wrap, align left");
		add(btnIzmeni, "cell 1 2, wrap, align left");
		
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


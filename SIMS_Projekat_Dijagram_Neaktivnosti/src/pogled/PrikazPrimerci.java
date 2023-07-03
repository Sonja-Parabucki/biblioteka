package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import enumeracije.TipNaloga;
import kontroleri.IzdanjaKontroler;
import kontroleri.PrimerakKontroler;
import model.Biblioteka;
import model.Izdanje;
import model.Primerak;
import net.miginfocom.swing.MigLayout;
import pogled.tabela.TabelaKnjiga;
import pogled.tabela.TabelaModelKnjiga;
import pogled.tabela.TabelaModelPrimerci;
import pogled.tabela.TabelaPrimerci;
import util.PogledUtil;
import util.Validacija;

public class PrikazPrimerci extends JFrame{

	private static final long serialVersionUID = -3938021684626508651L;
	private List<Primerak> primerci;
	
	private TabelaPrimerci tabelaPrimerci;
	private TabelaModelPrimerci tabelaModelPrimerci;
	private IzdanjaKontroler izdanjaKontroler;
	
	public PrikazPrimerci(Biblioteka biblioteka, Izdanje izdanje) {
		setSize(new Dimension(1000, 600));
		setTitle("Primerci");
		setLocationRelativeTo(null);
		setResizable(false);
		setName("Primerci");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		try {
			izdanjaKontroler = new IzdanjaKontroler(biblioteka);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			System.out.println("");
			this.primerci = izdanje.getPrimerci();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Labela lblNaslov = new Labela("Primerci", fntNaslov, clrForeground);
		
		FormaDugme btnIzmeni = new FormaDugme("Izmeni cenu", clrPrimarna, clrForeground, 150, 20);
		btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			   int selectedRow = tabelaPrimerci.getSelectedRow();
               if (selectedRow != -1) {
            	   Primerak primerak = tabelaModelPrimerci.getPrimerak(selectedRow);
        		   String cena = JOptionPane.showInputDialog(null, "Nova vrednost nabavne cene:", primerak.getNabavnaCena());
        		   if (Validacija.proveriCenu(cena)) {
        			   double nova = Double.parseDouble(cena);
        			   try {
        				   PrimerakKontroler primerakKontroler = new PrimerakKontroler(biblioteka);
        				   primerakKontroler.promeniCenu(primerak.getInventarniBroj(), nova);
        				   izdanjaKontroler.promeniCenu(izdanje.getId(), primerak.getInventarniBroj(), nova);
        				   dispose();
        				   primerak.setNabavnaCena(nova);
        				   PrikazIzdanja prikaz = new PrikazIzdanja(izdanje, biblioteka);
        				   prikaz.setVisible(true);
        				   PrikazPrimerci prikazp = new PrikazPrimerci(biblioteka, izdanje);
        				   prikazp.setVisible(true);
        				   
        			   } catch(IOException e1) {
        				   JOptionPane.showMessageDialog(null, "Greska pri upisu u fajlove.");
        			   }
        		   }
            	   
               } else {
                   JOptionPane.showMessageDialog(null, "Niste izabrali izdanje.");
               }
			}
		});
				
		setLayout(new MigLayout("", "30[]40[]", "5[]5[]40[]"));
		
		add(lblNaslov, "wrap, span2, align center");
		add(btnIzmeni, "wrap");
		this.inicijalizujTabeluZaposlenih();
	}

	private void inicijalizujTabeluZaposlenih() {
		
		tabelaModelPrimerci = new TabelaModelPrimerci(primerci);
		this.tabelaPrimerci = new TabelaPrimerci(tabelaModelPrimerci);
		JScrollPane scrollPane = new JScrollPane(tabelaPrimerci);
		scrollPane.setPreferredSize(new Dimension(900, 500));

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelPrimerci model = (TabelaModelPrimerci) tabelaPrimerci.getModel();
		model.fireTableDataChanged();
		validate();
	}
}

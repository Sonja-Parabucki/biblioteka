package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.Adresa;
import model.Izdavac;
import model.Mesto;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class FormaIzdavac extends JDialog {

	private static final long serialVersionUID = -8296361196495461922L;
	
	private TekstPolje tfIzdavac;
	private TekstPolje tfUlica;
	private TekstPolje tfBroj;
	private TekstPolje tfMesto;
	private TekstPolje tfPpt;
	
	private FormaIzdanje prozor;
	private PadajucaLista stari;
	private ArrayList<Izdavac> izdavaci;
	
	public FormaIzdavac(FormaIzdanje prozor) {
		this.prozor = prozor;
		
		setSize(new Dimension(500, 600));
		setLocationRelativeTo(null);
		setTitle("Dodavanje izdavaca");
		setResizable(false);
		
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		this.getContentPane().setBackground(clrPrimarna);
		
		Labela lblIzdavac = new Labela("Naziv:", fntLabela, clrTercijarna);
		tfIzdavac = new TekstPolje("", fntTekstPolje, 240, 30);
		
		Labela lblUlica = new Labela("Ulica:", fntLabela, clrTercijarna);
		tfUlica = new TekstPolje("", fntTekstPolje, 240, 30);
		
		Labela lblBroj = new Labela("Broj:", fntLabela, clrTercijarna);
		tfBroj = new TekstPolje("", fntTekstPolje, 80, 30);
		
		Labela lblMesto = new Labela("Mesto:", fntLabela, clrTercijarna);
		tfMesto = new TekstPolje("", fntTekstPolje, 240, 30);
		
		Labela lblPpt = new Labela("PPT:", fntLabela, clrTercijarna);
		tfPpt = new TekstPolje("", fntTekstPolje, 140, 30);
		
		FormaDugme btnDodaj = new FormaDugme("Dodaj izdanje", clrSekundarna, clrForeground, 150, 20);
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (stari.getSelectedIndex() > -1) {
					prozor.setIzdavac(izdavaci.get(stari.getSelectedIndex()));
					zatvori();
				} 
				else {
					String naziv = tfIzdavac.getText();
					String ulica = tfUlica.getText();
					String broj = tfBroj.getText();
					String mesto = tfMesto.getText();
					String ppt = tfPpt.getText();
					
					if (naziv.isEmpty() || ulica.isEmpty() || broj.isEmpty() || mesto.isEmpty() || ppt.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nisu uneti svi podaci.", "Fale podaci", JOptionPane.ERROR_MESSAGE);
					}
					try {
						
						Mesto m = new Mesto(mesto, Integer.parseInt(ppt));
						Adresa a = new Adresa(ulica, broj, m);
						Izdavac iz = new Izdavac(naziv, a);
						prozor.setIzdavac(iz);
						zatvori();
						
					}
					catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "PPT mora da bude broj.", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		
		izdavaci = new ArrayList<Izdavac>(prozor.kontroler.nadjiSveIzdavace());
		String[] opcije = new String[izdavaci.size()];
		
		int i=0;
		for (Izdavac iz:izdavaci) {
			opcije[i] = iz.toString();
			i++;
		}
		Labela lblStari = new Labela("Ili odabedite prethodno unetog izdavaca:", fntLabela, clrTercijarna);
		stari = new PadajucaLista(opcije, clrSekundarna, clrForeground, fntTekstPolje, 140, 30);
		
		
		setLayout(new MigLayout("", "30[]25[]25", "30[]30[]15[]15[]15[]15[]15[]40[]"));
		
		add(lblIzdavac);
		add(tfIzdavac, "wrap");
		
		add(lblUlica);
		add(tfUlica, "wrap");
		
		add(lblBroj);
		add(tfBroj, "wrap");
		
		add(lblMesto);
		add(tfMesto, "wrap");
		
		add(lblPpt);
		add(tfPpt, "wrap");
		
		add(lblStari, "wrap, span2, align center");
		add(stari, "wrap, span2, align center");
		
		add(btnDodaj, "wrap, span2, align center");
	}
	
	
	private void zatvori() {
		this.dispose();
	}

}

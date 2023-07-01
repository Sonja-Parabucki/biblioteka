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

import model.Autor;
import model.Zanr;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class FormaAutor extends JDialog {

	private static final long serialVersionUID = 6157297328909748092L;
	
	private TekstPolje tfIme;
	private TekstPolje tfPrezime;
	private TekstPolje tfDatRodj;
	private TekstPolje tfDatSmrt;
	
	private FormaIzdanje prozor;
	private PadajucaLista stari;
	private ArrayList<Autor> autori;
	
	public FormaAutor(FormaIzdanje prozor) {
		this.prozor = prozor;
		
		setSize(new Dimension(500, 600));
		setLocationRelativeTo(null);
		setTitle("Dodavanje autora");
		setResizable(false);
		
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		this.getContentPane().setBackground(clrPrimarna);
		
		Labela lblIme = new Labela("Ime:", fntLabela, clrTercijarna);
		tfIme = new TekstPolje("", fntTekstPolje, 240, 30);
		
		Labela lblPrezime = new Labela("Prezime:", fntLabela, clrTercijarna);
		tfPrezime = new TekstPolje("", fntTekstPolje, 240, 30);
		
		Labela lblDatRodj = new Labela("Godina rođenja:", fntLabela, clrTercijarna);
		tfDatRodj = new TekstPolje("", fntTekstPolje, 80, 30);
		
		Labela lblDatSmrt = new Labela("Godina smrti:", fntLabela, clrTercijarna);
		tfDatSmrt = new TekstPolje("", fntTekstPolje, 240, 30);
		
		
		autori = new ArrayList<Autor>(prozor.kontroler.nadjiSveAutore());
		String[] opcije = new String[autori.size()];
		int i=0;
		for (Autor a:autori) {
			opcije[i] = a.toString();
			i++;
		}
		Labela lblStari = new Labela("ili odabedite prethodno unetog autora:", fntLabela, clrTercijarna);
		stari = new PadajucaLista(opcije, clrSekundarna, clrForeground, fntTekstPolje, 140, 30);
		
		
		
		FormaDugme btnDodajNovi = new FormaDugme("Dodaj novog autora", clrSekundarna, clrForeground, 150, 20);
		btnDodajNovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ime = tfIme.getText();
				String prz = tfPrezime.getText();
				String datr = tfDatRodj.getText();
				String dats = tfDatSmrt.getText();
				
				if (ime.isEmpty() || prz.isEmpty() || datr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nisu uneti svi podaci.", "Fale podaci", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Autor aut = new Autor(ime, prz, datr, dats);
					prozor.dodajAutora(aut);
					zatvori();
				}
			}
		});
		
		FormaDugme btnDodajStari = new FormaDugme("Dodaj autora sa liste", clrSekundarna, clrForeground, 150, 20);
		btnDodajStari.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (stari.getSelectedIndex() != -1) {
					prozor.dodajAutora(autori.get(stari.getSelectedIndex()));
					zatvori();
				}
			}
		});
		
		setLayout(new MigLayout("", "30[]25[]25", "30[]30[]15[]15[]15[]15[]15[]40[]"));
		
		add(lblIme);
		add(tfIme, "wrap");
		
		add(lblPrezime);
		add(tfPrezime, "wrap");
		
		add(lblDatRodj);
		add(tfDatRodj, "wrap");
		
		add(lblDatSmrt);
		add(tfDatSmrt, "wrap");
		
		add(btnDodajNovi, "wrap, span2, align center");
		
		add(lblStari, "wrap, span2, align center");
		add(stari, "wrap, span2, align center");
		
		add(btnDodajStari, "wrap, span2, align center");
	}
	
	
	private void zatvori() {
		this.dispose();
	}

}

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

import model.Zanr;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class FormaZanr extends JDialog {

	private static final long serialVersionUID = -6349441936710377269L;
	
	private TekstPolje tfNaziv;
	private FormaIzdanje prozor;
	private PadajucaLista stari;
	private ArrayList<Zanr> zan;
	
	public FormaZanr(FormaIzdanje prozor) {
		this.prozor = prozor;
		
		setSize(new Dimension(500, 400));
		setLocationRelativeTo(null);
		setTitle("Dodavanje zanra");
		setResizable(false);
		
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		this.getContentPane().setBackground(clrPrimarna);
		
		Labela lblNaziv = new Labela("Naziv:", fntLabela, clrTercijarna);
		tfNaziv = new TekstPolje("", fntTekstPolje, 240, 30);
		
		zan = new ArrayList<Zanr>(prozor.kontroler.nadjiSveZanrove());
		String[] opcije = new String[zan.size()];
		int i=0;
		for (Zanr a:zan) {
			opcije[i] = a.toString();
			i++;
		}
		Labela lblStari = new Labela("ili odabedite prethodno uneti zanr:", fntLabela, clrTercijarna);
		stari = new PadajucaLista(opcije, clrSekundarna, clrForeground, fntTekstPolje, 140, 30);
		
		FormaDugme btnDodajNovi = new FormaDugme("Dodaj novi zanr", clrSekundarna, clrForeground, 150, 20);
		btnDodajNovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String naziv = tfNaziv.getText();
				if (naziv.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nisu uneti svi podaci.", "Fale podaci", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Zanr z = new Zanr(naziv);
					prozor.dodajZanr(z);
					zatvori();
				}
				
			}
		});
		
		FormaDugme btnDodajStari = new FormaDugme("Dodaj zanr iz liste", clrSekundarna, clrForeground, 150, 20);
		btnDodajStari.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stari.getSelectedIndex() != -1) {
					prozor.dodajZanr(zan.get(stari.getSelectedIndex()));
					zatvori();
				}
			}
		});
		
		
		setLayout(new MigLayout("", "30[]25[]25", "30[]30[]15[]15[]15[]15[]15[]40[]"));
		
		add(lblNaziv);
		add(tfNaziv, "wrap");
		
		add(btnDodajNovi, "wrap, span2, align center");
		
		add(lblStari, "wrap, span2, align center");
		add(stari, "wrap, span2, align center");
		
		add(btnDodajStari, "wrap, span2, align center");
		
	}
	
	
	private void zatvori() {
		this.dispose();
	}


}

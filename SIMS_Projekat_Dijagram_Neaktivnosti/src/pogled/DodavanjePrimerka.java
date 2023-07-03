package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import izuzeci.BadFormatException;
import kontroleri.IzdanjaKontroler;
import kontroleri.PrimerakKontroler;
import model.Biblioteka;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class DodavanjePrimerka extends JFrame {
	private TekstPolje tfCena;
	private PadajucaLista plIzdanja;
	
	private IzdanjaKontroler izdanjaKontroler;
	private PrimerakKontroler primerakKontroler;
	public DodavanjePrimerka(Biblioteka biblioteka) {
		JPanel panel = new JPanel();
		
		setSize(new Dimension(800, 600));
		setTitle("Dodavanje primerka");
		setLocationRelativeTo(null);
		setResizable(false);
		
		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();

		panel.setBackground(clrPrimarna);
		
		try {
			this.izdanjaKontroler = new IzdanjaKontroler(biblioteka);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String[] izdanja = new String[biblioteka.getIzdanja().size()];
		for(int i=0; i<biblioteka.getIzdanja().size(); i++) {
			izdanja[i] = biblioteka.getIzdanja().get(i).toString();
		}
		
		this.primerakKontroler = new PrimerakKontroler(biblioteka);
		this.tfCena = new TekstPolje("", fntTekstPolje, 120, 20);
		this.plIzdanja = new PadajucaLista(izdanja, clrSekundarna, clrForeground, fntTekstPolje, 120, 20);
		Labela lblNaslov = new Labela("Dodavanje primerka", fntNaslov, clrForeground);
		Labela lblCena = new Labela("Unesite cenu", fntLabela, clrForeground);
		Labela lblIzdanje = new Labela("Odaberite izdanje", fntLabela, clrForeground);
		FormaDugme dugme = new FormaDugme("Unesite primerak", clrPrimarna, clrForeground, 70, 30);

		dugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					primerakKontroler.dodajPrimerak(tfCena.getText(), plIzdanja.getSelectedIndex());
					JOptionPane.showMessageDialog(null,  "Uspešno dodat primerak!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
				} catch (BadFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		panel.setLayout(new MigLayout("wrap 2", "180[]200[]", "80[]100[]100[]"));
		
		panel.add(lblNaslov, "span 2, wrap, align center");
		panel.add(lblCena);
		panel.add(tfCena, "wrap");
		panel.add(lblIzdanje);
		panel.add(plIzdanja, "wrap");
		panel.add(dugme, "span2, align center");
		add(panel);
	}
}

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

import enumeracije.StanjePrimerka;
import kontroleri.IznajmljivanjeKontroler;
import model.Biblioteka;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class VracanjePogled extends JFrame {
	private IznajmljivanjeKontroler iznajmljivanjeKontroler;
	private PadajucaLista primerci;
	private PadajucaLista stanja;
	public VracanjePogled(Biblioteka biblioteka) {
		JPanel panel = new JPanel();
		
		setSize(new Dimension(800, 600));
		setTitle("Vracanje");
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
			this.iznajmljivanjeKontroler = new IznajmljivanjeKontroler(biblioteka);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String[] primerciNazivi = iznajmljivanjeKontroler.dobaviNazivePrimeraka(StanjePrimerka.IZNAJMLJEN);
		String[] stanjaNazivi = {"Nije ostecen", "Ostecen"};
		this.primerci = new PadajucaLista(primerciNazivi, clrSekundarna, clrForeground, fntTekstPolje, 120, 20);
		this.stanja = new PadajucaLista(stanjaNazivi, clrSekundarna, clrForeground, fntTekstPolje, 120, 20);
		
		Labela lblNaslov = new Labela("Vracanje primerka", fntNaslov, clrForeground);
		Labela lblPrimerak = new Labela("Izaberite primerak", fntLabela, clrForeground);
		Labela lblStanje = new Labela("Stanje primerka pri povracaju", fntLabela, clrForeground);
		
		FormaDugme dugme = new FormaDugme("Vrati", clrPrimarna, clrForeground, 70, 30);

		dugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					iznajmljivanjeKontroler.vratiKnjigu(Integer.parseInt((String)primerci.getSelectedItem()), stanja.getSelectedIndex());
					JOptionPane.showMessageDialog(null,  "Uspešno vracen primerak!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		panel.setLayout(new MigLayout("wrap 2", "140[]200[]", "80[]100[]100[]"));
		
		panel.add(lblNaslov, "span 2, wrap, align center");
		panel.add(lblPrimerak);
		panel.add(primerci, "wrap");
		panel.add(lblStanje);
		panel.add(stanja, "wrap");
		panel.add(dugme, "span2, align center");
		add(panel);
	}
}

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
import izuzeci.BadCredentialsException;
import izuzeci.NotFoundException;
import kontroleri.IznajmljivanjeKontroler;
import model.Biblioteka;
import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class IznajmljivanjePogled extends JFrame {
	private IznajmljivanjeKontroler iznajmljivanjeKontroler;
	private PadajucaLista primerci;
	private PadajucaLista clanovi;
	public IznajmljivanjePogled(Biblioteka biblioteka) {
		JPanel panel = new JPanel();
		
		setSize(new Dimension(800, 600));
		setTitle("Iznajmljivanje");
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
		
		
		String[] primerciNazivi = iznajmljivanjeKontroler.dobaviNazivePrimeraka(StanjePrimerka.DOSTUPAN);
		String[] clanoviNazivi = iznajmljivanjeKontroler.dobaviNaziveClanova();
		this.primerci = new PadajucaLista(primerciNazivi, clrSekundarna, clrForeground, fntTekstPolje, 120, 20);
		this.clanovi = new PadajucaLista(clanoviNazivi, clrSekundarna, clrForeground, fntTekstPolje, 120, 20);
		
		Labela lblNaslov = new Labela("Iznajmljivanje primerka", fntNaslov, clrForeground);
		Labela lblClan = new Labela("Izaberite clana", fntLabela, clrForeground);
		Labela lblPrimerak = new Labela("Izaberite primerak", fntLabela, clrForeground);
		
		FormaDugme dugme = new FormaDugme("Iznajmi", clrPrimarna, clrForeground, 70, 30);

		dugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					iznajmljivanjeKontroler.iznajmiKnjigu(((String)clanovi.getSelectedItem()).split(",")[0], Integer.parseInt((String)primerci.getSelectedItem()));
					JOptionPane.showMessageDialog(null,  "Uspešno iznajmljen primerak!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				catch(BadCredentialsException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Prekoracena granica", JOptionPane.ERROR_MESSAGE);
				}
				catch(NotFoundException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Neuplacena clanarina", JOptionPane.ERROR_MESSAGE);
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		panel.setLayout(new MigLayout("wrap 2", "120[]200[]", "80[]100[]100[]"));
		
		panel.add(lblNaslov, "span 2, wrap, align center");
		panel.add(lblClan);
		panel.add(clanovi, "wrap");
		panel.add(lblPrimerak);
		panel.add(primerci, "wrap");
		panel.add(dugme, "span2, align center");
		add(panel);
	}
}
